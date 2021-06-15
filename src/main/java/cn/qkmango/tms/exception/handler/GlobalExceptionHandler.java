package cn.qkmango.tms.exception.handler;

import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.SystemException;
import cn.qkmango.tms.exception.UpdateException;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Map;


/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    // SQLException
    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public Map SQLExceptionHandler(SQLException e) {
        e.printStackTrace();
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 登陆 的异常
    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Map loginExceptionHandler(LoginException e) {
        e.printStackTrace();
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 系统 的异常
    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public Map systemExceptionHandler(SystemException e) {
        e.printStackTrace();
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 用户权限 的异常
    @ResponseBody
    @ExceptionHandler(PermissionException.class)
    public Map permissionExceptionHandler(PermissionException e) {
        e.printStackTrace();
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 更新数据 的异常
    @ResponseBody
    @ExceptionHandler(UpdateException.class)
    public Map UpdateExceptionHandler(UpdateException e) {
        e.printStackTrace();
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage("更新用户信息失败");
        return map;
    }

}
