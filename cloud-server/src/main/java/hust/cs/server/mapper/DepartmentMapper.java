package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hust.cs.server.pojo.Department;
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
public interface DepartmentMapper extends BaseMapper<Department> {

    /***
     * @author Sunny
     * @description 获得所有部门
     * @createTime  2022/3/27 20:58
     * @param id
     * @return java.util.List<hust.cs.server.pojo.Department>
     **/
    List<Department> getAllDepartment(@Param(value = "id") Integer id);

    /***
     * @author Sunny
     * @description
     * @createTime  2022/3/27 22:00
     * @param department
     * @return void
     **/

    void addDep(Department department);


    void deleteDep(Department department);
}
