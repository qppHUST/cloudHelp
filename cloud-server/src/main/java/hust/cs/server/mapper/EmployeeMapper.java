package hust.cs.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hust.cs.server.pojo.Employee;
import hust.cs.server.pojo.EmployeeEc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: EmployeeMapper
 * PackageName:hust.cs.server.mapper
 * Description:
 * date: 2022/3/28 14:51
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    /***
     * @author Sunny
     * @description 获取多个员工并分页
     * @createTime  2022/3/28 14:55
     * @param page, employee, beginDateScope
     * @return com.baomidou.mybatisplus.core.metadata.IPage<hust.cs.server.pojo.Employee>
     **/
    IPage<Employee> getEmployeeByPage(Page<Employee> page
            , @Param("employee") Employee employee
            , @Param("beginDateScope") LocalDate[] beginDateScope);

    /***
     * @author Sunny
     * @description 获得员工，
     * @createTime  2022/3/28 17:43
     * @param id
     * @return java.util.List<hust.cs.server.pojo.Employee>
     **/
    List<Employee> getEmployee(Integer id);

    /***
     * @author Sunny
     * @description 获取员工账套
     * @createTime  2022/3/29 21:14
     * @param page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<hust.cs.server.pojo.Employee>
     **/
    IPage<Employee> getEmployeeWithSalary(Page<Employee> page);
}
