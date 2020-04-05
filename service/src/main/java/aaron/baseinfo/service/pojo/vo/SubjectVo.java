package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 题目VO
 *
 * @Date: 2019/9/5
 * @Version: 1.0
 * @Maintenance Records:
 */
public class SubjectVo extends BaseItemVo implements Serializable {

    private static final long serialVersionUID = 8413924345677180367L;

    /**
     * 题目
     */
    @NotBlank(message = "题目内容不能为空！")
    private String name;

    /**
     * 题目类型id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "题型不能为空！")
    private Long subjectTypeId;

    /**
     * 题目类型名
     */
    private String subjectTypeName;

    /**
     * 难度id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "题目难度不能为空！")
    private Long difficulty;

    /**
     * 题目类别id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "题目类别不能为空！")
    private Long categoryId;

    /**
     * 题目类别名
     */
    private String categoryName;

    @Valid
    private List<SubjectAnswerVo> subjectAnswerVoList;

    public SubjectVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<SubjectAnswerVO> getSubjectAnswerVOList() {
        return subjectAnswerVOList;
    }

    public void setSubjectAnswerVOList(List<SubjectAnswerVO> subjectAnswerVOList) {
        this.subjectAnswerVOList = subjectAnswerVOList;
    }

    @Override
    public String toString() {
        return "SubjectVO{" +
                "name='" + name + '\'' +
                ", subjectTypeId=" + subjectTypeId +
                ", subjectTypeName='" + subjectTypeName + '\'' +
                ", difficulty=" + difficulty +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", subjectAnswerVOList=" + subjectAnswerVOList +
                ", id=" + id +
                ", status=" + status +
                ", version=" + version +
                ", remark='" + remark + '\'' +
                '}';
    }
}
