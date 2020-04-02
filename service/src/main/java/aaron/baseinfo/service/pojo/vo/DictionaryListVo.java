package aaron.baseinfo.service.pojo.vo;

import java.io.Serializable;

/**
 * 数据字典返回VO
 * @Author: 谢良希
 * @Date: 2019/8/13
 * @Version: 1.0
 * @Maintenance Records:
 */
public class DictionaryListVo extends BaseListVo implements Serializable {

    private static final long serialVersionUID = 92587521418453760L;

    /**
     * 字典类型
     */
    private String category;

    /**
     * 字典值
     */
    private String value;

    public DictionaryListVo() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "DictionaryListVo{" +
                "category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", updatedTime=" + updatedTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
