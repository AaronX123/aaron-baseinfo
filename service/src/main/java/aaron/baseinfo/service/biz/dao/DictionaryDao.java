package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictionaryDao extends BaseMapper<Dictionary> {

    /**
     * 查询数据字典值
     * @param dictionary
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM dictionary WHERE "  +
            "<if test=\"id!=null and id!=''\">" +
            "id = #{id} AND " +
            "</if>" +
            "<if test=\"name!=null and name!=''\">" +
            "name = #{name} AND " +
            "</if>" +
            "<if test=\"category!=null and category!=''\">" +
            "category = #{category} AND " +
            "</if>" +
            "<if test=\"value!=null and value!=''\">" +
            "value = #{value} AND " +
            "</if>" +
            "org_id = #{orgId} order by updated_time DESC" +
            "</script>")
    List<Dictionary> queryDictionaryValue(Dictionary dictionary);
}
