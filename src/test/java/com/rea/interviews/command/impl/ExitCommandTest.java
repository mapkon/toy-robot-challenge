package com.rea.interviews.command.impl;

import org.junit.Test;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.ExitException;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class ExitCommandTest {

	Robot robot = null;
	final String context = "EXIT";
	Command<Robot> command = new ExitCommand();

	@Test(expected = ExitException.class)
	public void testThatExecuteThrowsException() throws Exception {
		command.execute(new ToyRobot(), new InvocationContext(context));
	}
}
