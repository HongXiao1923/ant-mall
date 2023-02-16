package ryan.ant.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description", required = false,
            defaultValue = "springboot-thymeleaf") String description){
        request.setAttribute("description", description);
        return  "thymeleaf";
    }

    @GetMapping("/attributes")
    public String attributes(ModelMap map){
        map.put("title", "Thymeleaf 标签演示");
        map.put("th_id", "Thymeleaf-input");
        map.put("th_name", "Thymeleaf-input");
        map.put("th_value", "12");
        map.put("th_class", "Thymeleaf-class");
        map.put("th_href", "http://www.baidu.com");

        return "attributes";
    }

    @GetMapping("/simple")
    public String simple(ModelMap map){
        map.put("thymeleafText", "spring-boot");
        map.put("number1", 2021);
        map.put("number2", 2);

        return "simple";
    }

    @GetMapping("/complex")
    public String complex(ModelMap map){
        map.put("title", "Thymeleaf 语法测试");
        map.put("testString", "Spring Boot 商城");
        map.put("bool", true);
        map.put("testArray", new Integer[]{2021, 2022, 2023, 2024});
        map.put("testList", Arrays.asList("Spring", "Boot", "Thymeleaf", "MySQL"));
        Map m = new HashMap();
        m.put(1, "一");
        m.put(2, "二");
        m.put(3, "三");
        map.put("testMap", m);
        map.put("testDate", new Date());

        return "complex";
    }
}
