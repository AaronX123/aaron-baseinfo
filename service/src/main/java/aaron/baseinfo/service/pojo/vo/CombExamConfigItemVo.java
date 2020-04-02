package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 组卷配置明细VO
 * @author
 */
public class CombExamConfigItemVo implements Serializable {

    private static final long serialVersionUID = 7029875785512079058L;


    /**
     * 组卷配置明细id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 题目类型id
     */
    @NotNull(message = "题目类型不能为空！")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 组卷配置id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long combExamId;

    /**
     * 题目类别id
     */
    @NotNull(message = "题目类别不能为空！")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目数量
     */
    private Integer num;

    /**
     * 题目难度
     */
    @NotNull(message = "题目难度不能为空！")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 题目分数
     */
    @Min(0)
    @NotNull(message = "题目分数不能为空！")
    private Double score;

    /**
     * 标记新增组卷配置明细
     */
    private Boolean save;

    public CombExamConfigItemVo() {
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getCombExamId() {
        return combExamId;
    }

    public void setCombExamId(Long combExamId) {
        this.combExamId = combExamId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    @Override
    public String toString() {
        return "CombExamConfigItemVO{" +
                "id=" + id +
                ", subjectTypeId=" + subjectTypeId +
                ", combExamId=" + combExamId +
                ", categoryId=" + categoryId +
                ", num=" + num +
                ", difficulty=" + difficulty +
                ", score=" + score +
                ", save=" + save +
                '}';
    }
}
