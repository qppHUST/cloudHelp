package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.mapper.EmployeeMapper;
import hust.cs.server.mapper.MailLogMapper;
import hust.cs.server.pojo.*;
import hust.cs.server.service.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static hust.cs.server.pojo.MailConstants.*;

/**
 * ClassName: EmployeeServiceImpl
 * PackageName:hust.cs.server.service.impl
 * Description:
 * date: 2022/3/28 14:49
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailLogMapper mailLogMapper;

    @Override
    public RespPageBean getEmployeeByPage(Integer currntPage
            , Integer size, Employee employee, LocalDate[] beginDateScope) {
        //开启分页
        Page<Employee> page = new Page<>(currntPage,size);
        IPage<Employee> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDateScope);
        return new RespPageBean(employeeByPage.getTotal(),employeeByPage.getRecords());
    }

    /***
     * @author Sunny
     * @description
     * @createTime  2022/3/28 16:01
     * @param
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    public RespBean getMaxWorkID() {
        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));
        int i = Integer.parseInt(maps.get(0).get("max(workID)").toString())+1;
        String format = String.format("%08d", i);
        return RespBean.success(null,format);
    }

    /***
     * @author Sunny
     * @description 添加员工
     * @createTime  2022/3/28 16:21
     * @param employee
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    public RespBean addEmp(Employee employee) {
        //处理合同期限，保留两位小数
        LocalDate beginContract = employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        long until = beginContract.until(endContract, ChronoUnit.DAYS);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(until/365.00)));
        if(employeeMapper.insert(employee)==1){
            //先消息入库
            String msgId = UUID.randomUUID().toString();
            MailLog mailLog = new MailLog();
            mailLog.setMsgId(msgId);
            mailLog.setEid(employee.getId());
            mailLog.setStatus(0);
            mailLog.setRouteKey(MAIL_ROUTING_KEY_NAME);
            mailLog.setExchange(MAIL_EXCHANGE);
            mailLog.setCount(0);
            mailLog.setTryTime(LocalDateTime.now().plusMinutes(MSG_TIMEOUT));
            mailLog.setCreateTime(LocalDateTime.now());
            mailLog.setUpdateTime(LocalDateTime.now());
            mailLogMapper.insert(mailLog);

            //再发送消息
            Employee employee1 = employeeMapper.getEmployee(employee.getId()).get(0);
            rabbitTemplate.convertAndSend(MAIL_EXCHANGE,MAIL_ROUTING_KEY_NAME
                    ,employee1,new CorrelationData(msgId));
            return RespBean.success("添加员工成功");
        }
        return RespBean.error("添加员工失败");
    }

    /***
     * @author Sunny
     * @description 查询员工，
     * @createTime  2022/3/28 17:42
     * @param id
     * @return java.util.List<hust.cs.server.pojo.Employee>
     **/
    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }

    /***
     * @author Sunny
     * @description 获取所有员工账套
     * @createTime  2022/3/29 21:11
     * @param currentPage, size
     * @return hust.cs.server.pojo.RespPageBean
     **/
    @Override
    public RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size) {
        //设置分页
        Page<Employee> page = new Page<>(currentPage,size);
        IPage<Employee> employeeIPage = employeeMapper.getEmployeeWithSalary(page);
        return new RespPageBean(employeeIPage.getTotal(),employeeIPage.getRecords());
    }



}
