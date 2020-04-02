package aaron.baseinfo.service.common.exception;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-04
 */
public enum BaseInfoError {
    DICTIONARY_NOT_EXIST("010001","字典值不存在"),
    CATEGORY_DEL_FAIL("010002","题目类别删除失败"),
    CATEGORY_UPDATE_FAIL("010003","题目类别更新失败"),
    CATEGORY_NOT_EXIST("010004","题目类别不存在"),
    DICTIONARY_SAVE_FAIL("010005","字典值保存失败"),
    DICTIONARY_DEL_FAIL("010006","字典值删除失败"),
    DICTIONARY_UPDATE_FAIL("010007","字典值更新失败"),
    COMB_EXAM_CONFIG_SAVE_FAIL("010008","保存组卷配置失败"),
    ;
    String code;
    String msg;

    BaseInfoError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
