package aaron.baseinfo.api.dto;


import aaron.common.data.common.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BaseDataBaseDto extends BaseDto {

    /**
     * 组织机构或者公司id
     */
    public Long judgeId;

    public Long oldVersion;

    public Long getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Long judgeId) {
        this.judgeId = judgeId;
    }

    @Override
    public Long getOldVersion() {
        return oldVersion;
    }

    @Override
    public void setOldVersion(Long oldVersion) {
        this.oldVersion = oldVersion;
    }
}
