package cn.qkmango.tms.exception;

/**
 * 用户权限异常
 */
public class PermissionException extends Exception{
    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }
}
