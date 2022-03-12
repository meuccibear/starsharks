package io.renren.common.gitUtils.exception;

/**
 * @description: 消息自定义异常
 * @author:
 * @date: 2019/9/13 17:21
 */
public class MsgException extends Exception {


    public MsgException() {
    }

    public MsgException(String message) {
        super(message);
    }

    public MsgException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgException(Throwable cause) {
        super(cause);
    }

    public MsgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
