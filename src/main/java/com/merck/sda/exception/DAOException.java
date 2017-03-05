package com.merck.sda.exception;

public class DAOException extends SDAException {
	private static final long serialVersionUID = 1L;

	public DAOException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public DAOException(ErrorCode errorCode) {
		super(errorCode);
	}
}
