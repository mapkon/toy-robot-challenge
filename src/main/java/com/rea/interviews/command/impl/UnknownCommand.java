package com.rea.interviews.command.impl;

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

	@Override
	public Robot execute(Robot robot, InvocationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
}
