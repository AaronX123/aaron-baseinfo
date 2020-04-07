package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.SubjectTypeDto;
import aaron.baseinfo.service.pojo.model.SubjectType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xym
 */
public interface SubjectTypeService extends IService<SubjectType> {
    boolean save(SubjectTypeDto subjectTypeDto);

    boolean remove(List<SubjectType> subjectTypeList);

    boolean update(SubjectTypeDto subjectType);

    List<SubjectType> list(SubjectType subjectType);

    List<SubjectType> querySubjectTypeUpdateForm(SubjectType subjectType);

    List<String> getTypeName(List<Long> idList);
}
