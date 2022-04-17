package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.mapper.AdminRoleMapper;
import hust.cs.server.pojo.AdminRole;
import hust.cs.server.service.IAdminRoleService;
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
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

}
