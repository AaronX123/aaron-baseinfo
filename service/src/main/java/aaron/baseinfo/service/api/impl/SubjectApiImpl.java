package aaron.baseinfo.service.api.impl;

import aaron.baseinfo.api.api.SubjectApi;
import aaron.baseinfo.api.api.SubjectTypeApi;
import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@RestController
public class SubjectApiImpl implements SubjectApi {
    /**
     * 根据组卷配置获取试卷
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_AND_ANSWER)
    @Override
    public CommonResponse<SubjectPackage> getSubjectAndAnswer(@RequestBody @Valid CommonRequest<Long> request) {
        return null;
    }

    /**
     * 根据用户在线选择的组卷配置明细进行选择试题
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_CUSTOMIZED)
    @Override
    public CommonResponse<SubjectPackage> getSubjectAndAnswerCustomized(@RequestBody @Valid CommonRequest<List<CombExamConfigItemDto>> request) {
        return null;
    }

    /**
     * 通过试题Id来获取题目和答案
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_BY_ID)
    @Override
    public CommonResponse<SubjectPackage> getSubjectById(@RequestBody @Valid CommonRequest<List<Long>> request) {
        return null;
    }
}
