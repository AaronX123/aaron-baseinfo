package aaron.baseinfo.service.pojo.vo;

import java.io.Serializable;

/**
 * 题目类型查询VO
 * @author
 */
public class SubjectTypeQueryVo extends BaseQueryVo implements Serializable {

    private static final long serialVersionUID = 3885878323457325997L;

    /**
     * 题目类型属性列
     */
    private String attribute;

    /**
     * 题目类型名字
     */
    private String name;

    public SubjectTypeQueryVo() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectTypeQueryVo{" +
                "attribute='" + attribute + '\'' +
                ", name='" + name + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
