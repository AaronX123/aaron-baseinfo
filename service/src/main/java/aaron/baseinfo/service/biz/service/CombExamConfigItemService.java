package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface CombExamConfigItemService extends IService<CombExamConfigItem> {
    /**
     * 根据组卷配置删除配置项
     * @param configId
     * @return
     */
    boolean removeByConfig(long configId);

    /**
     * 根据组卷配置id查询对应的配置明细
     * @param item
     * @return
     */
    List<CombExamConfigItem> listByCombExamId(CombExamConfigItem item);
}
