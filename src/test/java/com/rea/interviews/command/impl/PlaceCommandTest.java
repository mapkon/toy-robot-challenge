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

public class PlaceCommandTest extends BaseTest {

	Robot robot = null;
	Command<Robot> command = new PlaceCommand();

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
	public void testThatExecuteChangesXCoordinateOnRobot() throws Exception {
		Position position = command.execute(robot, context).getPosition();
		assertThat(position.getX(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteChangesYCoordinateOnRobot() throws Exception {
		Position position = command.execute(robot, context).getPosition();
		assertThat(position.getY(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteSetsTheFace() throws Exception {
		Position position = command.execute(robot, context).getPosition();
		assertThat(position.getFace(), is(equalTo(Face.NORTH)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatExecuteThrowsExceptionOnInvalidCoordinate() throws Exception {
		InvocationContext invalidContext = new InvocationContext("PLACE s,0,NORTH");
		command.execute(robot, invalidContext);
	}

	@Test(expected = InvalidArgumentException.class)
	public void testThatExecuteThrowsExceptionOnInvalidFace() throws Exception {
		InvocationContext invalidContext = new InvocationContext("PLACE 1,0,NERTH");
		command.execute(robot, invalidContext);
	}

	// Tests on robot remote handle
	@Test
	public void testThatExecuteSetsXCoordinateOnRobot() throws Exception {
		Position position = command.execute(robot, context).getPosition();
		assertThat(position.getX(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteSetsYCoordinateOnRobot() throws Exception {
		Position position = command.execute(robot, context).getPosition();
		assertThat(position.getY(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteSetsFaceOnRobot() throws Exception {
		Position position = command.execute(robot, southContext).getPosition();
		assertThat(position.getFace(), is(equalTo(Face.SOUTH)));
	}

	@Test
	public void testThatGetFaceDoesNotReturnNull() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertNotNull(command.getFace("NORTH"));
	}

	@Test
	public void testThatGetFaceReturnsCorrectFaceForNorth() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertThat(command.getFace("NoRth"), is(equalTo(Face.NORTH)));
	}

	@Test
	public void testThatGetFaceReturnsCorrectFaceForEast() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertThat(command.getFace("EasT"), is(equalTo(Face.EAST)));
	}

	@Test
	public void testThatGetFaceReturnsCorrectFaceForSouth() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertThat(command.getFace("South"), is(equalTo(Face.SOUTH)));
	}

	@Test
	public void testThatGetFaceReturnsCorrectFaceForWest() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertThat(command.getFace("WEsT"), is(equalTo(Face.WEST)));
	}
	
	@Test(expected = InvalidArgumentException.class)
	public void testThatUnknownFaceThrowsException() throws InvalidArgumentException {
		PlaceCommand command = new PlaceCommand();
		assertThat(command.getFace("Ned Stark"), is(equalTo(Face.WEST)));
	}
}
