package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.service.biz.dao.CategoryDao;
import aaron.baseinfo.service.biz.service.CategoryService;
import aaron.baseinfo.service.pojo.model.Category;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {


}
