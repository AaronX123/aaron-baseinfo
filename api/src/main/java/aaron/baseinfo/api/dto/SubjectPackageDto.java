package aaron.baseinfo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-16
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectPackageDto {
    SubjectDto subjectDTO;
    List<SubjectAnswerDto> subjectAnswerDtoList;
}
