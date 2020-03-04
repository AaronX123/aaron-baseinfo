package aaron.baseinfo.service.pojo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 组卷配置明细实体
 * t_comb_exam_config_item表
 * @author
 */
@Table(name="t_comb_exam_config_item")
public class CombExamConfigItem implements Serializable {

    private static final long serialVersionUID = -4743748847500443546L;

    /**
     * 组卷配置明细id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 题型ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 题型名
     */
    @Transient
    private String subjectType;

    /**
     * 组卷配置ID
     */
    @Column(name = "comb_exam_config_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long combExamId;

    /**
     * 题目类别ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目类别名字
     */
    @Transient
    private String category;

    /**
     * 题目数量
     */
    private Integer num;

    /**
     * 题目难度
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 题目难度名
     */
    @Transient
    private String difficultyName;

    /**
     * 题目分值
     */
    private Double score;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CombExamConfigItem{" +
                "id=" + id +
                ", subjectTypeId=" + subjectTypeId +
                ", combExamId=" + combExamId +
                ", categoryId=" + categoryId +
                ", num=" + num +
                ", difficulty=" + difficulty +
                ", score=" + score +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}