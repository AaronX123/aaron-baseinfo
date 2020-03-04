package aaron.baseinfo.service.pojo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 题目实体
 * t_subject
 * @author 
 */
@Table(name="t_subject")
public class Subject extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -659676760444547952L;

    /**
     * 题目类型id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectTypeId;

    /**
     * 题目类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 题目
     */
    private String name;

    /**
     * 难度
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long difficulty;

    /**
     * 状态位
     */
    @Max(2)
    private Byte status;

    /**
     * 预留
     */
    private String field1;

    /**
     * 预留
     */
    private String field2;

    /**
     * 预留
     */
    private String field3;

    /**
     * 非表对应字段
     * 题目类型名字
     */
    @Transient
    private String subjectTypeName;

    /**
     * 非表对应字段
     * 题目类别名字
     */
    @Transient
    private String categoryName;

    /**
     * 非表对应字段
     * 题目难度名字
     */
    @Transient
    private String difficultyName;

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectTypeId=" + subjectTypeId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", status=" + status +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", subjectTypeName='" + subjectTypeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", difficultyName='" + difficultyName + '\'' +
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
}