package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectInfo {
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
}
