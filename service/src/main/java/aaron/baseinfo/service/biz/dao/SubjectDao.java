package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubjectDao extends BaseMapper<Subject> {
    @Select("<script>" +
            "SELECT a.*,t.name AS subjectTypeName,c.name AS categoryName,d.value AS difficultyName FROM t_subject a,t_subject_type t,t_category c,t_dictionary d WHERE "  +
            "a.subject_type_id = t.id AND a.category_id = c.id AND a.difficulty = d.id " +
            "<if test=\"name!=null and name!=''\">" +
            "AND a.name LIKE CONCAT('%',#{name},'%') " +
            "</if>" +
            "<if test=\"subjectTypeId!=null and subjectTypeId!=''\">" +
            "AND a.subject_type_id = #{subjectTypeId} " +
            "</if>" +
            "<if test=\"categoryId!=null and categoryId!=''\">" +
            "AND a.category_id = #{categoryId} " +
            "</if>" +
            "<if test=\"difficulty!=null and difficulty!=''\">" +
            "AND a.difficulty = #{difficulty} " +
            "</if>" +
            "AND (a.company_id = #{judgeId} or a.org_id = #{judgeId}) order by updated_time DESC" +
            "</script>")
    List<Subject> querySubject(Subject subject);

    @Select("SELECT a.id FROM t_subject a " +
            "Left JOIN t_subject_type t ON a.subject_type_id = t.id " +
            "LEFT JOIN t_category c ON a.category_id = c.id " +
            "LEFT JOIN t_dictionary d ON a.difficulty = d.id WHERE a.subject_type_id = #{subjectTypeId} AND a.category_id = #{categoryId} AND a.difficulty = #{difficulty}")
    List<Long> querySubjectIdList(Subject subject);

    /**
     * 通过id来查询Subject
     * @param idList
     * @return
     */
    @Select({"<script>" +
            "SELECT id,org_id,company_id,created_by,created_time,updated_by,updated_time,version,subject_type_id,category_id,name," +
            "difficulty,status FROM t_subject WHERE id IN "+
            "<foreach item = 'id' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
            "#{id} </foreach> </script>" })
    List<Subject> querySubjectByPrimaryKeyList(@Param("idList") List<Long> idList);
}
