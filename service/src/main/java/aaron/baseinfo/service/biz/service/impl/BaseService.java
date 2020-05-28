package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.service.common.constant.EnumUserInfoType;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.manage.UserApi;
import aaron.common.data.common.CacheConstants;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.data.exception.StarterError;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-05
 */
@Service
public class BaseService {
    @Autowired
    UserApi userApi;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    CommonState state;

    /**
     * 根据Id和类型获取用户数据
     * @param id
     * @param type
     * @return
     */
    public String getUserInfo(long id, EnumUserInfoType type){
        Cache cache;
        switch (type){
            case ORG:
                cache = cacheManager.getCache(CacheConstants.ORG_VAL);
                break;
            case USER:
                cache = cacheManager.getCache(CacheConstants.USER_VAL);
                break;
            case COMPANY:
                cache = cacheManager.getCache(CacheConstants.COMPANY_VAL);
                break;
            default:
                throw new BaseInfoException(StarterError.SYSTEM_CACHE_TYPE_INVALID);
        }
        Cache.ValueWrapper wrapper = cache.get(id);
        if (wrapper == null){
            String value = queryFromApi(id, type);
            if (value == null){
                throw new BaseInfoException(StarterError.SYSTEM_RPC_ERROR);
            }
            cache.put(id,value);
            return value;
        }
        return (String) wrapper.get();
    }

    public String queryFromApi(long id, EnumUserInfoType type){
        CommonResponse<String> response;
        switch (type){
            case COMPANY:
                response = userApi.getCompanyById(new CommonRequest<>(state.getVersion(), TokenUtils.getToken(),id));
                if (CommonUtils.isSuccess(response)){
                    return response.getData();
                }else {
                    throw new BaseInfoException(StarterError.SYSTEM_API_ERROR,response.getMsg());
                }
            case USER:
                response = userApi.getUserNameById(new CommonRequest<>(state.getVersion(), TokenUtils.getToken(),id));
                if (CommonUtils.isSuccess(response)){
                    return response.getData();
                }else {
                    throw new BaseInfoException(StarterError.SYSTEM_API_ERROR,response.getMsg());
                }
            case ORG:
                return null;
            default:
                throw new BaseInfoException(StarterError.SYSTEM_CACHE_TYPE_INVALID);
        }
    }

}
