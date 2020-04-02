package aaron.baseinfo.service.pojo.vo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 查询VO基类
 */
public class BaseQueryVo implements Serializable {


    private static final long serialVersionUID = -8750679123979588164L;
    /**
     * 当前分页
     */
    @NotNull(message = "分页信息不能为空")
    protected Integer currentPage;

    /**
     * 每页大小
     */
    @NotNull(message = "分页信息不能为空")
    protected Integer pageSize;

    public BaseQueryVo(){

    }

    public BaseQueryVo(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseQueryVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
