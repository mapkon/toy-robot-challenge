package com.rea.interviews.command.impl;

import com.rea.interviews.Constants;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

/**
 * Modes an unknown command that is passed in as part of the invocation context.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class UnknownCommand implements Command<Robot> {

	private InvocationContext context;

	@Override
	public InvocationContext getContext() {
		return this.context;
	}

	@Override
	public Robot execute(Robot robot, InvocationContext context) {
		System.err.println(Constants.WRONG_COMMAND.concat(context.getArgs()));
		return robot;
	}
}
