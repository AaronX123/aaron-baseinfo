package aaron.baseinfo.service.api.impl;

import aaron.baseinfo.api.api.BaseInfoApi;
import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.BaseDataDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.baseinfo.service.biz.service.*;
import aaron.baseinfo.service.common.constant.EnumInfoType;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.data.exception.StarterError;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class BaseInfoApiImpl implements BaseInfoApi {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CommonState state;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    CombExamConfigService combExamConfigService;

    @Autowired
    CombExamConfigItemService combExamConfigItemService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectTypeService subjectTypeService;

    /**
     * 根据CategoryID获取Category值
     *
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ApiConstant.LIST_CATEGORY)
    @Override
    public CommonResponse<BaseDataDto> listCategory(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,getBaseInfo(request.getData(),EnumInfoType.CATEGORY));
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
    @MethodEnhancer
    @PostMapping(ApiConstant.GET_BASE_DATAS)
    @Override
    public CommonResponse<BaseDataDto> getBaseDataS(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,getBaseInfo(request.getData(),EnumInfoType.DICTIONARY));
    }

    /**
     * 通过Id获取对应字典值
     *
     * @param request
     * @return
     */
    @MethodEnhancer
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
    @MethodEnhancer
    @PostMapping(ApiConstant.GET_SUBJECT_AND_ANSWER)
    @Override
    public CommonResponse<SubjectPackage> getSubjectAndAnswer(@RequestBody @Valid CommonRequest<Long> request) {
        long combExamConfigId = request.getData();
        CombExamConfigItem config = new CombExamConfigItem();
        config.setCombExamId(combExamConfigId);
        List<CombExamConfigItem> itemList = combExamConfigItemService.listByCombExamId(config);
        SubjectPackage subjectPackage = subjectService.getSubject(itemList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,subjectPackage);
    }

    /**
     * 根据用户在线选择的组卷配置明细进行选择试题
     *
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ApiConstant.GET_SUBJECT_CUSTOMIZED)
    @Override
    public CommonResponse<SubjectPackage> getSubjectAndAnswerCustomized(@RequestBody @Valid CommonRequest<List<CombExamConfigItemDto>> request) {
        List<CombExamConfigItem> combExamConfigItemList = CommonUtils.convertList(request.getData(),CombExamConfigItem.class);
        SubjectPackage subjectPackage = subjectService.getSubject(combExamConfigItemList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,subjectPackage);
    }

    /**
     * 通过试题Id来获取题目和答案
     *
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ApiConstant.GET_SUBJECT_BY_ID)
    @Override
    public CommonResponse<SubjectPackage> getSubjectById(@RequestBody @Valid CommonRequest<List<Long>> request) {
        List<Long> subjectIdList = request.getData();
        SubjectPackage subjectPackage = subjectService.getSubjectById(subjectIdList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,subjectPackage);
    }

    /**
     * 获取题目类型
     *
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ApiConstant.LIST_SUBJECT_TYPE)
    @Override
    public CommonResponse<BaseDataDto> getSubjectType(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,getBaseInfo(request.getData(),EnumInfoType.SUBJECT_TYPE));
    }

    private BaseDataDto getBaseInfo(BaseDataDto baseDataDto, EnumInfoType type){
        List<Long> idList = new ArrayList<>(baseDataDto.getBaseInfoMap().keySet());
        List<String> values;
        switch (type){
            case CATEGORY:
                values = categoryService.getCategoryName(idList);
                break;
            case DICTIONARY:
                values = dictionaryService.getDictionary(idList);
                break;
            case SUBJECT_TYPE:
                values = subjectTypeService.getTypeName(idList);
                break;
            default:
                throw new BaseInfoException(StarterError.SYSTEM_PARAMETER_VALUE_INVALID);
        }
        Map<Long,String> map = resolve(idList,values,baseDataDto.getBaseInfoMap());
        baseDataDto.setBaseInfoMap(map);
        return baseDataDto;
    }
}
