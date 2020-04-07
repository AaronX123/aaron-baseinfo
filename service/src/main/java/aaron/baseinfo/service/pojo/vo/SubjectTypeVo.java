package aaron.baseinfo.service.pojo.vo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 题目类型VO
 * @author
 */
public class SubjectTypeVo extends BaseItemVo implements Serializable {

    private static final long serialVersionUID = 1648028994563681818L;

    /**
     * 题目类型
     */
    @NotBlank(message = "题目属性列不能为空！")
    private String attribute;

    /**
     * 题目类型名字
     */
    private String name;

    public SubjectTypeVo() {
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
        return "SubjectTypeVO{" +
                "attribute='" + attribute + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
