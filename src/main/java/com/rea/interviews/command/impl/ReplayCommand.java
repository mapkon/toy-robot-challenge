package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

public class ReplayCommand implements Command<Robot> {

	private InvocationContext context;

	@Override
	public InvocationContext getContext() {
		return this.context;
	}

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		if (robot.isPlaced()) {
			this.context = context;
			robot = robot.getSurface().retraceSteps(robot);
		}
		return robot;
	}
}
