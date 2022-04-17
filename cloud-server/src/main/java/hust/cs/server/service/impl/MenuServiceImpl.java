package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.mapper.MenuMapper;
import hust.cs.server.pojo.Admin;
import hust.cs.server.pojo.Menu;
import hust.cs.server.service.IMenuService;
import hust.cs.server.utils.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qpphust
 * @since 2022-03-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        //获取不到就去数据库查
        if (CollectionUtils.isEmpty(menus)) {
            menus=menuMapper.getMenusByAdminId(adminId);
            //查到了再存在redis中
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;
    }

    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /***
     * @author Sunny
     * @description 查询所有的菜单（大菜单加小菜单）
     * @createTime  2022/3/27 17:25
     * @param
     * @return void
     **/
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
