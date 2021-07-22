package cn.qkmango.tms.common.exception;

public class UpdateException extends Exception{
    public UpdateException() {
        super("更新信息失败");
    }

    public UpdateException(String message) {
        super(message);
    }

    /**
     * 默认的模版
     * @param theory 理论影响行数
     * @param actual 实际影响行数
     */
    public UpdateException(int theory, int actual) {
        super("修改记录异常，应影响行数:"+theory+"，实际影响行数:"+actual);
    }
}
