package aaron.baseinfo.service.pojo.model;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 题目类型实体
 * t_subject_type
 * @author pan
 */
@Table(name="t_subject_type")
public class SubjectType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3166105829090017535L;

    /**
     * 题目类型属性列
     */
    private String attribute;

    /**
     * 题目类型名
     */
    private String name;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    private String remark;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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
        return "SubjectType{" +
                "attribute='" + attribute + '\'' +
                ", name='" + name + '\'' +
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
