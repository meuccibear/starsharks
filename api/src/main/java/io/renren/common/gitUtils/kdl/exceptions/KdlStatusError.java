package io.renren.common.gitUtils.kdl.exceptions;

/**
 * 状态码异常类
 */
public class KdlStatusError extends KdlException {

    private static final long serialVersionUID = 1302985113384909056L;

    public KdlStatusError(int code, String message) {
        super(code, message);
        this.setHintMessage(String.format("[KdlStatusError] status_code: %d, message: %s", this.getCode(), this.getMessage()));
    }

}
