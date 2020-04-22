package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.CombExamConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CombExamConfigDao extends BaseMapper<CombExamConfig> {
    /**
     *
     * @param combExamConfig
     * @return
     */
    @Delete("DELETE FROM comb_exam_config WHERE id = #{id} AND version = #{version} " +
            "AND (company_id = #{judgeId} or org_id = #{judgeId})")
    boolean removeWithOrg(CombExamConfig combExamConfig);


    /**
     * 模糊查询组卷配置
     * @param combExamConfig
     * @return
     */
    @Select("<script>" +
            "SELECT a.*,b.value AS difficultyName FROM comb_exam_config a, dictionary b WHERE a.difficulty = b.id AND "  +
            "<if test=\"name!=null and name!=''\">" +
            "a.name LIKE CONCAT('%',#{name},'%') AND " +
            "</if>" +
            "(a.company_id = #{judgeId} or a.org_id = #{judgeId}) order by updated_time DESC" +
            "</script>")
    List<CombExamConfig> queryCombExamConfig(CombExamConfig combExamConfig);
}
