package cn.qkmango.tms.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: VerifyError
 * @Description:TODO
 * @author: qkmango
 * @date: 2021/6/30 17:35
 * @version: 1.0
 */
public class VerifyError extends java.lang.VerifyError {
    private List<BindingResult> BindingResultList = new ArrayList<>();

    public List<BindingResult> getBindingResultList() {
        return BindingResultList;
    }

    public void setBindingResult(BindingResult... bindingResultList) {
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    public VerifyError() {}

    public VerifyError(BindingResult... bindingResultList) {
        super();
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    public VerifyError(String s, BindingResult... bindingResultList) {
        super(s);
        for (BindingResult bindingResult : bindingResultList) {
            BindingResultList.add(bindingResult);
        }
    }

    @Override
    public String toString() {
        return "VerifyError{" +
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
