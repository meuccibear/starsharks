package io.renren.common.gitUtils.kdl.exceptions;

/**
 * 参数异常类
 */
public class KdlNameError extends KdlException {
    private static final long serialVersionUID = -5914218876641184106L;

    public KdlNameError(String message) {
        super(-2, message);
        this.setHintMessage(String.format("[KdlNameError] message: %s", this.getMessage()));
    }
}
