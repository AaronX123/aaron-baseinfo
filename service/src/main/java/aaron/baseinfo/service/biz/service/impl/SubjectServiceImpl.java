package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.SubjectAnswerDto;
import aaron.baseinfo.api.dto.SubjectDto;
import aaron.baseinfo.service.biz.dao.SubjectDao;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.biz.service.SubjectService;
import aaron.baseinfo.service.pojo.model.Subject;
import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import aaron.common.aop.annotation.FullCommonField;
import aaron.common.utils.CommonUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xym
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {
    @Autowired
    SubjectAnswerService subjectAnswerService;
    /**
     * 保存试题
     *
     * @param dto
     * @param subjectAnswerDtoList
     * @return
     */
    @FullCommonField
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSubjectAndAnswer(SubjectDto dto, List<SubjectAnswerDto> subjectAnswerDtoList) {
        Subject subject = CommonUtils.copyProperties(dto,Subject.class);
        List<SubjectAnswer> answerList = CommonUtils.convertList(subjectAnswerDtoList,SubjectAnswer.class);
        return save(subject) && subjectAnswerService.saveBatch(answerList);
    }

    /**
     * 删除试题，同时删除答案
     *
     * @param subjectList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSubjectAndAnswer(List<Subject> subjectList) {
        return removeByIds(subjectList) && subjectAnswerService.removeBatchBySubjectId(subjectList.stream().map(Subject::getId).collect(Collectors.toList()));
    }
}
