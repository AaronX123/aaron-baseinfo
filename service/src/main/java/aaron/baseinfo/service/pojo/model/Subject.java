package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Subject extends Model<Subject> {

    private static final long serialVersionUID = -8301082409712744702L;
    /**
     * 雪花算法生成Id
     */
    private Long id;
    /**
     * 机构id
     */
    public Long orgId;
    /**
     * 机构下公司id
     */
    public Long companyId;
    /**
     * 通过id到数据字典中查询创建者
     */
    public Long createdBy;
    /**
     * 创建日期
     */
    public Date createdTime;
    /**
     * 通过id到数据字典中查询修改者
     */
    public Long updatedBy;
    /**
     * 修改日期
     */
    public Date updatedTime;
    /**
     * 版本，为Date.getTime()
     */
    protected Long version;
    /**
     * 题目类型id
     */
    private Long subjectTypeId;

    /**
     * 题目类别id
     */
    private Long categoryId;

    /**
     * 题目
     */
    private String name;

    /**
     * 难度
     */
    private Long difficulty;

    /**
     * 状态位
     */
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
    private String subjectTypeName;

    /**
     * 非表对应字段
     * 题目类别名字
     */
    private String categoryName;

    /**
     * 非表对应字段
     * 题目难度名字
     */
    private String difficultyName;

    private Long judgeId;

    private Long oldVersion;

    @Override
    protected Serializable pkVal() {
        return id;
    }

    public static final String ID = "id";
    public static final String SUBJECT_TYPE_ID = "subject_type_id";
    public static final String NAME = "name";
    public static final String CATEGORY_ID = "category_id";
    public static final String DIFFICULTY = "difficulty";
    public static final String REMARK = "remark";
    public static final String STATUS = "status";
    public static final String ORG_ID = "org_id";
    public static final String COMPANY_ID = "company_id";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_TIME = "created_time";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATE_TIME = "update_time";
    public static final String VERSION = "version";
    public static final String FIELD1 = "field1";
    public static final String FIELD2 = "field2";
    public static final String FIELD3 = "field3";

}
