package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hust.cs.server.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /***
     * @author Sunny
     * @description 通过用户ID查询菜单列表
     * @createTime  2022/3/27 9:45
     * @param id
     * @return java.util.List<hust.cs.server.pojo.Menu>
     **/
    List<Menu> getMenusByAdminId(Integer id);

    /***
     * @author Sunny
     * @description 根据角色获取菜单列表
     * @createTime  2022/3/27 12:24
     * @param
     * @return java.util.List<hust.cs.server.pojo.Menu>
     **/
    List<Menu> getMenusWithRole();

    /***
     * @author Sunny
     * @description 查询所有菜单
     * @createTime  2022/3/27 17:28
     * @param
     * @return java.util.List<hust.cs.server.pojo.Menu>
     **/
    List<Menu> getAllMenus();
}
