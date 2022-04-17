package hust.cs.server.controller;

import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.AdminLogin;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * ClassName: LoginController
 * PackageName:hust.cs.server.controller
 * Description:登陆用
 * date: 2022/3/26 11:50
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLogin login, HttpServletRequest request){
        return adminService.login(login.getUsername(),login.getPassword(),login.getCode(),request);
    }

    @ApiOperation(value = "获取当前用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(null==principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        //登录之后设置该用户的权限列表，就是是什么角色
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(HttpServletRequest request){
        System.out.println(request.getRequestURL());
        return RespBean.success("注销成功");
    }
}
