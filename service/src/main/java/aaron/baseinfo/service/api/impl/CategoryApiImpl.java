package aaron.baseinfo.service.api.impl;

import aaron.baseinfo.api.api.CategoryApi;
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
public class CategoryApiImpl implements CategoryApi {
    /**
     * 根据CategoryID获取Category值
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_CATEGORY)
    @Override
    public CommonResponse<BaseDataDto> listCategory(@RequestBody @Valid CommonRequest<BaseDataDto> request) {
        return null;
    }
}
