package com.merck.sda.exception;

public class ControllerException extends SDAException {
	private static final long serialVersionUID = 1L;

	public ControllerException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public ControllerException(ErrorCode errorCode) {
		super(errorCode);
	}
}
