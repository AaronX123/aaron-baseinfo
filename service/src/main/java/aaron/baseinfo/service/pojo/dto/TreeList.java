package aaron.baseinfo.service.pojo.dto;

/**
 * 树列表
 */
public class TreeList {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TreeList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", version=" + version +
                '}';
    }
}
