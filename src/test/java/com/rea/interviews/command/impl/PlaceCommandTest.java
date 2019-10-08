package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

@TestInstance(Lifecycle.PER_CLASS)
public class PlaceCommandTest extends BaseTest {

	Robot robot = null;
	Command<Robot> command = new PlaceCommand();

	@BeforeAll
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

	@Test
	public void testThatExecuteThrowsExceptionOnInvalidCoordinate() {
		InvocationContext invalidContext = new InvocationContext("PLACE s,0,NORTH");
		assertThrows(NumberFormatException.class, () -> {
			command.execute(robot, invalidContext);
		});
	}

	@Test
	public void testThatExecuteThrowsExceptionOnInvalidFace() {
		InvocationContext invalidContext = new InvocationContext("PLACE 1,0,NERTH");
		assertThrows(IllegalArgumentException.class, () -> {
			command.execute(robot, invalidContext);
		});
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
}
