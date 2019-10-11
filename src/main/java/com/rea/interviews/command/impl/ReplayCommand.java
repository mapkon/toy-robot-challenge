package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

public class ReplayCommand implements Command<Robot> {

	@Override
	public InvocationContext getContext() {
		return null;
	}

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		if (robot.isPlaced()) {
			robot = robot.getSurface().retraceSteps(robot);
		}
		return robot;
	}
}
