package aaron.baseinfo.service.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * 题目答案查询VO
 * @author pan
 */
public class SubjectAnswerQueryVo implements Serializable {

    private static final long serialVersionUID = 9123798642099490489L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectAnswerId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    /**
     * 答案
     */
    private String answer;

    public SubjectAnswerQueryVo() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getSubjectAnswerId() {
        return subjectAnswerId;
    }

    public void setSubjectAnswerId(Long subjectAnswerId) {
        this.subjectAnswerId = subjectAnswerId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SubjectAnswerQueryVo{" +
                "subjectAnswerId=" + subjectAnswerId +
                ", subjectId=" + subjectId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
