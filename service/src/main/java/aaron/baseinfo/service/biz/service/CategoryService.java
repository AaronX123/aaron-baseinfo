package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.CategoryDto;
import aaron.baseinfo.service.pojo.model.Category;
import aaron.baseinfo.service.pojo.model.TreeList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
public interface CategoryService extends IService<Category> {
    /**
     * 保存，为了使用切面进行公共字段填充
     * @param dto
     * @return
     */
    boolean save(CategoryDto dto);
    /**
     * 更新，为了使用切面进行公共字段填充
     * @param dto
     * @return
     */
    boolean update(CategoryDto dto);

    /**
     * 根据名称和父节点列出题目类型
     * @param category
     * @return
     */
    List<Category> listByName(Category category);

    /**
     * 根据OrgId和ParentId获取
     * @param category
     * @return
     */
    List<TreeList> getTree(Category category);

    /**
     * 根据Id获取题目类型
     * @param categoryIdList
     * @return
     */
    List<String> getCategoryName(List<Long> categoryIdList);

    /**
     * 根据节点id查询子节点比如c++ -> c++基础 + c++进阶
    * @param parentId
     * @return
     */
    List<Category> queryChildNode(Long parentId);

    String getCategoryNameById(Long id);
}
