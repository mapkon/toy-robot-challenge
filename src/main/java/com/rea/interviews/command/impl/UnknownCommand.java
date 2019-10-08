package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.robot.Robot;

public class UnknownCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) {
		// TODO Auto-generated method stub
		return null;
	}
}
