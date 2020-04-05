package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.service.biz.dao.SubjectAnswerDao;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xym
 */
@Service
public class SubjectAnswerServiceImpl extends ServiceImpl<SubjectAnswerDao, SubjectAnswer> implements SubjectAnswerService {
}
