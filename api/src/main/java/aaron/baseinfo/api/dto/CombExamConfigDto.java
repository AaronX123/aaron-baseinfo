package aaron.baseinfo.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

/**
 * 组卷配置DTO
 * @author pan
 */
public class CombExamConfigDto extends BaseDataBaseDto implements Serializable {
    private static final long serialVersionUID = 6193674149029494679L;

    /**
     * 组卷配置名
     */
    private String name;

    /**
     * 试卷难度id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 试卷难度
     */
    private String difficultyName;

    /**
     * 删除id
     */
    private List<Long> deleteIds;

    /**
     * 组卷配置明细DTO
     */
    private List<CombExamConfigItemDto> combExamConfigItemDtoList;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    private String remark;

    private String updatedByName;

    private String company;

    public CombExamConfigDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public List<Long> getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(List<Long> deleteIds) {
        this.deleteIds = deleteIds;
    }

    public List<CombExamConfigItemDto> getCombExamConfigItemDtoList() {
        return combExamConfigItemDtoList;
    }

    public void setCombExamConfigItemDtoList(List<CombExamConfigItemDto> combExamConfigItemDtoList) {
        this.combExamConfigItemDtoList = combExamConfigItemDtoList;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CombExamConfigDto{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", difficultyName='" + difficultyName + '\'' +
                ", deleteIds=" + deleteIds +
                ", CombExamConfigItemDTOList=" + combExamConfigItemDtoList +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", updatedByName='" + updatedByName + '\'' +
                ", company='" + company + '\'' +
                ", judgeId=" + judgeId +
                ", id=" + id +
                ", orgId=" + orgId +
                ", companyId=" + companyId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
