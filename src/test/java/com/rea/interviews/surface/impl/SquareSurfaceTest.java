package com.rea.interviews.surface.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.command.impl.LeftCommand;
import com.rea.interviews.command.impl.MoveCommand;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.exception.InvalidPositionException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;
import com.rea.interviews.surface.Surface;

public class SquareSurfaceTest extends BaseTest {

	Robot robot = null;
	Position position = null;
	Surface surface = new SquareSurface();

	@Before
	public void setUp() throws InvalidArgumentException {
		robot = new ToyRobot(surface);
		position = new Position(0, 1, Face.NORTH);
	}

	@Test
	public void testThatIsValidPositionReturnsTrueForValidPosition() throws Exception {
		assertTrue(surface.isValidPosition(position));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidXCoordinateLessThanMinThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(-6, 0, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidXCoordinateGreaterThanMaxThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(6, 0, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidYCoordinateLessThanMinThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(0, -6, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidYCoordinateGreaterThanMaxThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(0, 6, Face.EAST)));
	}

	@Test
	public void testThatAddCommandDoesNotReturnNull() {
		assertNotNull(surface.addExecutedCommand(command));
	}

	@Test
	public void testThatAddCommandUpdatesCommandSize() throws Exception {
		Surface surf = this.executeCommands();
		assertEquals(2, surf.getExecutedCommands().size());
	}

	@Test
	public void testThatAddCommandUpdatesCommandSizeX2() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		Surface surf = this.executeCommandLeft(bot);
		assertEquals(3, surf.getExecutedCommands().size());
	}

	@Test
	public void testThatPopCommandReturnCorrectCommand() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		Surface surf = this.executeCommandLeft(bot);
		assertThat(surf.getExecutedCommands().pop().getClass(), is(equalTo(LeftCommand.class)));
	}

	@Test
	public void testThatPopCommandReturnCorrectLastCommand() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		Surface surf = this.executeCommandLeft(bot);
		Stack<Command<Robot>> executedCommands = surf.getExecutedCommands();
		executedCommands.pop();
		assertThat(executedCommands.pop().getClass(), is(equalTo(MoveCommand.class)));
	}

	@Test
	public void testThatPopCommandReturnCorrectFirstCommand() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		Surface surf = this.executeCommandLeft(bot);
		Stack<Command<Robot>> executedCommands = surf.getExecutedCommands();
		executedCommands.pop();
		executedCommands.pop();
		assertThat(executedCommands.pop().getClass(), is(equalTo(PlaceCommand.class)));
	}

	private Surface executeCommands() throws Exception {
		Surface surf = new SquareSurface();
		Robot bot = new ToyRobot(surf);
		command.execute(bot, context);
		moveCommand.execute(bot, new InvocationContext("MOVE"));
		return surf;
	}

	@Test
	public void testThatRetraceStepsDoesNotReturnNull() throws Exception {
		command.execute(robot, context);
		assertNotNull(surface.retraceSteps(robot));
	}

	@Test
	public void testThatRetraceStepsReturnsRobotToOriginalPlacement() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		this.executeCommandLeft(bot);
		bot.getSurface().retraceSteps(bot).getPosition();
		assertThat(bot.toString(), is(equalTo("0,0,0,NORTH")));
	}

	@Test
	public void testThatRetraceStepsReturnsRobotToOriginalXCoordinate() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		this.executeCommandLeft(bot);
		Position pos = bot.getSurface().retraceSteps(bot).getPosition();
		assertThat(pos.getX(), is(equalTo(0)));
	}

	@Test
	public void testThatRetraceStepsReturnsRobotToOriginalYCoordinate() throws Exception {
		ToyRobot bot = new ToyRobot(new SquareSurface());
		this.executeCommandLeft(bot);
		Position pos = bot.getSurface().retraceSteps(bot).getPosition();
		assertThat(pos.getY(), is(equalTo(0)));
	}
}
