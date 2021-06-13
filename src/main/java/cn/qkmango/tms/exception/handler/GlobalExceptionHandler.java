package cn.qkmango.tms.exception.handler;

import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    // SQLException
    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public Map doOtherException(SQLException e) {
        e.printStackTrace();
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("message","数据库异常！");
        return map;
    }

    //处理 LoginException 的异常
    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Map doNameException(LoginException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("message",e.getMessage());
        return map;
    }

    //处理 SystemException 的异常
    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public Map doNameException(SystemException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("message",e.getMessage());
        return map;
    }

    //
    // @ResponseBody
    // @ExceptionHandler
    // public Map doOtherException(Exception e) {
    //     HashMap<String, Object> map = new HashMap<>();
    //     map.put("success",false);
    //     map.put("message","其他异常！");
    //     return map;
    // }

}
