package aaron.baseinfo.api.dto;

import java.util.List;

/**
 * 与基础数据服务交互
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-27
 */
public class BaseDataDTO {
    private List<Long> idList;
    private List<String> valueList;

    public BaseDataDTO() {
    }

    public BaseDataDTO(List<Long> idList) {
        this.idList = idList;
    }

    public BaseDataDTO(List<Long> idList, List<String> valueList) {
        this.idList = idList;
        this.valueList = valueList;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
}

