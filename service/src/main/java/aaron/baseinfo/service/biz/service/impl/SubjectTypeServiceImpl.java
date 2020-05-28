package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.SubjectTypeDto;
import aaron.baseinfo.service.biz.dao.SubjectTypeDao;
import aaron.baseinfo.service.biz.service.SubjectTypeService;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.pojo.model.SubjectType;
import aaron.common.aop.annotation.FullCommonField;
import aaron.common.aop.enums.EnumOperation;
import aaron.common.data.common.CacheConstants;
import aaron.common.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xym
 */
@Service
public class SubjectTypeServiceImpl extends ServiceImpl<SubjectTypeDao, SubjectType> implements SubjectTypeService {
    @Autowired
    CacheManager cacheManager;

    @FullCommonField
    @Override
    public boolean save(SubjectTypeDto subjectTypeDto) {
        SubjectType subjectType = CommonUtils.copyProperties(subjectTypeDto,SubjectType.class);
        return save(subjectType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean remove(List<SubjectType> subjectTypeList) {
        return baseMapper.removeBatch(subjectTypeList);
    }

    @FullCommonField(operation = EnumOperation.UPDATE)
    @Override
    public boolean update(SubjectTypeDto subjectType) {
        SubjectType subjectType2 = CommonUtils.copyProperties(subjectType,SubjectType.class);
        return baseMapper.update(subjectType2);
    }

    @Override
    public List<SubjectType> list(SubjectType subjectType) {
        QueryWrapper<SubjectType> wrapper = new QueryWrapper<>();
        wrapper.eq(SubjectType.ORG_ID,subjectType.getOrgId());
        if (StringUtils.isNotBlank(subjectType.getName())){
            wrapper.likeRight(SubjectType.NAME,subjectType.getName());
        }
        wrapper.orderByDesc(SubjectType.UPDATE_TIME);
        return list(wrapper);
    }

    @Override
    public List<SubjectType> querySubjectTypeUpdateForm(SubjectType subjectType) {
        return baseMapper.querySubjectTypeUpdateForm(subjectType);
    }

    @Override
    public List<String> getTypeName(List<Long> idList) {
        List<String> res = new ArrayList<>();
        Cache cache = cacheManager.getCache(CacheConstants.SUBJECT_TYPE_VAL);
        for (Long id : idList) {
            Cache.ValueWrapper valueWrapper = cache.get(id);
            if (valueWrapper == null){
                SubjectType subjectType = getById(id);
                if (subjectType == null){
                    throw new BaseInfoException(BaseInfoError.SUBJECT_TYPE_NOT_EXIST);
                }
                res.add(subjectType.getName());
                cache.put(id,subjectType.getName());
            }else {
                res.add((String) valueWrapper.get());
            }
        }
        return res;
    }

    @Override
    public String getTypeName(Long id) {
        Cache cache = cacheManager.getCache(CacheConstants.SUBJECT_TYPE_VAL);
        Cache.ValueWrapper wrapper = cache.get(id);
        if (wrapper != null){
            return (String) wrapper.get();
        }else {
            QueryWrapper<SubjectType> subjectTypeQueryWrapper = new QueryWrapper<>();
            subjectTypeQueryWrapper.select(SubjectType.ATTRIBUTE);
            subjectTypeQueryWrapper.eq("id",id);
            SubjectType type = getOne(subjectTypeQueryWrapper);
            if (type == null){
                throw new BaseInfoException(BaseInfoError.SUBJECT_TYPE_NOT_EXIST);
            }
            cache.put(id,type.getAttribute());
            return type.getAttribute();
        }
    }
}
