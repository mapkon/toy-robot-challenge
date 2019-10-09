package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

/**
 * Models the command that moves rotates the Robot 90 degrees. This command
 * should not change the coordinates, but should change the Face of the Robot.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class RightCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
}
