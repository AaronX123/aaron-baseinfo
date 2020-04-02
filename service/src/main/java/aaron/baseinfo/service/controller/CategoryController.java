package aaron.baseinfo.service.controller;

import aaron.baseinfo.api.dto.CategoryDto;
import aaron.baseinfo.service.biz.service.CategoryService;
import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.common.utils.PageMapUtil;
import aaron.baseinfo.service.pojo.model.Category;
import aaron.baseinfo.service.pojo.model.TreeList;
import aaron.baseinfo.service.pojo.vo.CategoryListVo;
import aaron.baseinfo.service.pojo.vo.CategoryQueryVo;
import aaron.baseinfo.service.pojo.vo.CategoryVo;
import aaron.baseinfo.service.pojo.vo.TreeListVo;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@RestController
public class CategoryController {
    @Autowired
    CommonState commonState;

    @Autowired
    CategoryService categoryService;

    /**
     * 保存字典值
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ControllerConstant.SAVE_CATEGORY)
    public CommonResponse<Boolean> saveCategory(@RequestBody @Valid CommonRequest<CategoryVo> request){
        CategoryDto category = CommonUtils.copyProperties(request.getData(),CategoryDto.class);
        if (categoryService.save(category)){
            return new CommonResponse<>(commonState.getVersion(),commonState.SUCCESS,commonState.SUCCESS_MSG,true);
        }
        return new CommonResponse<>(commonState.getVersion(),commonState.FAIL,commonState.FAIL_MSG,false);
    }

    /**
     * 删除题目类别
     * @return
     */
    @MethodEnhancer
    @PostMapping(ControllerConstant.DELETE_CATEGORY)
    public CommonResponse<Boolean> deleteCategory(@RequestBody @Valid CommonRequest<List<CategoryVo>> request){
        List<Category> categoryList = CommonUtils.convertList(request.getData(),Category.class);
        for (Category category : categoryList) {
            category.setOrgId(TokenUtils.getUser().getOrgId());
        }
        try {
            categoryService.removeByIds(categoryList);
        }catch (Exception e){
            throw new BaseInfoException(BaseInfoError.CATEGORY_DEL_FAIL);
        }
        return new CommonResponse<>(commonState.getVersion(),commonState.SUCCESS,commonState.SUCCESS_MSG,true);
    }

    /**
     * 更新字典值
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ControllerConstant.UPDATE_CATEGORY)
    public CommonResponse<Boolean> updateCategory(@RequestBody @Valid CommonRequest<CategoryVo> request){
        CategoryDto dto = CommonUtils.copyProperties(request.getData(),CategoryDto.class);
        dto.setOrgId(TokenUtils.getUser().getOrgId());
        dto.setOldVersion(dto.getVersion());
        categoryService.update(dto);
        return new CommonResponse<>(commonState.SUCCESS,commonState.SUCCESS_MSG,true);
    }

    /**
     * 分页查询字典值
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_CATEGORY)
    public CommonResponse<Map> queryCategory(@RequestBody @Valid CommonRequest<CategoryQueryVo> request){
        CategoryQueryVo queryVo = request.getData();
        Page<CategoryQueryVo> page = PageHelper.startPage(queryVo.getCurrentPage(),queryVo.getPageSize());
        Category category = new Category();
        category.setOrgId(TokenUtils.getUser().getOrgId());
        category.setName(queryVo.getName());
        category.setParentId(queryVo.getParentId());
        List<Category> categoryList = categoryService.listByName(category);
        List<CategoryListVo> categoryListVoList = CommonUtils.convertList(categoryList,CategoryListVo.class);
        Map<String,Object> pageMap = PageMapUtil.getPageMap(categoryListVoList,page);
        return new CommonResponse<>(commonState.SUCCESS,commonState.SUCCESS_MSG,pageMap);
    }

    /**
     * 查询题目类型数据
     * @param request
     * @return
     */
    @MethodEnhancer
    @PostMapping(ControllerConstant.QUERY_CATEGORY_INFO)
    public CommonResponse<List> queryCategoryInfo(@RequestBody @Valid CommonRequest<CategoryQueryVo> request){
        Category category = CommonUtils.copyProperties(request.getData(),Category.class);
        category.setOrgId(TokenUtils.getUser().getOrgId());
        List<Category> categoryList = categoryService.listByName(category);
        List<CategoryListVo> res = CommonUtils.convertList(categoryList,CategoryListVo.class);
        return new CommonResponse<>(commonState.SUCCESS,commonState.SUCCESS_MSG,res);
    }

    /**
     * 查询题目类型树
     * @return
     */
    @MethodEnhancer
    @GetMapping(ControllerConstant.QUERY_CATEGORY_TREE)
    public CommonResponse<List> queryCategoryTree(){
        Category category = new Category();
        category.setOrgId(TokenUtils.getUser().getOrgId());
        List<TreeList> treeListList = categoryService.getTree(category);
        List<TreeListVo> res = CommonUtils.convertList(treeListList,TreeListVo.class);
        return new CommonResponse<>(commonState.SUCCESS,commonState.SUCCESS_MSG,res);
    }
}
