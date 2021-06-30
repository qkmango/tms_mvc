package cn.qkmango.tms.exception.handler;

import cn.qkmango.tms.exception.*;
import cn.qkmango.tms.exception.VerifyError;
import cn.qkmango.tms.web.map.ResponseMap;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    // SQLException
    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public Map SQLExceptionHandler(SQLException e) {
        ResponseMap map = new ResponseMap();
        logger.error(e.getMessage(),e);
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 登陆 的异常
    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Map loginExceptionHandler(LoginException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 系统 的异常
    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public Map systemExceptionHandler(SystemException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 用户权限 的异常
    @ResponseBody
    @ExceptionHandler(PermissionException.class)
    public Map permissionExceptionHandler(PermissionException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

    //处理 更新数据 的异常
    @ResponseBody
    @ExceptionHandler(UpdateException.class)
    public Map UpdateExceptionHandler(UpdateException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage("更新数据失败");
        return map;
    }

    //处理 插入数据 的异常
    @ResponseBody
    @ExceptionHandler(InsertException.class)
    public Map InsertExceptionHandler(InsertException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage("插入数据失败");
        return map;
    }

    //处理 删除数据 的异常
    @ResponseBody
    @ExceptionHandler(DeleteException.class)
    public Map DeleteExceptionHandler(DeleteException e) {
        logger.error(e.getMessage());
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage("删除数据失败");
        return map;
    }

    //处理 请求参数 的异常
    @ResponseBody
    @ExceptionHandler(VerifyError.class)
    public Map VerifyErrorHandler(VerifyError e) {
        logger.error("请求参数不合法");
        ResponseMap map = new ResponseMap();
        map.setSuccess(false);
        map.setMessage(e.getMessage());
        return map;
    }

}
