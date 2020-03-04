package aaron.baseinfo.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 组卷配置明细DTO
 * @author pan
 */
public class CombExamConfigItemDto implements Serializable {
    private static final long serialVersionUID = 6193674149029494679L;

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 题目类型id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 题目类型
     */
    private String subjectType;

    /**
     * 组卷配置id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long combExamId;

    /**
     * 题目类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目类别
     */
    private String category;

    /**
     * 题目数量
     */
    private Integer num;

    /**
     * 题目难度id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 题目难度
     */
    private String difficultyName;

    /**
     * 题目分数
     */
    private Double score;

    private Long version;

    /**
     * 标记新增明细
     */
    private Boolean save;

    public CombExamConfigItemDto() {
    }

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    @Override
    public String toString() {
        return "CombExamConfigItemDto{" +
                "id=" + id +
                ", subjectTypeId=" + subjectTypeId +
                ", subjectType='" + subjectType + '\'' +
                ", combExamId=" + combExamId +
                ", categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", num=" + num +
                ", difficulty=" + difficulty +
                ", difficultyName='" + difficultyName + '\'' +
                ", score=" + score +
                ", version=" + version +
                ", save=" + save +
                '}';
    }
}
