package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 组卷配置VO
 * @author
 */
public class CombExamConfigVo extends BaseItemVo implements Serializable {

    private static final long serialVersionUID = -8342846611386764998L;

    /**
     * 组卷配置名
     */
    @Size(max = 64, message = "组卷配置名不能超过64个字符")
    @NotBlank(message = "组卷配置名不能为空！")
    private String name;

    /**
     * 试卷难度
     */
    @NotNull(message = "难度不能为空！")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 删除的组卷配置明细id
     */
    private List<Long> deleteIds;

    /**
     * 组卷配置明细VO
     */
    @Valid
    private List<CombExamConfigItemVo> combExamConfigItemVOs;

    public CombExamConfigVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public List<Long> getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(List<Long> deleteIds) {
        this.deleteIds = deleteIds;
    }

    public List<CombExamConfigItemVo> getCombExamConfigItemVOs() {
        return combExamConfigItemVOs;
    }

    public void setCombExamConfigItemVOs(List<CombExamConfigItemVo> combExamConfigItemVOs) {
        this.combExamConfigItemVOs = combExamConfigItemVOs;
    }

    @Override
    public String toString() {
        return "CombExamConfigVO{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", deleteIds=" + deleteIds +
                ", combExamConfigItemVOs=" + combExamConfigItemVOs +
                ", id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
