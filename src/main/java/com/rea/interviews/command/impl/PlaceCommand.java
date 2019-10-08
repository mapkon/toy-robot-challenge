package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * Models the interface for the <code>PLACE</code> command. 
 * <p>
 * The expected invocation context should follow this pattern: 
 * <code>
 * PLACE X_COORD,Y_COORD,FACE
 * </code> 
 * <p>
 * An example would be:
 * <p>
 * <code>
 * PLACE 0,0,NORTH
 * </code>
 * <p>
 * Which would place the Robot at x coordinate 0 and y coordinate 0 facing NORTH.
 * 
 * @author Night King
 *
 */
public class PlaceCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		Position position = new Position(Integer.parseInt(context.getX()), Integer.parseInt(context.getY()),
				Face.valueOf(context.getFace()));
		return robot.setPosition(position);
	}
}
