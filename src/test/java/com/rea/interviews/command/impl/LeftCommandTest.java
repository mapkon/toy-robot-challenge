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
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class LeftCommandTest extends BaseTest {

	Robot robot = null;
	Command<Robot> command = new LeftCommand();
	InvocationContext context = new InvocationContext("LEFT");

	@Before
	public void setUp() throws Exception {
		robot = new ToyRobot(surface);
		new PlaceCommand().execute(robot, eastContext);
	}

	@Test
	public void testThatExecuteDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, context));
	}

	@Test
	public void testThatExecuteChangesTheFace() throws Exception {
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getFace(), is(equalTo(Face.NORTH)));
	}

	@Test
	public void testThatExecuteDoesNotChangeXCoordinate() throws Exception {
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getX(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteDoesNotChangeYCoordinate() throws Exception {
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getY(), is(equalTo(2)));
	}

	@Test
	public void testThatExecuteChangesTheFaceForWest() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_WEST));
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getFace(), is(equalTo(Face.SOUTH)));
	}

	@Test
	public void testThatExecuteChangesTheFaceForSouth() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_SOUTH));
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getFace(), is(equalTo(Face.EAST)));
	}

	@Test
	public void testThatExecuteChangesTheFaceForEast() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_EAST));
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getFace(), is(equalTo(Face.NORTH)));
	}

	@Test
	public void testThat360ExecuteReturnsToInitialFace() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_EAST));
		command.execute(robot, context); // North
		command.execute(robot, context); // West
		command.execute(robot, context); // South
		Robot invocation = command.execute(robot, context);
		assertThat(invocation.getPosition().getFace(), is(equalTo(Face.EAST)));
	}

	@Test
	public void testThatExecuteMoveChangesFaceAndXCoordinate() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_EAST));
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		Robot bot = command.execute(robot, context);
		// X was initially one, should increment to two
		assertThat(bot.getPosition().getX(), is(equalTo(2)));
	}

	@Test
	public void testThatExecuteMoveChangesFaceAndYCoordinate() throws Exception {
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_SOUTH));
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		Robot bot = command.execute(robot, context);
		// Y was initially one, should decrement to zero
		assertThat(bot.getPosition().getY(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteMoveAndReportShowsCorrectResults() throws Exception {
		ByteArrayOutputStream content = new ByteArrayOutputStream();
		System.setOut(new PrintStream(content));
		new PlaceCommand().execute(robot, new InvocationContext(PLACE_CONTEXT_EAST));
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		command.execute(robot, context);
		new MoveCommand().execute(robot, new InvocationContext("MOVE"));
		new ReportCommand().execute(robot, new InvocationContext("REPORT"));
		assertThat(content.toString().trim(), is(equalTo("3,3,0,NORTH")));
	}

	@Test
	public void testThatNonPlaceRobotIgnoresMoveCommand() throws Exception {
		ToyRobot bot = new ToyRobot(surface);
		Position pos = command.execute(bot, westContext).getPosition();
		assertNull(pos);
	}
}
