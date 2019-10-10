package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class ReportCommandTest extends BaseTest {

	Robot robot = null;
	ByteArrayOutputStream content = null;
	Command<Robot> command = new ReportCommand();
	Command<Robot> placeCommand = new PlaceCommand();

	@Before
	public void setUp() throws Exception {
		robot = new ToyRobot(surface);
		placeCommand.execute(robot, context);
	}

	@Test
	public void testThatReportDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, context));
	}

	@Test
	public void testThatExecuteReturnsCorrectMessage() throws Exception {
		content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		command.execute(robot, context);
		assertThat(content.toString().trim(), is(equalTo("0,0,NORTH")));
	}

	@Test
	public void testThatExecuteReturnsCorrectPosition() throws Exception {
		content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		InvocationContext context = new InvocationContext("PLACE 1,2,WEST");
		// execute
		placeCommand.execute(robot, context);
		command.execute(robot, context);
		assertThat(content.toString().trim(), is(equalTo("1,2,WEST")));
	}

	@Test
	public void testThatExecuteReturnsCorrectPositionOnSubsequentRuns() throws Exception {
		content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		InvocationContext context = new InvocationContext("PLACE 1,2,NORTH");
		// execute
		placeCommand.execute(robot, context);
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		command.execute(robot, context);
		assertThat(content.toString().trim(), is(equalTo("1,4,NORTH")));
	}

	@Test
	public void testThatNonPlaceRobotIgnoresMoveCommand() throws Exception {
		ToyRobot bot = new ToyRobot(surface);
		Position pos = command.execute(bot, westContext).getPosition();
		assertNull(pos);
	}

	@Test
	public void testThatExecuteOnNonPlacedRobotReturnsEmptyString() throws Exception {
		content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		// execute
		command.execute(new ToyRobot(surface), context);
		assertThat(content.toString().trim(), is(equalTo("")));
	}
}
