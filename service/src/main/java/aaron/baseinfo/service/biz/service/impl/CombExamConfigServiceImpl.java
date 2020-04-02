package aaron.baseinfo.service.biz.service.impl;

import aaron.baseinfo.api.dto.CombExamConfigDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.service.biz.dao.CombExamConfigDao;
import aaron.baseinfo.service.biz.service.CombExamConfigItemService;
import aaron.baseinfo.service.biz.service.CombExamConfigService;
import aaron.baseinfo.service.common.exception.BaseInfoError;
import aaron.baseinfo.service.common.exception.BaseInfoException;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import aaron.baseinfo.service.pojo.model.CombExamConfigItem;
import aaron.common.aop.annotation.FullCommonField;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.SnowFlake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xym
 */
@Service
public class CombExamConfigServiceImpl extends ServiceImpl<CombExamConfigDao, CombExamConfig> implements CombExamConfigService {
    @Autowired
    SnowFlake snowFlake;

    @Autowired
    CombExamConfigItemService itemService;

    /**
     * 保存组卷配置
     *
     * @param combExamConfigDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @FullCommonField
    @Override
    public boolean saveCombExamConfigItem(CombExamConfigDto combExamConfigDto) {
        List<CombExamConfigItem> itemList = CommonUtils.convertList(combExamConfigDto.getCombExamConfigItemDtoList(),CombExamConfigItem.class);
        for (CombExamConfigItem item : itemList) {
            item.setId(snowFlake.nextId());
            item.setCombExamId(combExamConfigDto.getId());
        }
        CombExamConfig config = CommonUtils.copyProperties(combExamConfigDto,CombExamConfig.class);
        try {
            return save(config) && itemService.saveBatch(itemList);
        }catch (Exception e){
            throw new BaseInfoException(BaseInfoError.COMB_EXAM_CONFIG_SAVE_FAIL);
        }
    }
}
