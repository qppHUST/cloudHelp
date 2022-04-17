package hust.cs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hust.cs.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
public interface IMenuService extends IService<Menu> {

    /***
     * @author Sunny
     * @description 根据用户id得到其对应的菜单
     * @createTime  2022/3/27 12:20
     * @param
     * @return java.util.List<hust.cs.server.pojo.Menu>
     **/
    List<Menu> getMenusByAdminId();

    /***
     * @author Sunny
     * @description 根据role获取菜单
     * @createTime  2022/3/27 12:22
     * @param
     * @return java.util.List<hust.cs.server.pojo.Menu>
     **/

    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
