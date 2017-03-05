package com.merck.sda.exception;

public class BusinessException extends SDAException {
	private static final long serialVersionUID = 1L;

	public BusinessException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public BusinessException(ErrorCode errorCode) {
		super(errorCode);
	}
}
