package aaron.baseinfo.api.dto;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 数据字典DTO
 * @Author: 谢良希
 * @Date: 2019/8/13
 * @Version: 1.0
 * @Maintenance Records:
 */
public class DictionaryDto extends BaseDataBaseDto implements Serializable {

    private static final long serialVersionUID = 6193674149029494679L;

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
     * 状态
     */
    @Max(2)
    private Byte status;

    /**
     * 判断公司、组织机构
     */
    private Long judgeId;

    public DictionaryDto() {
    }

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
        return "DictionaryDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", judgeId=" + judgeId +
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
