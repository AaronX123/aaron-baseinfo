package aaron.baseinfo.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 题目类型DTO
 * @author pan
 */
public class SubjectTypeDTO extends BasedataBaseDTO implements Serializable {
    private static final long serialVersionUID = 6193674149029494679L;

    /**
     * 题目类型属性列
     */
    private String attribute;

    /**
     * 题目类型名
     */
    private String name;

    /**
     * 题目类型id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 题目类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    /**
     * 备注
     */
    private String remark;

    public SubjectTypeDTO() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectTypeDTO{" +
                "attribute='" + attribute + '\'' +
                ", name='" + name + '\'' +
                ", subjectTypeId=" + subjectTypeId +
                ", categoryId=" + categoryId +
                ", status=" + status +
                ", remark='" + remark + '\'' +
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
