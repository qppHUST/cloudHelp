package hust.cs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hust.cs.server.pojo.Department;
import hust.cs.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartment();

    RespBean addDep(Department department);

    RespBean deleteDep(Integer id);
}
