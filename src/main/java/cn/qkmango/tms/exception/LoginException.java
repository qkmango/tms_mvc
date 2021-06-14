package cn.qkmango.tms.exception;

public class LoginException extends SystemException{
    public LoginException() {
        super("系统登陆失败！");
    }

    public LoginException(String message) {
        super(message);
    }
}
