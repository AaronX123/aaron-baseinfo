package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.SubjectTypeDto;
import aaron.baseinfo.service.biz.service.SubjectTypeService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.common.utils.PageMapUtil;
import aaron.baseinfo.service.pojo.model.SubjectType;
import aaron.baseinfo.service.pojo.vo.SubjectQueryVo;
import aaron.baseinfo.service.pojo.vo.SubjectTypeQueryVo;
import aaron.baseinfo.service.pojo.vo.SubjectTypeVo;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
import aaron.common.utils.jwt.UserPermission;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author xym
 */
@RestController
public class SubjectTypeController {
    @Autowired
    SubjectTypeService subjectTypeService;

    @Autowired
    CommonState state;

    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_SUBJECT_TYPE)
    public CommonResponse<Boolean> saveSubjectType(@RequestBody @Valid CommonRequest<SubjectTypeVo> request){
        SubjectTypeDto subjectTypeDto = CommonUtils.copyProperties(request.getData(),SubjectTypeDto.class);
        subjectTypeService.save(subjectTypeDto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_SUBJECT_TYPE)
    public CommonResponse<Boolean> deleteSubjectType(@RequestBody @Valid CommonRequest<List> request){
        List<SubjectType> subjectTypeList = CommonUtils.convertList(request.getData(),SubjectType.class);
        UserPermission userPermission = TokenUtils.getUser();
        for (SubjectType type : subjectTypeList) {
            type.setOrgId(userPermission.getOrgId());
        }
        subjectTypeService.remove(subjectTypeList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.UPDATE_SUBJECT_TYPE)
    public CommonResponse<Boolean> updateSubjectType(@RequestBody @Valid CommonRequest<SubjectTypeVo> request){
        SubjectTypeDto subjectTypeDto = CommonUtils.copyProperties(request.getData(),SubjectTypeDto.class);
        subjectTypeDto.setJudgeId(TokenUtils.getUser().getOrgId());
        subjectTypeDto.setOldVersion(subjectTypeDto.getVersion());
        subjectTypeService.update(subjectTypeDto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_SUBJECT_TYPE)
    public CommonResponse<Map> querySubjectType(@RequestBody @Valid CommonRequest<SubjectTypeQueryVo> request){
        Page<SubjectTypeQueryVo> page = PageHelper.startPage(request.getData().getCurrentPage(),request.getData().getPageSize());
        SubjectType subjectType = CommonUtils.copyProperties(request.getData(),SubjectType.class);
        List<SubjectType> subjectTypeList = subjectTypeService.list(subjectType);
        List<SubjectQueryVo> subjectQueryVoList = CommonUtils.convertList(subjectTypeList,SubjectQueryVo.class);
        Map<String,Object> map = PageMapUtil.getPageMap(subjectQueryVoList,page);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_SUBJECT_TYPE_UPDATE_FORM)
    public CommonResponse<List> querySubjectTypeUpdateForm(@RequestBody @Valid CommonRequest<SubjectTypeQueryVo> request){
        SubjectType subjectType = CommonUtils.copyProperties(request.getData(),SubjectType.class);
        subjectType.setOrgId(TokenUtils.getUser().getOrgId());
        List<SubjectType> subjectTypeList = subjectTypeService.querySubjectTypeUpdateForm(subjectType);
        List<SubjectTypeVo> subjectTypeVoList = CommonUtils.convertList(subjectTypeList,SubjectTypeVo.class);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,subjectTypeVoList);
    }
}
