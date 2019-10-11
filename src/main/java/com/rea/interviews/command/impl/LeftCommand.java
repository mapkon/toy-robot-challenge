package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * Models the command that moves rotates the Robot 90 degrees.This command
 * should not change the coordinates, but should change the Face of the Robot.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class LeftCommand implements Command<Robot> {

	private final int MAX_FACE_NUM = 4;
	protected int ROTATION_PREDICATE = -1;

	Face getFace(Position position) {
		Face currentFace = position.getFace();
		int predicate = currentFace.ordinal() + ROTATION_PREDICATE;
		int ordinal = predicate < 0 ? MAX_FACE_NUM - 1 : predicate % MAX_FACE_NUM;
		return Face.values()[ordinal];
	}

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws InvalidArgumentException {
		if (robot.isPlaced()) {
			Position currentPosition = robot.getPosition();
			Position newPosition = new Position(currentPosition.getX(), currentPosition.getY(),
					this.getFace(currentPosition));
			// mutate
			robot.setPosition(newPosition);
			robot.getSurface().addExecutedCommand(this);
		}
		return robot;
	}
}
