package br.com.jgle.acti.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public DAOException(Exception e) {
		super(e);
	}

}
