package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.CategoryDto;
import aaron.baseinfo.service.biz.dao.CategoryDao;
import aaron.baseinfo.service.biz.service.CategoryService;
import aaron.baseinfo.service.common.constant.CacheConstants;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.pojo.model.Category;
import aaron.baseinfo.service.pojo.model.TreeList;
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
 * @since 2020-03-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
    @Autowired
    CacheManager cacheManager;

    /**
     * 保存，为了使用切面进行公共字段填充
     *
     * @param dto
     * @return
     */
    @FullCommonField
    @Override
    public boolean save(CategoryDto dto) {
        Category category = CommonUtils.copyProperties(dto,Category.class);
        return save(category);
    }

    /**
     * 更新，为了使用切面进行公共字段填充
     *
     * @param dto
     * @return
     */
    @FullCommonField(operation = EnumOperation.UPDATE)
    @Override
    public boolean update(CategoryDto dto) {
        Category category = CommonUtils.copyProperties(dto,Category.class);
        try {
            return updateById(category);
        }catch (Exception e){
            throw new BaseInfoException(BaseInfoError.CATEGORY_UPDATE_FAIL);
        }
    }

    /**
     * 根据名称和父节点列出题目类型
     *
     * @param category
     * @return
     */
    @Override
    public List<Category> listByName(Category category) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.likeRight(Category.NAME,category.getName());
        wrapper.eq(Category.ORG_ID,category.getOrgId());
        wrapper.eq(Category.PARENT_ID,category.getParentId());
        wrapper.orderByDesc(Category.UPDATE_TIME);
        return list(wrapper);
    }

    /**
     * 根据OrgId和ParentId获取
     *
     * @param category
     * @return
     */
    @Override
    public List<TreeList> getTree(Category category) {
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq(Category.ORG_ID,category.getOrgId());
        categoryQueryWrapper.orderByDesc(Category.PARENT_ID);
        List<Category> categoryList = list(categoryQueryWrapper);
        return CommonUtils.convertList(categoryList,TreeList.class);
    }

    /**
     * 根据Id获取题目类型
     *
     * @param categoryIdList
     * @return
     */
    @Override
    public List<String> getCategoryName(List<Long> categoryIdList) {
        List<String> res = new ArrayList<>();
        for (Long id : categoryIdList) {
            Cache cache = cacheManager.getCache(CacheConstants.CATEGORY_ID);
            Cache.ValueWrapper wrapper = cache.get(id);
            Category category;
            if (wrapper == null){
                category = getById(id);
                cache.put(id,category);
            }else {
                category = (Category) wrapper.get();
            }
            if (category == null){
                throw new BaseInfoException(BaseInfoError.CATEGORY_NOT_EXIST);
            }
            res.add(category.getName());
        }
        return res;
    }
}
