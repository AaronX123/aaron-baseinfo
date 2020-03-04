package aaron.baseinfo.api.api;

import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-03
 */

public interface SubjectApi {
    /**
     * 根据组卷配置获取试卷
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_AND_ANSWER)
    CommonResponse<SubjectPackage> getSubjectAndAnswer(CommonRequest<Long> request);

    /**
     * 根据用户在线选择的组卷配置明细进行选择试题
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_CUSTOMIZED)
    CommonResponse<SubjectPackage> getSubjectAndAnswerCustomized(CommonRequest<List<CombExamConfigItemDto>> request);
}
