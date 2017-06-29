package br.com.jgle.acti.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}

}
