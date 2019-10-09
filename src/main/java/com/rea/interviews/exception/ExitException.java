package com.rea.interviews.exception;

/**
 * Models a signal to the caller that the simulation round should be exited. It
 * is expected that the caller exits the entire application gracefully.
 * 
 * @author Night King
 *
 */
public class ExitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExitException(String message) {
		super(message);
	}
}
