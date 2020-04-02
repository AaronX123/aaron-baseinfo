package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * 题目类别返回VO
 * @author
 */
public class CategoryListVo extends BaseListVo implements Serializable {

    private static final long serialVersionUID = 1955783486638017029L;

    /**
     * 父类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 父类别名
     */
    private String parentName;

    public CategoryListVo() {
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "CategoryListVo{" +
                "parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", updatedTime=" + updatedTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
