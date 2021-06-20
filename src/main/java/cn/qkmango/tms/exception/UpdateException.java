package cn.qkmango.tms.exception;

public class UpdateException extends Exception{
    public UpdateException() {
        super("更新信息失败");
    }

    public UpdateException(String message) {
        super(message);
    }
}
