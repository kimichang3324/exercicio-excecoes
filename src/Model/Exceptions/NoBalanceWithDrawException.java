package Model.Exceptions;

public class NoBalanceWithDrawException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NoBalanceWithDrawException(String msg, Integer code) {
		super(msg + " | E" +code);
	}
}