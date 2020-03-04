package aaron.baseinfo.service.pojo.model;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 组卷配置实体
 * t_comb_exam_config表
 *
 */
@Table(name="t_comb_exam_config")
public class CombExamConfig extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3928292531081369476L;

    /**
     * 配置名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标记位
     */
    @Max(2)
    private Byte status;

    /**
     * 题目难度id
     */
    private Long difficulty;

    /**
     * 题目难度名
     */
    @Transient
    private String difficultyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "CombExamConfig{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", difficulty=" + difficulty +
                ", judgeId=" + judgeId +
                ", id=" + id +
                ", orgId=" + orgId +
                ", companyId=" + companyId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }
}