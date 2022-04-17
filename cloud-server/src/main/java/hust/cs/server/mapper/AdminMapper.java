package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.RespBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface AdminMapper extends BaseMapper<Admin> {

    /***
     * @author Sunny
     * @description 获取所有的操作员
     * @createTime  2022/3/28 10:02
     * @param id, keywords
     * @return java.util.List<hust.cs.server.pojo.Admin>
     **/
    List<Admin> getAllAdmins(@Param(value = "id") Integer id, @Param(value = "keywords") String keywords);

}
