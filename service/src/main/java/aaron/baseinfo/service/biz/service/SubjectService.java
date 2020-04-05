package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.SubjectAnswerDto;
import aaron.baseinfo.api.dto.SubjectDto;
import aaron.baseinfo.service.pojo.model.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xym
 */
public interface SubjectService extends IService<Subject> {
    /**
     * 保存试题
     * @param dto
     * @param subjectAnswerDtoList
     * @return
     */
    boolean saveSubjectAndAnswer(SubjectDto dto, List<SubjectAnswerDto> subjectAnswerDtoList);

    /**
     * 删除试题，同时删除答案
     * @param subjectList
     * @return
     */
    boolean deleteSubjectAndAnswer(List<Subject> subjectList);
}
