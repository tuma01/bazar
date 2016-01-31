package com.amachi.fwk.exception;

/**
 * DaoException
 * @author tuma
 * @date Apr 9, 2015
 *
 */
public class DaoException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7313882712710911621L;
	private Throwable cause;

	public DaoException() {
		super();
	}

	public DaoException(String s) {
		super(s);
	}

	public DaoException(String s, Throwable cause) {
		super(s);
		this.cause = cause;
	}	

	public java.lang.Throwable getCause() {
		return cause;
	}
	
	public void printStackTrace() {
		super.printStackTrace();
		if (cause != null) {
			System.err.println("Caused by:");
			cause.printStackTrace();
		}
	}
  
	public void printStackTrace(java.io.PrintStream ps) {
		super.printStackTrace(ps);
		if (cause != null) {
			ps.println("Caused by:");
			cause.printStackTrace(ps);
		}
	}
  
	public void printStackTrace(java.io.PrintWriter pw) {
		super.printStackTrace(pw);
		if (cause != null) {
			pw.println("Caused by:");
			cause.printStackTrace(pw);
		}
	}

	public void setCause(java.lang.Throwable newCause) {
		cause = newCause;
	}
}


