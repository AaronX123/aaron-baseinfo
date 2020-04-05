package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.SubjectAnswerDto;
import aaron.baseinfo.api.dto.SubjectDto;
import aaron.baseinfo.service.biz.service.SubjectAnswerService;
import aaron.baseinfo.service.biz.service.SubjectService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.pojo.model.Subject;
import aaron.baseinfo.service.pojo.vo.SubjectVo;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xym
 */
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
    public CommonResponse<Boolean> saveSubject(@RequestBody @Valid CommonRequest<SubjectVo> request){
        SubjectDto subjectDto = CommonUtils.copyProperties(request.getData(),SubjectDto.class);
        List<SubjectAnswerDto> answerDtoList = CommonUtils.convertList(request.getData().getSubjectAnswerVOList(),SubjectAnswerDto.class);
        subjectService.saveSubjectAndAnswer(subjectDto,answerDtoList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_SUBJECT_LIST)
    public CommonResponse<Boolean> deleteSubjectList(@RequestBody @Valid CommonRequest<List<SubjectVo>> request){
        List<Subject> subjects = CommonUtils.convertList(request.getData(),Subject.class);
        for (Subject subject : subjects) {
            subject.setJudgeId(CommonUtils.judgeCompanyAndOrg());
        }
        subjectService.deleteSubjectAndAnswer(subjects);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }
}
