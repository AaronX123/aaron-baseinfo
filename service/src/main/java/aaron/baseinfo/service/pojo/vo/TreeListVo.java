package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
* 树列表VO
*/
public class TreeListVo implements Serializable {


    private static final long serialVersionUID = -1037506771169163112L;
    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 父亲id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 版本
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long version;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TreeListVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", version=" + version +
                '}';
    }
}
