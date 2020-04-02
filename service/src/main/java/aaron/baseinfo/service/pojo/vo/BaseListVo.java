package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

/**
 * @author pan
 */
public class BaseListVo implements Serializable {


    private static final long serialVersionUID = -8902900761862410246L;
    /**
     * id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    /**
     * 类名
     */
    protected String name;

    /**
     * 版本号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long version;

    /**
     * 状态位
     */
    @Max(2)
    protected Byte status;

    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    protected Date updatedTime;

    /**
     * 备注
     */
    protected String remark;

    public BaseListVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BaseListVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", updatedTime=" + updatedTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
