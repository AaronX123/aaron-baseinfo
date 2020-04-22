package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * 题目类别实体
 * t_category
 * @author 
 */

@Data
@Accessors(chain = true)
public class Category extends Model<Category>{

    private static final long serialVersionUID = -5495980585809940272L;


    /**
     * 雪花算法生成Id
     */
    private Long id;
    /**
     * 机构id
     */
    private Long orgId;
    /**
     * 机构下公司id
     */
    @TableField(exist = false)
    private Long companyId;
    /**
     * 通过id到数据字典中查询创建者
     */
    private Long createdBy;
    /**
     * 创建日期
     */
    private Date createdTime;
    /**
     * 通过id到数据字典中查询修改者
     */
    private Long updatedBy;
    /**
     * 修改日期
     */
    private Date updatedTime;
    /**
     * 版本，为Date.getTime()
     */
    private Long version;

    /**
     * 题目类别
     */
    private String name;

    /**
     * 父类别
     */

    private Long parentId;

    /**
     * 状态位
     */
    private Byte status;

    private String remark;

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
    public static final String PARENT_ID = "parent_id";
    public static final String REMARK = "remark";
    public static final String STATUS = "status";
    public static final String ORG_ID = "org_id";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_TIME = "created_time";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATE_TIME = "updated_time";
    public static final String VERSION = "version";

}