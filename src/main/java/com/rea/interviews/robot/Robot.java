package com.rea.interviews.robot;

import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.movement.Position;
import com.rea.interviews.surface.Surface;

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
	 * Ascertains if the robot has been placed in a valid position in order to
	 * receive subsequent commands. A robot that has not been placed will ignore all
	 * other commands until it is placed.
	 *
	 * @return If the robot has been placed.
	 */
	boolean isPlaced();

	/**
	 * Updates the placed status of the robot. A robot that has not been placed will
	 * ignore all other commands until it is placed.
	 * <p>
	 * It is assumed that this method will be called when the <code>PLACE</code> is
	 * issued.
	 *
	 * @param placed Boolean indicating the status to set.
	 * @return The updated Robot.
	 * @see PlaceCommand
	 */
	Robot setPlaced(boolean placed);

	/**
	 * Returns the surface onto which the current Robot is placed.
	 *
	 * @return The surface the robot is placed.
	 * @see Surface
	 */
	Surface getSurface();

	/**
	 * Sets the surface on which the robot will move.
	 *
	 * @param surface The surface to set.
	 * @return The robot on the surface.
	 */
	Robot setSurface(Surface surface);

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
