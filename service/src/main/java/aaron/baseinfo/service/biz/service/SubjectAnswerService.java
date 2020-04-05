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
    boolean removeBatchBySubjectId(@Param(value = "idList") List<Long> subjectIdList);
}
