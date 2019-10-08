package com.rea.interviews.robot;

import com.rea.interviews.movement.Position;

/**
 * A contract that models the simulation of a given robot.
 * <p>
 * The interface does not really care about the internals of the Robot, apart
 * from the fact that it exposes the required function that can be manipulated
 * for direction.
 *
 * @author Night King
 *
 */
public interface Robot {

	/**
	 * Get the current position of the Robot.
	 *
	 * @return The current position of the Robot.
	 */
	Position getPosition();

	/**
	 * Sets the position of the Robot. Returns the Robot context to support chain
	 * calls.
	 *
	 * @param position The position to set.
	 * @return Current robot context for chained calls.
	 */
	Robot setPosition(Position position);

}
