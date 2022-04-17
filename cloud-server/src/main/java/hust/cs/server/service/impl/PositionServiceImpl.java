package hust.cs.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hust.cs.server.mapper.PositionMapper;
import hust.cs.server.pojo.Position;
import hust.cs.server.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
