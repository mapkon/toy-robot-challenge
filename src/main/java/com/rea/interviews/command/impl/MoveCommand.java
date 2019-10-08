package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

public class MoveCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws InvalidArgumentException {

		Position currentPosition = robot.getPosition();
		Face face = currentPosition.getFace();
		switch (face) {
		case NORTH:
			robot.setPosition(new Position(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getFace()));
		default:
			break;
		}
		return robot;
	}
}
