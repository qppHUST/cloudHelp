package hust.cs.server.service.impl;

import hust.cs.server.pojo.MailLog;
import hust.cs.server.mapper.MailLogMapper;
import hust.cs.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
