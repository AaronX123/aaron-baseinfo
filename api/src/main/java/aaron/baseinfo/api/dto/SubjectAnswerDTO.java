package aaron.baseinfo.api.dto;

import java.io.Serializable;

public class SubjectAnswerDTO implements Serializable {

    private static final long serialVersionUID = -1859606015049770782L;

    private Long subjectAnswerId;

    private Long subjectId;

    private String answer;

    private byte rightAnswer;

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

    public Object getField1() {
        return field1;
    }

    public void setField1(Object field1) {
        this.field1 = field1;
    }

    public Object getField2() {
        return field2;
    }

    public void setField2(Object field2) {
        this.field2 = field2;
    }

    public Object getField3() {
        return field3;
    }

    public void setField3(Object field3) {
        this.field3 = field3;
    }

    public SubjectAnswerDTO() {
    }

    @Override
    public String toString() {
        return "SubjectAnswerDTO{" +
                "subjectAnswerId=" + subjectAnswerId +
                ", subjectId='" + subjectId + '\'' +
                ", answer='" + answer + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
