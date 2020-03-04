package aaron.baseinfo.service.common.exception;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
public enum BaseInfoError {
    DICTIONARY_NOT_EXIST("010001","字典值不存在"),
    ;
    String code;
    String msg;

    BaseInfoError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
