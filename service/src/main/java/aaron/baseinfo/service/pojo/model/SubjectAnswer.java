package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SubjectAnswer extends Model<SubjectAnswer> {

    private static final long serialVersionUID = -2235692655549688216L;
    /**
     * 雪花算法生成Id
     */
    private Long id;

    private Long subjectId;

    private String answer;

    private Byte rightAnswer;

    private Object field1;

    private Object field2;

    private Object field3;

    @Override
    protected Serializable pkVal() {
        return id;
    }

    public static final String ID = "id";
    public static final String SUBJECT_ID = "subject_id";
    public static final String ANSWER = "answer";
    public static final String RIGHT_ANSWER = "right_answer";
    public static final String FIELD1 = "field1";
    public static final String FIELD2 = "field2";
    public static final String FIELD3 = "field3";

}
