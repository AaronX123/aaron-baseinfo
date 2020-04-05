package aaron.baseinfo.service.manage;

import aaron.user.api.constant.ApiConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-05
 */
@FeignClient(value = ApiConstant.SERVICE_NAME)
public interface UserApi extends aaron.user.api.api.UserApi {
}
