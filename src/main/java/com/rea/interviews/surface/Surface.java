package com.rea.interviews.surface;

import com.rea.interviews.exception.InvalidPositionException;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

/**
 * A surface onto which a robot can be placed.
 * <p>
 * It is expected that the surface have clear dimensions like <code>5x5</code>,
 * which defines the boundaries within which the robot can travel.
 * <p>
 * Surface are not limited to Squares, a surface can be a circle, in which case
 * it will need a boundary check for radius within which the robot should
 * travel.
 *
 *
 * @see Robot
 * @author Night King
 *
 */
public interface Surface {

	/**
	 * Checks if the specified position coordinates are within the allowed
	 * boundaries of the concrete implementation of the surface. Ever surface type
	 * should provide a concrete implementation of this method.
	 * 
	 * @param position The position to validate.
	 * @return A boolean indicating if the Robot can travel to the next specified
	 *         position.
	 * 
	 * @throws InvalidPositionException If the coordinates are out of the allowed
	 *                                  boundaries.
	 * @see Position
	 */
	boolean isValidPosition(Position position) throws InvalidPositionException;
}
