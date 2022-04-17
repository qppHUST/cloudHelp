package hust.cs.server.service.impl;

import hust.cs.server.pojo.Admin;
import hust.cs.server.mapper.AdminMapper;
import hust.cs.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
