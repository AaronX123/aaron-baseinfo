package aaron.baseinfo.service.api.impl;

import aaron.baseinfo.api.api.BaseInfoApi;
import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.BaseDataDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.baseinfo.service.biz.service.CategoryService;
import aaron.baseinfo.service.biz.service.DictionaryService;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-05
 */
public class BaseInfoApiImpl implements BaseInfoApi {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CommonState state;

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 根据CategoryID获取Category值
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_CATEGORY)
    @Override
    public CommonResponse<BaseDataDto> listCategory(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        BaseDataDto dataDto = request.getData();
        List<Long> idList = new ArrayList<>(dataDto.getBaseInfoMap().keySet());
        List<String> values = categoryService.getCategoryName(idList);
        Map<Long,String> map = resolve(idList,values,dataDto.getBaseInfoMap());
        dataDto.setBaseInfoMap(map);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,dataDto);
    }

    private Map<Long,String> resolve(List<Long> idList, List<String> valueList, Map<Long,String> map){
        for (int i = 0; i < idList.size(); i++) {
            map.put(idList.get(i),valueList.get(i));
        }
        return map;
    }
    /**
     * 获取字典值
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATAS)
    @Override
    public CommonResponse<BaseDataDto> getBaseDataS(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        BaseDataDto dataDto = request.getData();
        List<Long> idList = new ArrayList<>(dataDto.getBaseInfoMap().keySet());
        List<String> values = dictionaryService.getDictionary(idList);
        Map<Long,String> map = resolve(idList,values,dataDto.getBaseInfoMap());
        dataDto.setBaseInfoMap(map);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,dataDto);
    }

    /**
     * 通过Id获取对应字典值
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATA)
    @Override
    public CommonResponse<String> getBaseData(@RequestBody @Valid CommonRequest<Long> request) {
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,dictionaryService.getDictionaryValue(request.getData()));
    }

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

    /**
     * 获取题目类型
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_SUBJECT_TYPE)
    @Override
    public CommonResponse<BaseDataDto> getSubjectType(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return null;
    }
}
