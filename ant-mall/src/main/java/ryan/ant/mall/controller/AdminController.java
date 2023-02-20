package ryan.ant.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ryan.ant.mall.entity.AdminUser;
import ryan.ant.mall.service.AdminUserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/indexAll")
    public String indexAll(){
        return "admin/indexAll";
    }

    @GetMapping({"login"})
    public String login(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password,
                        @RequestParam("vertifyCode") String vertifyCode, HttpSession session){
        if(StringUtils.isEmpty(vertifyCode)){
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        String captchaCode = session.getAttribute("verifyCode") + "";
        if(StringUtils.isEmpty(captchaCode) || !vertifyCode.toLowerCase().equals(captchaCode)){
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
        /* Todo 查询数据库记录*/
        AdminUser adminUser = adminUserService.login(userName, password);
        if(adminUser != null){  //验证成功，则注入session
            session.setAttribute("loginUser", adminUser.getNickName());
            session.setAttribute("loginUserId", adminUser.getAdminUserId());
            /* Todo 设置session过期时间为3小时*/
            session.setMaxInactiveInterval(3600 * 3);
            return "redirect:/admin/index";
        }else{
            session.setAttribute("errorMsg", "登录失败");
            return "admin/login";
        }
    }
}
