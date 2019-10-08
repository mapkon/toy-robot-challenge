package com.rea.interviews.command;

import com.rea.interviews.robot.Robot;

public interface Command<T> {

	T execute(Robot robot, InvocationContext context) throws Exception;
}
