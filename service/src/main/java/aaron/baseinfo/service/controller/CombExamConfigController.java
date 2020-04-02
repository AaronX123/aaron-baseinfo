package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.CombExamConfigDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.service.biz.service.CombExamConfigService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import aaron.baseinfo.service.pojo.vo.CombExamConfigVo;
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

/**
 * @author xym
 */
@RestController
public class CombExamConfigController {
    @Autowired
    CombExamConfigService combExamConfigService;

    @Autowired
    CommonState state;

    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_COMB_EXAM_CONFIG)
    public CommonResponse<Boolean> save(@RequestBody @Valid CommonRequest<CombExamConfigVo> request){
        CombExamConfigDto dto = CommonUtils.copyProperties(request.getData(),CombExamConfigDto.class);
        dto.setCombExamConfigItemDtoList(CommonUtils.convertList(request.getData().getCombExamConfigItemVOs(),CombExamConfigItemDto.class));
        combExamConfigService.saveCombExamConfigItem(dto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

}
