package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.DictionaryDto;
import aaron.baseinfo.service.biz.dao.DictionaryDao;
import aaron.baseinfo.service.biz.service.DictionaryService;
import aaron.baseinfo.service.common.constant.CacheConstants;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.pojo.model.Dictionary;
import aaron.common.aop.annotation.FullCommonField;
import aaron.common.aop.enums.EnumOperation;
import aaron.common.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-02
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, Dictionary> implements DictionaryService {
    @Autowired
    CacheManager cacheManager;

    /**
     * 获取字典值
     *
     * @param idList
     * @return
     */
    @Override
    public List<String> getDictionary(List<Long> idList) {
        List<String> stringList = new ArrayList<>();
        for (Long id : idList) {
            Dictionary dictionary;
            Cache cache = cacheManager.getCache(CacheConstants.DICTIONARY_ID);
            Cache.ValueWrapper valueWrapper = cache.get(id);
            if (valueWrapper == null){
                dictionary = getById(id);
                cache.put(id,dictionary);
            }else {
                dictionary = (Dictionary) valueWrapper.get();
            }
            if (dictionary == null){
                throw new BaseInfoException(BaseInfoError.DICTIONARY_NOT_EXIST);
            }
            stringList.add(dictionary.getName());
        }
        return stringList;
    }

    /**
     * 获取值
     *
     * @param id
     * @return
     */
    @Override
    public String getDictionaryValue(long id) {
        Dictionary dictionary;
        Cache cache = cacheManager.getCache(CacheConstants.DICTIONARY_ID);
        Cache.ValueWrapper valueWrapper = cache.get(id);
        if (valueWrapper == null){
            dictionary = getById(id);
            cache.put(id,dictionary);
        }else {
            dictionary = (Dictionary) valueWrapper.get();
        }
        if (dictionary == null){
            throw new BaseInfoException(BaseInfoError.DICTIONARY_NOT_EXIST);
        }
        return dictionary.getName();
    }

    /**
     * @param dictionaryDto
     * @return
     */
    @FullCommonField
    @Override
    public boolean save(DictionaryDto dictionaryDto) {
        Dictionary dictionary = CommonUtils.copyProperties(dictionaryDto,Dictionary.class);
        if (save(dictionary)){
            return true;
        }
        throw new BaseInfoException(BaseInfoError.DICTIONARY_SAVE_FAIL);
    }

    /**
     * 更新
     *
     * @param dictionaryDto
     * @return
     */
    @FullCommonField(operation = EnumOperation.UPDATE)
    @Override
    public boolean update(DictionaryDto dictionaryDto) {
        Dictionary dictionary = CommonUtils.copyProperties(dictionaryDto,Dictionary.class);
        return updateById(dictionary);
    }

    /**
     * 查询
     *
     * @param dictionary
     * @return
     */
    @Override
    public List<Dictionary> queryDictionary(Dictionary dictionary) {
        QueryWrapper<Dictionary> wrapper = new QueryWrapper<>();
        wrapper.likeRight(Dictionary.NAME,dictionary.getName());
        wrapper.likeRight(Dictionary.CATEGORY,dictionary.getCategory());
        wrapper.eq(Dictionary.ORG_ID,dictionary.getOrgId());
        wrapper.orderByDesc(Dictionary.UPDATE_TIME);
        return list(wrapper);
    }
}
