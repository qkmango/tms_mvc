package cn.qkmango.tms.common.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: ParamVerifyError 参数验证错误
 * 此类存放由控制器存入的 所有参数绑定（验证）错误的异常类 BindingResult 对象，
 * 所以此类包含了所有的验证错误消息，通过getMessage()即可获取这些参数绑定（验证）错误的消息
 * @author: qkmango
 * @date: 2021/6/30 17:35
 * @version: 1.0
 */
public class ParamVerifyError extends java.lang.VerifyError {
    private List<BindingResult> BindingResultList = null;

    public ParamVerifyError() {}

    /**
     * 使用 BindingResult 变长数组构造
     * @param bindingResultList
     */
    public ParamVerifyError(BindingResult... bindingResultList) {
        super();
        BindingResultList = Arrays.asList(bindingResultList);
    }

    /**
     * 使用 BindingResult 列表对象构造
     * @param bindingResultList
     */
    public ParamVerifyError(ArrayList<BindingResult> bindingResultList) {
        super();
        BindingResultList = bindingResultList;
    }

    /**
     * 使用 BindingResult 变长参数构造，并且附带详细信息
     * @param s
     * @param bindingResultList
     */
    public ParamVerifyError(String s, BindingResult... bindingResultList) {
        super(s);
        List<BindingResult> bindingResults = Arrays.asList(bindingResultList);
        BindingResultList = bindingResults;
    }

    /**
     * 使用 BindingResult 列表对象构造，并且附带详细信息
     * @param s
     * @param bindingResultList
     */
    public ParamVerifyError(String s, ArrayList<BindingResult> bindingResultList) {
        super(s);
        BindingResultList = bindingResultList;
    }

    /**
     * 获取 BindingResult 列表
     * @return
     */
    public List<BindingResult> getBindingResultList() {
        return BindingResultList;
    }

    /**
     * 设置 BindingResult 列表，通过 BindingResult 变长参数
     * @param bindingResultList
     */
    public void setBindingResult(BindingResult... bindingResultList) {
        BindingResultList = Arrays.asList(bindingResultList);
    }

    /**
     * 设置 BindingResult 列表，通过 BindingResult 列表对象
     * @param bindingResultList
     */
    public void setBindingResult(List<BindingResult> bindingResultList) {
        BindingResultList = bindingResultList;
    }

    /**
     * 获取所有错误消息 字符串
     * @return
     */
    @Override
    public String getMessage() {
        return getMessageList().toString();
    }

    /**
     * 获取所有错误消息 列表
     * @return
     */
    public List<String> getMessageList() {
        List<String> errorMessageList = new ArrayList<>();

        for (BindingResult bindingResult : BindingResultList) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                errorMessageList.add(error.getDefaultMessage());
            }
        }
        return errorMessageList;
    }

    @Override
    public String toString() {
        return "ParamVerifyError{" +
                "BindingResultList=" + BindingResultList +
                '}';
    }
}
