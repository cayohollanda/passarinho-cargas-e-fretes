package edu.com.iesp.cargas.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6726984094231884248L;
	
	public ClienteNaoEncontradoException(String message) {
		super(message);
	}
	public ClienteNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

}
