package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hust.cs.server.pojo.AdminRole;
import hust.cs.server.pojo.RespBean;
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
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer addAdminRole(@Param(value = "adminId") Integer adminId, @Param(value = "rids") Integer[] rids);
}
