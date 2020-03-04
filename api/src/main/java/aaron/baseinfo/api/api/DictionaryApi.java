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
public interface DictionaryApi {
    /**
     * 获取字典值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATAS)
    CommonResponse<BaseDataDto> getBaseDataS(CommonRequest<BaseDataDto> request);

    /**
     * 通过Id获取对应字典值
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.GET_BASE_DATA)
    CommonResponse<String> getBaseData(CommonRequest<Long> request);


}
