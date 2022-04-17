package hust.cs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hust.cs.server.pojo.Employee;
import hust.cs.server.pojo.EmployeeEc;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: IEmployeeService
 * PackageName:hust.cs.server.service
 * Description:
 * date: 2022/3/28 14:48
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
public interface IEmployeeService extends IService<Employee> {
    RespPageBean getEmployeeByPage(Integer currntPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    RespBean getMaxWorkID();

    RespBean addEmp(Employee employee);

    List<Employee> getEmployee(Integer id);

    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
