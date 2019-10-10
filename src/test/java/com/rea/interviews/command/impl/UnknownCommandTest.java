package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.Constants;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class UnknownCommandTest extends BaseTest {

	Robot robot = null;
	InvocationContext context = null;
	ByteArrayOutputStream content = null;
	Command<Robot> command = new UnknownCommand();

	@Before
	public void setUp() throws InvalidArgumentException {
		robot = new ToyRobot(surface);
		context = new InvocationContext("KHALESI");
	}

	@Test
	public void testThatExecuteDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, context));
	}

	@Test
	public void testThatExecuteReturnsCorrectMessage() throws Exception {
		content = new ByteArrayOutputStream();
		System.setErr(new PrintStream(content));
		command.execute(robot, context);
		assertThat(content.toString().trim(), is(equalTo(Constants.WRONG_COMMAND.trim())));
	}

	@Test
	public void testThatExecuteReturnsCorrectArguments() throws Exception {
		content = new ByteArrayOutputStream();
		System.setErr(new PrintStream(content));
		command.execute(robot, new InvocationContext("KHALESI MY,DRAGONS"));
		assertThat(content.toString().trim(), is(equalTo(Constants.WRONG_COMMAND.concat("MY,DRAGONS").trim())));
	}
}
