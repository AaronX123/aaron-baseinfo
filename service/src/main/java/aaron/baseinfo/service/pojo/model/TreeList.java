package aaron.baseinfo.service.pojo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class TreeList extends Model<TreeList> {

    private static final long serialVersionUID = 6472410096892537711L;
    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 父亲id
     */
    private Long parentId;

    private Long version;

    @Override
    protected Serializable pkVal() {
        return id;
    }

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PARENT_ID = "parent_id";
    public static final String VERSION = "version";

}
