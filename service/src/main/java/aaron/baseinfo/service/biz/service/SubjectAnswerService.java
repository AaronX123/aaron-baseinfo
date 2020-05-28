package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xym
 */
public interface SubjectAnswerService extends IService<SubjectAnswer> {
    /**
     *
     * @param subjectIdList
     * @return
     */
    void removeBatchBySubjectId(List<Long> subjectIdList);


    boolean removeBySubjectId(long id);


    List<SubjectAnswer> listAnswerBySubjectId(long subjectId);

    List<SubjectAnswer> listAnswer(List<Long> subjectList);
}
