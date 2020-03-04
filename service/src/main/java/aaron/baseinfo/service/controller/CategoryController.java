package aaron.baseinfo.service.controller;

import aaron.baseinfo.service.common.constant.ControllerConstant;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
@RestController
public class CategoryController {
    @Autowired
    CommonState commonState;

    @MethodEnhancer
    @GetMapping(ControllerConstant.SAVE_CATEGORY)
    public CommonResponse saveCategory(){
        return new CommonResponse(commonState.getVersion(),CommonState.SUCCESS,CommonState.SUCCESS_MSG,"");
    }
}
