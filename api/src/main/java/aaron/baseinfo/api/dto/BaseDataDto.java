package aaron.baseinfo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 与基础数据服务交互
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-27
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDataDto {
    private Map<Long,String> baseInfoMap;
}

