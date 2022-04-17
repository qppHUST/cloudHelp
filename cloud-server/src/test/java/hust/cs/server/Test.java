package hust.cs.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hust.cs.server.mapper.EmployeeMapper;
import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.Employee;
import hust.cs.server.service.IAdminService;
import hust.cs.server.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Test
 * PackageName:hust.cs.server
 * Description:
 * date: 2022/3/29 21:40
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@SpringBootTest
public class Test {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IAdminService adminService;

    @org.junit.jupiter.api.Test
    public void a(){
        IPage<Employee> employeeWithSalary = employeeMapper.getEmployeeWithSalary(new Page<>(1, 10));
        List<Employee> records = employeeWithSalary.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
    }

//    @org.junit.jupiter.api.Test
//    public void b(){
//        ArrayList a = new ArrayList();
//        a.
//    }

    @org.junit.jupiter.api.Test
    public void b(){
//        Admin admin = new Admin();
//        admin.set
//        adminService.save();
    }


}
