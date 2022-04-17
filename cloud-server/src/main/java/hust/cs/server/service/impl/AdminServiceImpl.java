package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.config.security.component.JwtTokenUtils;
import hust.cs.server.mapper.AdminMapper;
import hust.cs.server.mapper.AdminRoleMapper;
import hust.cs.server.mapper.RoleMapper;
import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.AdminRole;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.pojo.Role;
import hust.cs.server.service.IAdminService;
import hust.cs.server.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /***
     * @author Sunny
     * @description 登录之后返回token
     * @createTime  2022/3/26 12:14
     * @param username, password, request
     * @param code
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        //先得到正确的验证码
        String captcha = (String) request.getSession().getAttribute("captcha");
        //如果用户没输入验证码或者验证码不匹配
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码错误，请重新输入！");
        }
        //登录，但是不会更新令牌
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails==null||!passwordEncoder.matches(password,userDetails.getPassword())){
            //登陆失败
            return RespBean.error("用户名或密码错误");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用,请联系管理员");
        }
        //更新security
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtils.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登陆成功",tokenMap);
    }

    /***
     * @author Sunny
     * @description 根据用户名获取用户
     * @createTime  2022/3/26 12:37
     * @param username
     * @return hust.cs.server.pojo.Admin
     **/
    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username).eq("enabled",true));
    }

/***
 * @author Sunny
 * @description 根据用户id查询角色列表
 * @createTime  2022/3/27 13:13
 * @param adminId
 * @return java.util.List<hust.cs.server.pojo.Role>
 **/
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }

    /***
     * @author Sunny
     * @description 获得所有的操作员
     * @createTime  2022/3/27 22:23
     * @param keywords
     * @return java.util.List<hust.cs.server.pojo.Admin>
     **/
    @Override
    public List<Admin> getAllAdmins(String keywords) {
        return adminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(),keywords);
    }

    /***
     * @author Sunny
     * @description 更新操作员角色
     * @createTime  2022/3/28 10:46
     * @param adminId, rids
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    @Transactional
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {
        adminRoleMapper.delete(new QueryWrapper<AdminRole>().eq("adminId",adminId));
        Integer result = adminRoleMapper.addAdminRole(adminId, rids);
        if(result==rids.length){
            return RespBean.success("更新操作员角色成功");
        }
        return RespBean.error("更新操作员角色失败");
    }

    /***
     * @author Sunny
     * @description 修改密码
     * @createTime  2022/3/29 23:35
     * @param oldPass, pass, adminId
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    public RespBean updateAdminPassword(String oldPass, String pass, Integer adminId) {
        Admin admin = adminMapper.selectById(adminId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //判断旧密码是否正确
        if(encoder.matches(oldPass,admin.getPassword())){
            admin.setPassword(encoder.encode(pass));
            int i = adminMapper.updateById(admin);
            if(1==i){
                return RespBean.success("更新密码成功");
            }
        }
        return RespBean.error("更新密码失败");
    }

    /***
     * @author Sunny
     * @description 更新用户头像
     * @createTime  2022/3/30 15:59
     * @param url, id, authentication
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    public RespBean updateAdminUserFace(String url, Integer id, Authentication authentication) {
        Admin admin = adminMapper.selectById(id);
        admin.setUserFace(url);
        int result = adminMapper.updateById(admin);
        if(1==result){
            Admin principal = (Admin) authentication.getPrincipal();
            principal.setUserFace(url);
            SecurityContextHolder.getContext().setAuthentication
                    (new UsernamePasswordAuthenticationToken(admin,null,authentication.getAuthorities()));
            return RespBean.success("更新成功!",url);
        }
        return RespBean.error("更新失败");
    }
}
