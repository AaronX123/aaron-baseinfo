package aaron.baseinfo.service.pojo.vo;

import java.io.Serializable;

/**
 * 数据字典查询VO
 * @Author: 谢良希
 * @Date: 2019/8/13
 * @Version: 1.0
 * @Maintenance Records:
 */
public class DictionaryQueryVo extends BaseQueryVo implements Serializable {

    private static final long serialVersionUID = -5564633567599675063L;

    /**
     * 字典名
     */
    private String name;
    /**
     * 字典类型
     */
    private String category;

    public DictionaryQueryVo() {
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

    @Override
    public String toString() {
        return "DictionaryQueryVo{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
