package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.CombExamConfigDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * auto generate
 * @author xym
 */
public interface CombExamConfigService extends IService<CombExamConfig> {
    /**
     * 保存组卷配置
     * @param combExamConfigDto
     * @return
     */
    boolean saveCombExamConfigItem(CombExamConfigDto combExamConfigDto);
}
