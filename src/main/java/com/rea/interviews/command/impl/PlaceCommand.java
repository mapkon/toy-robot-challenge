package com.rea.interviews.command.impl;

import com.rea.interviews.Constants;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * Models the interface for the <code>PLACE</code> command.
 * <p>
 * The expected invocation context should follow this pattern: <code>
 * PLACE X_COORD,Y_COORD,FACE
 * </code>
 * <p>
 * An example would be:
 * <p>
 * <code>
 * PLACE 0,0,NORTH
 * </code>
 * <p>
 * Which would place the Robot at x coordinate 0 and y coordinate 0 facing
 * NORTH.
 * 
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class PlaceCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		int _x = Integer.parseInt(context.getX());
		int _y = Integer.parseInt(context.getY());
		Position newPosition = new Position(_x, _y, this.getFace(context.getFace()));
		return robot.setPosition(newPosition);
	}

	Face getFace(String face) throws InvalidArgumentException {
		try {
			return Face.valueOf(face.toUpperCase());
		} catch (Exception ex) {
			throw new InvalidArgumentException(Constants.INVALID_FACE);
		}
	}
}
