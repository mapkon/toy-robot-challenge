package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class MoveCommandTest extends BaseTest {

	Robot robot = null;
	Command<Robot> command = new MoveCommand();
	Command<Robot> placeCommand = new PlaceCommand();

	@Before
	public void setUp() throws InvalidArgumentException {
		robot = new ToyRobot();
	}

	@Test
	public void testThatExecuteDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, context));
	}

	@Test
	public void testThatExecuteReturnsRobot() throws Exception {
		assertThat(command.execute(robot, context), instanceOf(Robot.class));
	}

	@Test
	public void testThatExecuteDoesNotChangeFace() throws Exception {
		placeCommand.execute(robot, context);
		Position pos = command.execute(robot, context).getPosition();
		assertThat(pos.getFace(), is(equalTo(Face.NORTH)));
	}

	@Test
	public void testThatExecuteModifiesYCoordinateOnNorthFace() throws Exception {
		placeCommand.execute(robot, context);
		Position pos = command.execute(robot, context).getPosition();
		assertThat(pos.getY(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteDoesNotModifyXCoordinateOnNorthFace() throws Exception {
		placeCommand.execute(robot, context);
		Position pos = command.execute(robot, context).getPosition();
		assertThat(pos.getX(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteModifiesYCoordinateOnSouthFace() throws Exception {
		placeCommand.execute(robot, southContext);
		Position pos = command.execute(robot, southContext).getPosition();
		assertThat(pos.getY(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteDoesNotModifyXCoordinateOnSouthFace() throws Exception {
		placeCommand.execute(robot, southContext);
		Position pos = command.execute(robot, southContext).getPosition();
		assertThat(pos.getX(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteDoesNotModifYCoordinateOnEastFace() throws Exception {
		placeCommand.execute(robot, eastContext);
		Position pos = command.execute(robot, eastContext).getPosition();
		assertThat(pos.getY(), is(equalTo(2)));
	}

	@Test
	public void testThatExecuteModifiesXCoordinateOnEastFace() throws Exception {
		placeCommand.execute(robot, eastContext);
		Position pos = command.execute(robot, eastContext).getPosition();
		assertThat(pos.getX(), is(equalTo(2)));
	}

	@Test
	public void testThatExecuteDoesNotModifYCoordinateOnWestFace() throws Exception {
		placeCommand.execute(robot, westContext);
		Position pos = command.execute(robot, westContext).getPosition();
		assertThat(pos.getY(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteModifiesXCoordinateOnWestFace() throws Exception {
		placeCommand.execute(robot, westContext);
		Position pos = command.execute(robot, westContext).getPosition();
		assertThat(pos.getX(), is(equalTo(1)));
	}
}
