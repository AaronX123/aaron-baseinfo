package aaron.baseinfo.service.biz.dao;

import aaron.baseinfo.service.pojo.model.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectDao extends BaseMapper<Subject> {
}