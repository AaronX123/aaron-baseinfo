package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.CombExamConfigDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.service.biz.service.CombExamConfigItemService;
import aaron.baseinfo.service.biz.service.CombExamConfigService;
import aaron.baseinfo.service.biz.service.impl.BaseService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.common.constant.EnumUserInfoType;
import aaron.baseinfo.service.common.utils.PageMapUtil;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import aaron.baseinfo.service.pojo.vo.CombExamConfigItemListVo;
import aaron.baseinfo.service.pojo.vo.CombExamConfigListVo;
import aaron.baseinfo.service.pojo.vo.CombExamConfigQueryVo;
import aaron.baseinfo.service.pojo.vo.CombExamConfigVo;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author xym
 */
@RestController
public class CombExamConfigController {
    @Autowired
    CombExamConfigService combExamConfigService;

    @Autowired
    CombExamConfigItemService combExamConfigItemService;

    @Autowired
    CommonState state;

    @Autowired
    BaseService baseService;

    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_COMB_EXAM_CONFIG)
    public CommonResponse<Boolean> save(@RequestBody @Valid CommonRequest<CombExamConfigVo> request){
        CombExamConfigDto dto = CommonUtils.copyProperties(request.getData(),CombExamConfigDto.class);
        dto.setCombExamConfigItemDtoList(CommonUtils.convertList(request.getData().getCombExamConfigItemVOs(),CombExamConfigItemDto.class));
        combExamConfigService.saveCombExamConfigItem(dto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }


    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_CEC)
    public CommonResponse<Boolean> delete(@RequestBody @Valid CommonRequest<List<CombExamConfigVo>> request){
        List<CombExamConfigVo> voList = request.getData();
        List<CombExamConfigDto> dtoList = CommonUtils.convertList(voList,CombExamConfigDto.class);
        for (CombExamConfigDto dto : dtoList) {
            dto.setJudgeId(CommonUtils.judgeCompanyAndOrg());
        }
        combExamConfigService.deleteCombExamConfig(dtoList);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }


    @MethodEnhancer
    @PostMapping(ControllerConstant.UPDATE_CEC)
    public CommonResponse<Boolean> update(@RequestBody @Valid CommonRequest<CombExamConfigVo> request){
        CombExamConfigDto dto = CommonUtils.copyProperties(request.getData(),CombExamConfigDto.class);
        dto.setOldVersion(dto.getVersion());
        dto.setJudgeId(CommonUtils.judgeCompanyAndOrg());
        dto.setCombExamConfigItemDtoList(CommonUtils.convertList(request.getData().getCombExamConfigItemVOs(),CombExamConfigItemDto.class));
        combExamConfigService.updateCombExamConfig(dto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }


    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_CONFIG)
    public CommonResponse<Map> queryCombExamConfig(@RequestBody @Valid CommonRequest<CombExamConfigQueryVo> request){
        Page<CombExamConfigQueryVo> page = PageHelper.startPage(request.getData().getCurrentPage(),request.getData().getPageSize());
        List<CombExamConfig> configList = combExamConfigService.listById(CommonUtils.copyProperties(request.getData(),CombExamConfig.class));
        List<CombExamConfigListVo> voList = CommonUtils.convertList(configList,CombExamConfigListVo.class);
        for (CombExamConfigListVo listVo : voList) {
            if (listVo.getCompanyId() != null){
                listVo.setCompany(baseService.getUserInfo(listVo.getCompanyId(), EnumUserInfoType.COMPANY));
            }
            if (listVo.getUpdatedBy() != null){
                listVo.setUpdatedByName(baseService.getUserInfo(listVo.getUpdatedBy(),EnumUserInfoType.USER));
            }
        }
        Map<String,Object> pageMap = PageMapUtil.getPageMap(voList,page);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,pageMap);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_CONFIG_ITEM)
    public CommonResponse queryCombExamConfigItem(@RequestBody @Valid CommonRequest<CombExamConfigQueryVo> request){
        Page<CombExamConfigQueryVo> page = PageHelper.startPage(request.getData().getCurrentPage(),request.getData().getPageSize());
        CombExamConfigItem item = CommonUtils.copyProperties(request.getData(),CombExamConfigItem.class);
        List<CombExamConfigItem> combExamConfigItemList = combExamConfigItemService.listByCombExamId(item);
        List<CombExamConfigItemListVo> voList = CommonUtils.convertList(combExamConfigItemList,CombExamConfigItemListVo.class);
        Map<String,Object> pageMap = PageMapUtil.getPageMap(voList,page);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,pageMap);
    }
}
