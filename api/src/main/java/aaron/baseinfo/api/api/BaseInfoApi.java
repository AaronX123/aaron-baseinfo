package aaron.baseinfo.api.api;

import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.BaseDataDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-05
 */
public interface BaseInfoApi {
    /**
     * 根据CategoryID获取Category值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_CATEGORY)
    CommonResponse<BaseDataDto> listCategory(CommonRequest<BaseDataDto> request);
    /**
     * 获取字典值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATAS)
    CommonResponse<BaseDataDto> getBaseDataS(CommonRequest<BaseDataDto> request);

    /**
     * 通过Id获取对应字典值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATA)
    CommonResponse<String> getBaseData(CommonRequest<Long> request);
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

    /**
     * 通过试题Id来获取题目和答案
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_SUBJECT_BY_ID)
    CommonResponse<SubjectPackage> getSubjectById(CommonRequest<List<Long>> request);
    /**
     * 获取题目类型
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_SUBJECT_TYPE)
    CommonResponse<BaseDataDto> getSubjectType(CommonRequest<BaseDataDto> request);

    @PostMapping(ApiConstant.GET_CATEGORY_VAL)
    CommonResponse<String> getCategory(Long id);

    @PostMapping(ApiConstant.GET_SUBJECT_TYPE)
    CommonResponse<String> getSubjectType(Long id);
}
