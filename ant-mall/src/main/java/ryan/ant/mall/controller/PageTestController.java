package ryan.ant.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ryan.ant.mall.service.impl.UserServiceImpl;
import ryan.ant.mall.util.PageQueryUtil;
import ryan.ant.mall.util.PageResult;
import ryan.ant.mall.util.Result;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class PageTestController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam Map<String, Object> params){
        Result result = new Result();
        if(StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))){
            result.setResultCode(500);
            result.setMessage("参数异常！");
            return result;
        }
        PageQueryUtil queryParamsList = new PageQueryUtil(params);
        PageResult userPage = userServiceImpl.getUserPage(queryParamsList);
        result.setResultCode(200);
        result.setMessage("查询成功！");
        result.setData(userPage);
        return result;
    }
}
