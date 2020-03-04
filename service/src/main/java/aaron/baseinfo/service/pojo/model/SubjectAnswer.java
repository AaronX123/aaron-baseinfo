package aaron.baseinfo.service.pojo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 题目答案实体
 * t_subjectAnswer
 * @author pan
 */
@Table(name = "t_subject_answer")
public class SubjectAnswer implements Serializable {

    private static final long serialVersionUID = 4095189758749430719L;

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "id")
    private Long subjectAnswerId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long subjectId;

    private String answer;

    private Byte rightAnswer;

    private Object field1;

    private Object field2;

    private Object field3;

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

    public Byte getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Byte rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "SubjectAnswer{" +
                "subjectAnswerId=" + subjectAnswerId +
                ", subjectId=" + subjectId +
                ", answer='" + answer + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
