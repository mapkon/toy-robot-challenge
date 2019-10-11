package com.rea.interviews.command;

import com.rea.interviews.robot.Robot;

/**
 * An interface to model the context of a command.
 * <p>
 * It is intended that the caller implements the concrete return type, as this
 * interface does not make any assumptions about what will be returned.
 * </p>
 *
 * The command interface that is expected is as follows:
 * <p>
 * <code>
 *  PLACE X,Y,F<br>
 *  MOVE<br>
 *  LEFT<br>
 *  RIGHT<br>
 *  REPORT
 *  </code>
 *
 * @author Night King
 *
 * @param <T> The implementing object to return.
 */
public interface Command<T> {

	/**
	 * Returns the invocation context used in the execution of this command.
	 *
	 * @return The invocation context.
	 */
	public InvocationContext getContext();

	/**
	 * Executes a given command.
	 *
	 * @param robot   The robot onto which the context will be imposed.
	 * @param context The invocation context as specified by the caller. This could
	 *                be command line arguments or commands from a file.
	 * @return Return the concrete execution context.
	 *
	 * @throws Exception If the execution context is invalid.
	 */
	T execute(Robot robot, InvocationContext context) throws Exception;
}
