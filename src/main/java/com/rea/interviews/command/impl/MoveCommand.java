package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * Moves the Robot one unit in the direction it is facing.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class MoveCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws InvalidArgumentException {

		Position currentPosition = robot.getPosition();
		Face face = currentPosition.getFace();
		switch (face) {
		case NORTH:
			robot.setPosition(new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getFace()));
			break;
		case SOUTH:
			robot.setPosition(new Position(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getFace()));
			break;
		case EAST:
			robot.setPosition(new Position(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getFace()));
			break;
		case WEST:
			robot.setPosition(new Position(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getFace()));
			break;
		default:
			break;
		}
		return robot;
	}
}
