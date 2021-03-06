package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.SubjectAnswerDto;
import aaron.baseinfo.api.dto.SubjectDto;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.biz.service.SubjectService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.common.utils.PageMapUtil;
import aaron.baseinfo.service.pojo.model.Subject;
import aaron.baseinfo.service.pojo.model.SubjectAnswer;
import aaron.baseinfo.service.pojo.model.SubjectInfo;
import aaron.baseinfo.service.pojo.vo.SubjectAnswerQueryVo;
import aaron.baseinfo.service.pojo.vo.SubjectQueryVo;
import aaron.baseinfo.service.pojo.vo.SubjectVo;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xym
 */
@RequestMapping(ControllerConstant.SUBJECT)
@RestController
public class SubjectController {
    @Autowired
    CommonState state;

    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectAnswerService subjectAnswerService;


    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_SUBJECT)
    public CommonResponse<Boolean> saveSubject(@RequestBody CommonRequest<SubjectVo> request){
        SubjectDto subjectDto = CommonUtils.copyProperties(request.getData(),SubjectDto.class);
        List<SubjectAnswerDto> answerDtoList = CommonUtils.convertList(request.getData().getSubjectAnswerVOList(),SubjectAnswerDto.class);
        subjectService.saveSubjectAndAnswer(subjectDto,answerDtoList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_SUBJECT_LIST)
    public CommonResponse<Boolean> deleteSubjectList(@RequestBody CommonRequest<List<SubjectVo>> request){
        List<Subject> subjects = CommonUtils.convertList(request.getData(),Subject.class);
        for (Subject subject : subjects) {
            subject.setJudgeId(CommonUtils.judgeCompanyAndOrg());
        }
        subjectService.deleteSubjectAndAnswer(subjects);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }


    @MethodEnhancer
    @PostMapping(ControllerConstant.UPDATE_SUBJECT)
    public CommonResponse<Boolean> updateSubject(@RequestBody CommonRequest<SubjectVo> request){
        SubjectDto subjectDto = CommonUtils.copyProperties(request.getData(),SubjectDto.class);
        List<SubjectAnswerDto> subjectAnswerDtoList = CommonUtils.convertList(request.getData().getSubjectAnswerVOList(),SubjectAnswerDto.class);
        try {
            subjectService.updateSubject(subjectDto,subjectAnswerDtoList);
        }catch (Exception e){
            throw new BaseInfoException(BaseInfoError.SUBJECT_UPDATE_FAIL);
        }
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_SUBJECT)
    public CommonResponse<Map> querySubject(@RequestBody CommonRequest<SubjectQueryVo> request){
        Page<SubjectQueryVo> page = PageHelper.startPage(request.getData().getCurrentPage(),request.getData().getPageSize());
        Subject subject = CommonUtils.copyProperties(request.getData(),Subject.class);
        subject.setJudgeId(CommonUtils.judgeCompanyAndOrg());
        List<SubjectInfo> subjectList = subjectService.listSubject(subject);
        List<SubjectQueryVo> voList = new ArrayList<>();
        for (SubjectInfo subjectInfo : subjectList) {
            voList.add(SubjectQueryVo.builder().id(subjectInfo.getId()).name(subjectInfo.getName()).difficulty(subjectInfo.getDifficulty())
                    .subjectTypeId(subjectInfo.getSubjectTypeId()).categoryId(subjectInfo.getCategoryId()).categoryName(subjectInfo.getCategoryName())
                    .subjectTypeName(subjectInfo.getSubjectTypeName()).difficultyName(subjectInfo.getDifficultyName()).updatedTime(subjectInfo.getUpdatedTime()).build()
            );
        }
        Map<String,Object> map = PageMapUtil.getPageMap(voList,page);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_ANSWER)
    public CommonResponse<List> queryAnswer(@RequestBody CommonRequest<SubjectAnswerQueryVo> request){
        long subjectId = request.getData().getSubjectId();
        List<SubjectAnswer> answerList = subjectAnswerService.listAnswerBySubjectId(subjectId);
        List<SubjectAnswerQueryVo> voList = CommonUtils.convertList(answerList,SubjectAnswerQueryVo.class);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,voList);
    }
}
