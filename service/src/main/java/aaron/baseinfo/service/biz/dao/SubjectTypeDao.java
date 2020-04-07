package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.SubjectType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SubjectTypeDao extends BaseMapper<SubjectType> {
    boolean removeBatch(@Param(value = "typeList") List<SubjectType> typeList);

    @Update("UPDATE t_subject_type SET name = #{name}, attribute = #{attribute}, remark = #{remark}, " +
            "status = #{status}, updated_by = #{updatedBy}, updated_time = #{updatedTime}, version = #{version} " +
            "WHERE id = #{id} AND version = #{oldVersion} AND org_id = #{orgId}")
    boolean update(SubjectType subjectType);

    @Select("<script>" +
            "SELECT * FROM t_subject_type WHERE " +
            "<if test=\"name!=null and name!=''\">" +
            "name = #{name} AND " +
            "</if>" +
            "<if test=\"attribute!=null and attribute!=''\">" +
            "attribute = #{attribute} AND " +
            "</if>" +
            "<if test=\"id!=null and id!=''\">" +
            "id = #{id} AND " +
            "</if>" +
            "org_id = #{orgId}" +
            "</script>")
    List<SubjectType> querySubjectTypeUpdateForm(SubjectType subjectType);
}
