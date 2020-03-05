package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class CombExamConfig extends Model<CombExamConfig> {

    private static final long serialVersionUID = -3986043635171055833L;
    /**
     * 配置名
     */
    private String name;
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
     * 备注
     */
    private String remark;

    /**
     * 标记位
     */
    private Byte status;

    /**
     * 题目难度id
     */
    private Long difficulty;

    /**
     * 题目难度名
     */
    private String difficultyName;

    private Long judgeId;

    private Long oldVersion;

    @Override
    protected Serializable pkVal() {
        return id;
    }

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String REMARK = "remark";
    public static final String STATUS = "status";
    public static final String ORG_ID = "org_id";
    public static final String COMPANY_ID = "company_id";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_TIME = "created_time";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATE_TIME = "update_time";
    public static final String VERSION = "version";
    public static final String DIFFICULTY = "difficulty";

}
