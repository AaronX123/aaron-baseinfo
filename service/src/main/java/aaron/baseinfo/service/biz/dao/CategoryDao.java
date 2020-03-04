package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
