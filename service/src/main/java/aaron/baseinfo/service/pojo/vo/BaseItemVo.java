package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author pan
 */
public class BaseItemVo implements Serializable {


    private static final long serialVersionUID = 8706224410388879778L;
    /**
     * id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    /**
     * 状态位
     */
    @Max(2)
    @NotNull(message = "状态位不能为空！")
    protected Byte status;

    /**
     * 版本号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long version;

    /**
     * 备注
     */
    protected String remark;

    public BaseItemVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BaseItemVo{" +
                "id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
