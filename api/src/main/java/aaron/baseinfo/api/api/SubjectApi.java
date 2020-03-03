package aaron.baseinfo.api.api;

import aaron.baseinfo.api.constant.ApiConstant;
import aaron.baseinfo.api.dto.SubjectPackage;
import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-03
 */
@Slf4j
@RestController
public class SubjectApi {
    @PostMapping(ApiConstant.GET_SUBJECT_AND_ANSWER)
    public CommonResponse<SubjectPackage> getSubjectAndAnswer(@RequestBody @Valid CommonRequest<Long> request){
        return null;
    }
}
