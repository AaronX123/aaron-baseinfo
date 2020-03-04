package aaron.baseinfo.service.api.impl;

import aaron.baseinfo.api.api.DictionaryApi;
import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.BaseDataDto;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@RestController
public class DictionaryApiImpl implements DictionaryApi {
    /**
     * 获取字典值
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATAS)
    @Override
    public CommonResponse<BaseDataDto> getBaseDataS(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return null;
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
        return null;
    }
}
