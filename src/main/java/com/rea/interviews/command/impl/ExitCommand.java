package com.rea.interviews.command.impl;

import com.rea.interviews.Constants;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.ExitException;
import com.rea.interviews.robot.Robot;

/**
 * A command that exits a given simulation round. Because of the context rules
 * pertaining to how the <code>jvm</code> can be exited, this class throws an
 * exception that should be handled by the caller, to exit gracefully.
 * 
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 * 
 * @author Night King
 *
 */
public class ExitCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		throw new ExitException(Constants.EXIT_HANDLED);
	}
}
