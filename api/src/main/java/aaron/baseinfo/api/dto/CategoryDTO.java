package aaron.baseinfo.api.dto;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 题目类别DTO
 * @author pan
 */
public class CategoryDTO extends BasedataBaseDTO implements Serializable {
    private static final long serialVersionUID = 1645491693425153066L;

    /**
     * 题目类别
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父亲节点id
     */
    private Long parentId;

    /**
     * 父亲名
     */
    private String parentName;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    public CategoryDTO() {
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", status=" + status +
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
