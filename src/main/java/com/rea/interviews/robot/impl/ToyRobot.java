package com.rea.interviews.robot.impl;

import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.surface.Surface;

/**
 * An implementation of the robot interface to be used in textual simulations.
 * <p>
 * A robot requires a valid surface to move on, not the other way round, simply
 * because most surfaces are dumb things that just provide boundaries for
 * movement, which are farther interpreted by the Robot.
 *
 * @see Surface
 * @author Night King
 *
 */
public class ToyRobot implements Robot {

	private Surface surface;
	private Boolean placed = false;
	private Position position = null;

	public ToyRobot(Surface surface) {
		this.surface = surface;
	}

	@Override
	public boolean isPlaced() {
		return this.placed;
	}

	@Override
	public Robot setPlaced(boolean placed) {
		this.placed = placed;
		return this;
	}

	@Override
	public Surface getSurface() {
		return this.surface;
	}

	@Override
	public Robot setSurface(Surface surface) {
		this.surface = surface;
		return this;
	}

	@Override
	public Robot setPosition(Position position) {
		// validate position using surface
		this.position = position;
		return this;
	}

	public Position getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		final String SEPARATOR = ",";
		StringBuilder report = new StringBuilder();
		report.append(this.position.getX());
		report.append(SEPARATOR);
		report.append(this.position.getY());
		report.append(SEPARATOR);
		report.append(position.getFace());
		return report.toString();
	}
}
