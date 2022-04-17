package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hust.cs.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Mapper
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /***
     * @author Sunny
     * @description 更新角色菜单，本质上是插入，因为在之前删除了
     * @createTime  2022/3/27 18:07
     * @param rid, mids
     * @return java.lang.Integer
     **/

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
