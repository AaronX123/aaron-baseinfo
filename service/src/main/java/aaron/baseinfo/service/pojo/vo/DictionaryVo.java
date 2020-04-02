package aaron.baseinfo.service.pojo.vo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 数据字典VO
 * @Author: 谢良希
 * @Date: 2019/8/13
 * @Version: 1.0
 * @Maintenance Records:
 */
public class DictionaryVo extends BaseItemVo implements Serializable {

    private static final long serialVersionUID = -8851634420537800364L;

    /**
     * 字典名
     */
    @NotBlank(message = "字典名不能为空！")
    private String name;

    /**
     * 字典类型
     */
    @NotBlank(message = "字典类型不能为空！")
    private String category;

    /**
     * 字典值
     */
    @NotBlank(message = "字典值不能为空！")
    private String value;

    public DictionaryVo() {
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

    @Override
    public String toString() {
        return "DictionaryVO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
