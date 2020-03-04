package aaron.baseinfo.service.pojo.model;


import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 数据字典实体
 * t_dictionary
 * @author 
 */
@Table(name="t_dictionary")
public class Dictionary extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -9016613013240438499L;

    /**
     * 字典名
     */
    private String name;

    /**
     * 字典类型
     */
    private String category;

    /**
     * 字典值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "Dictionary{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
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