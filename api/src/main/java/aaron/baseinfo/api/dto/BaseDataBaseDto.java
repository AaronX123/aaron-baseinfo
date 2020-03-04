package aaron.baseinfo.api.dto;


import aaron.common.data.common.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDataBaseDto extends BaseDto {

    /**
     * 组织机构或者公司id
     */
    public Long judgeId;

    public Long oldVersion;

}
