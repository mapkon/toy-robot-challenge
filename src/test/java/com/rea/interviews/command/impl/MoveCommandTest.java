package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

@TestInstance(Lifecycle.PER_CLASS)
public class MoveCommandTest extends BaseTest {

	Robot robot = null;
	Command<Robot> command = new MoveCommand();

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
	public void testThatExecuteDoesNotChangeFace() throws Exception {
		Position pos = command.execute(robot, context).getPosition();
		assertThat(pos.getFace(), is(equalTo(Face.NORTH)));
	}

	@Test
	public void testThatExecuteModifiesYCoordinateOnNorthFace() throws Exception {
		Robot bot = new ToyRobot();
		Position pos = command.execute(bot, context).getPosition();
		assertThat(pos.getY(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteDoesNotModifyXCoordinateOnNorthFace() throws Exception {
		Robot bot = new ToyRobot();
		Position pos = command.execute(bot, context).getPosition();
		assertThat(pos.getX(), is(equalTo(0)));
	}

	@Test
	public void testThatExecuteModifiesYCoordinateOnSouthFace() throws Exception {
		Robot bot = new ToyRobot();
		Position pos = command.execute(bot, context).getPosition();
		assertThat(pos.getY(), is(equalTo(1)));
	}

	@Test
	public void testThatExecuteDoesNotModifyXCoordinateOnSouthFace() throws Exception {
		Robot bot = new ToyRobot();
		Position pos = command.execute(bot, context).getPosition();
		assertThat(pos.getX(), is(equalTo(0)));
	}
}
