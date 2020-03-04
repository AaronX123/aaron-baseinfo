package aaron.baseinfo.service.common.exception;

import aaron.common.data.exception.NestedExamException;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
public class BaseInfoException extends NestedExamException {
    public BaseInfoException(String errorMessage, String errorCode) {
        super(errorMessage, errorCode);
    }

    public BaseInfoException(BaseInfoError error){
        super(error.msg,error.code);
    }

    public BaseInfoException(BaseInfoError error, Object ... o){
        super(String.format(error.msg,o),error.msg);
    }
}
