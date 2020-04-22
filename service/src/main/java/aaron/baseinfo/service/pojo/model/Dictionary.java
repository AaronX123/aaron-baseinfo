package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Dictionary extends Model<Dictionary> {

    private static final long serialVersionUID = 7136485464252246865L;
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
    @TableField(exist = false)
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
     * 字典名
     */
    private String name;

    /**
     * 字典类型
     */
    private String category;

    /**
     * 字典值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态位
     */
    private Byte status;

    @TableField(exist = false)
    private Long judgeId;

    @TableField(exist = false)
    private Long oldVersion;

    @Override
    protected Serializable pkVal() {
        return id;
    }

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String VALUE = "value";
    public static final String REMARK = "remark";
    public static final String STATUS = "status";
    public static final String ORG_ID = "org_id";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_TIME = "created_time";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATE_TIME = "updated_time";
    public static final String VERSION = "version";

}
