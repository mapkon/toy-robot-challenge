package com.rea.interviews.surface.impl;

import java.util.Stack;

import com.rea.interviews.Constants;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.impl.LeftCommand;
import com.rea.interviews.command.impl.RightCommand;
import com.rea.interviews.exception.InvalidPositionException;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.surface.Surface;

/**
 * A 5x5 unit implementation of the surface.
 * <p>
 * Since this is a matrix implementation of a surface, it is assumed that the
 * starting ordinal is <code>0</code>, counting upwards to <code>5</code> Thus,
 * all values between <code>0-5</code> are valid as <code>x,y</code>
 * coordinates. <br>
 * Anything out of those boundaries will be considered invalid, as they would
 * imply that the Robot has been placed off the 5x5 grid.
 * 
 * @see Robot
 * @see Surface
 *
 * @author Night King
 *
 */
public class SquareSurface implements Surface {

	private int MAX_COORDINATE = 5;
	private int MIN_COORDINATE = 0;
	Stack<Command<Robot>> executedCommands = new Stack<>();

	@Override
	public boolean isValidPosition(Position position) throws InvalidPositionException {
		if (position.getX() < MIN_COORDINATE) {
			throw new InvalidPositionException(
					Constants.INVALID_X_COORDINATE_LESS_THAN_MIN.concat(Constants.INVALID_COORD_PREDICATE));
		}
		if (position.getX() > MAX_COORDINATE) {
			throw new InvalidPositionException(
					Constants.INVALID_X_COORDINATE_GREATER_THAN_MAX.concat(Constants.INVALID_COORD_PREDICATE));
		}
		if (position.getY() < MIN_COORDINATE) {
			throw new InvalidPositionException(
					Constants.INVALID_Y_COORDINATE_LESS_THAN_MIN.concat(Constants.INVALID_COORD_PREDICATE));
		}
		if (position.getY() > MAX_COORDINATE) {
			throw new InvalidPositionException(
					Constants.INVALID_Y_COORDINATE_GREATER_THAN_MAX.concat(Constants.INVALID_COORD_PREDICATE));
		}
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Robot retraceSteps(Robot robot) throws Exception {
		Object[] cmds = this.executedCommands.toArray();
		final int LEN = cmds.length;
		for (int x = LEN; x > 0; x--) {
			Command<Robot> command = getCommand((Command<Robot>) cmds[x - 1]);
			command.execute(robot, command.getContext());
		}
		return robot;
	}

	private Command<Robot> getCommand(Command<Robot> command) {
		if (command instanceof LeftCommand) {
			command = new RightCommand();
		} else if (command instanceof RightCommand) {
			command = new LeftCommand();
		}
		return command;
	}

	@Override
	public Surface addExecutedCommand(Command<Robot> command) {
		this.executedCommands.push(command);
		return this;
	}

	@Override
	public Stack<Command<Robot>> getExecutedCommands() {
		return this.executedCommands;
	}
}
