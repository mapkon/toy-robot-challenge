package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

/**
 * Reports the current status of the Robot by displaying:
 * <p>
 * <code>
 * X_COORDINATE,Y_COORDINATE,FACE
 * </code>
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class ReportCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) {
		if (robot.isPlaced()) {
			System.out.println(robot.toString());
			robot.getSurface().addExecutedCommand(this);
		}
		return robot;
	}
}
