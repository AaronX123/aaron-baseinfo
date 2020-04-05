package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.service.biz.dao.CombExamConfigItemDao;
import aaron.baseinfo.service.biz.service.CombExamConfigItemService;
import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xym
 */
@Service
public class CombExamConfigItemServiceImpl extends ServiceImpl<CombExamConfigItemDao, CombExamConfigItem> implements CombExamConfigItemService {
    /**
     * 根据组卷配置删除配置项
     *
     * @param configId
     * @return
     */
    @Override
    public boolean removeByConfig(long configId) {
        QueryWrapper<CombExamConfigItem> wrapper = new QueryWrapper<>();
        wrapper.eq(CombExamConfigItem.COMB_EXAM_CONFIG_ID,configId);
        return remove(wrapper);
    }

    /**
     * 根据组卷配置id查询对应的配置明细
     *
     * @param item
     * @return
     */
    @Override
    public List<CombExamConfigItem> listByCombExamId(CombExamConfigItem item) {
        return baseMapper.listByConfigId(item);
    }
}
