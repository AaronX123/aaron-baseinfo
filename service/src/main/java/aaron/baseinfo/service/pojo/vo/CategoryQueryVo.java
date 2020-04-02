package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * 题目类别查询VO
 * @author pan
 */
public class CategoryQueryVo extends BaseQueryVo implements Serializable {


    private static final long serialVersionUID = -4473995365972235347L;
    /**
     * 题目类别
     */
    private String name;

    /**
     * 父亲节点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public CategoryQueryVo(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryQueryVo{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
