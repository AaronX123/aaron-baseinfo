package aaron.baseinfo.api.api;

import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.BaseDataDto;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
public interface CategoryApi {
    /**
     * 根据CategoryID获取Category值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.LIST_CATEGORY)
    CommonResponse<BaseDataDto> listCategory(CommonRequest<BaseDataDto> request);
}
