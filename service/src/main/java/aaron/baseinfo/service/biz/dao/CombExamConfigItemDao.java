package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CombExamConfigItemDao extends BaseMapper<CombExamConfigItem> {

    /**
     * 通过组卷配置id查询明细
     * @param item
     * @return
     */
    @Select("SELECT a.*,b.name AS subjectType,c.name AS category,d.value AS difficultyName FROM t_comb_exam_config_item a,t_subject_type b,t_category c,t_dictionary d WHERE "  +
            "a.subject_type_id = b.id AND a.category_id = c.id AND a.difficulty = d.id AND a.comb_exam_config_id = #{combExamId} ")
    List<CombExamConfigItem> listByConfigId(CombExamConfigItem item);
}
