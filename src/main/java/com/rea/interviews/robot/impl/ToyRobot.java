package com.rea.interviews.robot.impl;

import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * An implementation of the robot interface to be used in textual simulations.
 *
 * @author Night King
 *
 */
public class ToyRobot implements Robot {

	private Position position = null;

	public ToyRobot() throws InvalidArgumentException {
		this.position = new Position(0, 0, Face.NORTH);
	}

	@Override
	public Robot setPosition(Position position) {
		this.position = position;
		return this;
	}

	public Position getPosition() {
		return this.position;
	}
}
