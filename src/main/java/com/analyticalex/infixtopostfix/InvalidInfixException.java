package main.java.com.analyticalex.infixtopostfix;

public class InvalidInfixException extends RuntimeException {

	private static final long serialVersionUID = 2951589641836960112L;

	public InvalidInfixException() {
		super();
	}
	
	public InvalidInfixException(String message) {
		super(message);
	}
	
	public InvalidInfixException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidInfixException(Throwable cause) {
		super(cause);
	}
	
}
