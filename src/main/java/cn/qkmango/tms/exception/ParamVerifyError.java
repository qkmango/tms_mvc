package cn.qkmango.tms.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
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
    private List<BindingResult> BindingResultList = new ArrayList<>();

    public List<BindingResult> getBindingResultList() {
        return BindingResultList;
    }

    public void setBindingResult(BindingResult... bindingResultList) {
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    public ParamVerifyError() {}

    public ParamVerifyError(BindingResult... bindingResultList) {
        super();
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    public ParamVerifyError(ArrayList<BindingResult> bindingResultList) {
        super();
        BindingResultList = bindingResultList;
    }

    public ParamVerifyError(String s, BindingResult... bindingResultList) {
        super(s);
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    @Override
    public String toString() {
        return "ParamVerifyError{" +
                "BindingResultList=" + BindingResultList +
                '}';
    }

    @Override
    public String getMessage() {

        List<String> errorMessageList = new ArrayList<>();

        for (BindingResult bindingResult : BindingResultList) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                errorMessageList.add(error.getDefaultMessage());
            }
        }
        return errorMessageList.toString();
    }
}
