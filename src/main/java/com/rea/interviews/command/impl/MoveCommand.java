package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.surface.Surface;

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
	public InvocationContext getContext() {
		return null;
	}

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		// TODO: Consider refactoring if there is time.
		if (robot.isPlaced()) {
			Position newPosition = null;
			Position currentPosition = robot.getPosition();
			Face face = currentPosition.getFace();
			switch (face) {
			case NORTH:
				newPosition = new Position(currentPosition.getX(), currentPosition.getY() + 1,
						currentPosition.getFace());
				break;
			case SOUTH:
				newPosition = new Position(currentPosition.getX(), currentPosition.getY() - 1,
						currentPosition.getFace());
				break;
			case EAST:
				newPosition = new Position(currentPosition.getX() + 1, currentPosition.getY(),
						currentPosition.getFace());
				break;
			case WEST:
				newPosition = new Position(currentPosition.getX() - 1, currentPosition.getY(),
						currentPosition.getFace());
				break;
			default:
				break;
			}
			Surface surface = robot.getSurface();
			if (surface.isValidPosition(newPosition)) {
				robot.setPosition(newPosition);
				surface.addExecutedCommand(this);
			}
		}
		return robot;
	}
}
