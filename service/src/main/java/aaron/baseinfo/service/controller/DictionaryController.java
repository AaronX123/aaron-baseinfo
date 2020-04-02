package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.DictionaryDto;
import aaron.baseinfo.service.biz.service.DictionaryService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.common.utils.PageMapUtil;
import aaron.baseinfo.service.pojo.model.Dictionary;
import aaron.baseinfo.service.pojo.vo.DictionaryListVo;
import aaron.baseinfo.service.pojo.vo.DictionaryQueryVo;
import aaron.baseinfo.service.pojo.vo.DictionaryVo;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
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
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    CommonState state;

    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_DICTIONARY)
    public CommonResponse<Boolean> save(@RequestBody @Valid CommonRequest<DictionaryVo> request){
        DictionaryDto dictionaryDto = CommonUtils.copyProperties(request.getData(),DictionaryDto.class);
        dictionaryService.save(dictionaryDto);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_DICTIONARY)
    public CommonResponse<Boolean> delete(@RequestBody @Valid CommonRequest<List<DictionaryVo>> request){
        List<Dictionary> dictionaryList = CommonUtils.convertList(request.getData(),Dictionary.class);
        for (Dictionary dictionary : dictionaryList) {
            dictionary.setOrgId(TokenUtils.getUser().getOrgId());
        }
        if (dictionaryService.removeByIds(dictionaryList)){
            return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
        }
        throw new BaseInfoException(BaseInfoError.DICTIONARY_DEL_FAIL);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.UPDATE_DICTIONARY)
    public CommonResponse<Boolean> update(@RequestBody @Valid CommonRequest<DictionaryVo> request){
        DictionaryDto dictionaryDto = CommonUtils.copyProperties(request.getData(),DictionaryDto.class);
        dictionaryDto.setOldVersion(dictionaryDto.getVersion());
        dictionaryDto.setOrgId(TokenUtils.getUser().getOrgId());
        if (dictionaryService.update(dictionaryDto)){
            return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
        }
        throw new BaseInfoException(BaseInfoError.DICTIONARY_UPDATE_FAIL);
    }

    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_DICTIONARY)
    public CommonResponse<Map> queryDictionary(@RequestBody CommonRequest<DictionaryQueryVo> request){
        DictionaryQueryVo vo = request.getData();
        Page<DictionaryQueryVo> page = PageHelper.startPage(vo.getCurrentPage(),vo.getPageSize());
        Dictionary dictionary = new Dictionary();
        dictionary.setOrgId(TokenUtils.getUser().getOrgId());
        dictionary.setCategory(vo.getCategory());
        dictionary.setName(vo.getName());
        List<Dictionary> dictionaryList = dictionaryService.queryDictionary(dictionary);
        Map<String,Object> pageMap = PageMapUtil.getPageMap(dictionaryList,page);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,pageMap);
    }


    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_DICTIONARY_VALUE)
    public CommonResponse<List> queryDictionaryValue(@RequestBody CommonRequest<DictionaryQueryVo> request){
        Dictionary dictionary = new Dictionary();
        dictionary.setOrgId(TokenUtils.getUser().getOrgId());
        dictionary.setName(request.getData().getName());
        dictionary.setCategory(request.getData().getCategory());
        List<Dictionary> dictionaryList = dictionaryService.queryDictionary(dictionary);
        List<DictionaryListVo> res = CommonUtils.convertList(dictionaryList,DictionaryListVo.class);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,res);
    }
}
