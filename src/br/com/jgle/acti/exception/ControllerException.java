package br.com.jgle.acti.exception;

public class ControllerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ControllerException(String msg) {
		super(msg);
	}

	public ControllerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ControllerException(Exception e) {
		super(e);
	}

}
