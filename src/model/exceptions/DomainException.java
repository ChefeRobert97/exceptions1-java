package model.exceptions;

public class DomainException extends RuntimeException{
	// � Exception: compilador obriga a tratar ou propagar
	// � RuntimeException: compilador n�o obriga a tratar
	private static final long serialVersionUID = 1L;
	
	public DomainException (String msg) {
		super(msg);
	}
	
}
