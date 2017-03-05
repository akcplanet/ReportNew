package com.merck.sda.exception;

import org.apache.commons.lang3.StringUtils;

public class SDAException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

	public SDAException(ErrorCode errorCode) {
		super(errorCode.getError());
		this.errorCode = errorCode;
	}

	public SDAException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getError(), cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public SDAException(ErrorCode errorCode, String message) {
		super(StringUtils.isNotEmpty(message) ? errorCode.getError() + " :" + message : errorCode.getError());
		this.errorCode = errorCode;
	}
}
