package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 题目类别VO
 * @author
 */
public class CategoryVo extends BaseItemVo implements Serializable {

    private static final long serialVersionUID = -700878102267633514L;

    /**
     * 题目类别
     */
    @NotBlank(message = "题目类别不能为空！")
    private String name;

    /**
     * 父类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    public CategoryVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
