package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.service.biz.dao.SubjectAnswerDao;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.pojo.model.Subject;
import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 */
@Service
public class SubjectAnswerServiceImpl extends ServiceImpl<SubjectAnswerDao, SubjectAnswer> implements SubjectAnswerService {
    /**
     * @param subjectIdList
     * @return
     */
    @Override
    public boolean removeBatchBySubjectId(List<Long> subjectIdList) {
        return baseMapper.removeBatchBySubjectId(subjectIdList);
    }

    @Override
    public boolean removeBySubjectId(long id) {
        return baseMapper.removeBySubjectId(id);
    }


    @Override
    public List<SubjectAnswer> listAnswerBySubjectId(long subjectId) {
        QueryWrapper<SubjectAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq(SubjectAnswer.SUBJECT_ID,subjectId);
        return list(wrapper);
    }

    @Override
    public List<SubjectAnswer> listAnswer(List<Long> subjectList){
        return baseMapper.querySubjectAnswerBySubjectId(subjectList);
    }
}
