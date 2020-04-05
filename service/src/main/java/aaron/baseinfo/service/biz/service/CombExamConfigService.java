package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.CombExamConfigDto;
import aaron.baseinfo.api.dto.CombExamConfigItemDto;
import aaron.baseinfo.service.pojo.model.CombExamConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    /**
     * 删除组卷配置
     * @param dtoList
     * @return
     */
    boolean deleteCombExamConfig(List<CombExamConfigDto> dtoList);

    /**
     * 更新
     * @param dto
     * @return
     */
    boolean updateCombExamConfig(CombExamConfigDto dto);

    /**
     *
     * @param combExamConfig
     * @return
     */
    List<CombExamConfig> listById(CombExamConfig combExamConfig);

}
