package hust.cs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.Menu;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUserName(String username);

    /***
     * @author Sunny
     * @description 根据用户id得到该用户对应的角色列表
     * @createTime  2022/3/27 13:09
     * @param adminId
     * @return java.util.List<hust.cs.server.pojo.Role>
     **/
    List<Role> getRoles(Integer adminId);

    List<Admin> getAllAdmins(String keywords);

    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);
}
