package Model.Exceptions;

public class NoLimitWithdrawException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NoLimitWithdrawException(String msg, Integer code) {
		super(msg + " | E" + code);
	}

}
