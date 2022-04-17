package hust.cs.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hust.cs.server.pojo.MenuRole;
import hust.cs.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid,Integer[] mids);
}
