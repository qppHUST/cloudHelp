package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.mapper.MenuRoleMapper;
import hust.cs.server.pojo.MenuRole;
import hust.cs.server.pojo.RespBean;
import hust.cs.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /***
     * @author Sunny
     * @description 更新菜单角色表,更新角色对应的权限有什么
     * @createTime  2022/3/27 18:15
     * @param rid, mids
     * @return hust.cs.server.pojo.RespBean
     **/
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid,Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(null==mids||mids.length==0){
            return RespBean.success("更新成功");
        }
        Integer integer = menuRoleMapper.insertRecord(rid, mids);
        if(integer==mids.length){
            return RespBean.success("修改了"+integer+"条数据");
        }
        return RespBean.error("修改失败");
    }
}
