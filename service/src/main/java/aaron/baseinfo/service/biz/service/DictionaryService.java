package aaron.baseinfo.service.biz.service;

import aaron.baseinfo.api.dto.DictionaryDto;
import aaron.baseinfo.service.pojo.model.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xym
 */
public interface DictionaryService extends IService<Dictionary> {
    /**
     * 获取字典值
     * @param idList
     * @return
     */
    List<String> getDictionary(List<Long> idList);

    /**
     * 获取值
     * @param id
     * @return
     */
    String getDictionaryValue(long id);

    /**
     * 保存
     * @param dictionaryDto
     * @return
     */
    boolean save(DictionaryDto dictionaryDto);

    /**
     * 更新
     * @param dictionaryDto
     * @return
     */
    boolean update(DictionaryDto dictionaryDto);

    /**
     * 查询
     * @param dictionary
     * @return
     */
    List<Dictionary> queryDictionary(Dictionary dictionary);
}
