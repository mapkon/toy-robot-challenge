package com.rea.interviews.movement;

import com.rea.interviews.Constants;
import com.rea.interviews.exception.InvalidArgumentException;

/**
 *
 * Models the positional information of a given a context.
 *
 * @author Night King
 *
 */
public class Position {

	private int x;
	private int y;
	private Face face;
	private int MAX_COORDINATE = 4;

	/**
	 * Creates a position given valid coordinates and face direction.
	 *
	 * @param x    The X coordinate
	 * @param y    The Y coordinate
	 * @param face The compass Face
	 *
	 * @throws InvalidArgumentException If the face is null.
	 */
	public Position(int x, int y, Face face) throws InvalidArgumentException {
		this.setFace(face);
		this.x = this.setX(x);
		this.y = this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	private int setX(int x) throws InvalidArgumentException {
		if (x > MAX_COORDINATE) {
			throw new InvalidArgumentException(Constants.INVALID_X_COORDINATE);
		}
		return x;
	}

	public int getY() {
		return this.y;
	}

	private int setY(int y) throws InvalidArgumentException {
		if (y > MAX_COORDINATE) {
			throw new InvalidArgumentException(Constants.INVALID_Y_COORDINATE);
		}
		return y;
	}

	public Face getFace() {
		return this.face;
	}

	private void setFace(Face face) throws InvalidArgumentException {
		if (face == null) {
			throw new InvalidArgumentException(Constants.INVALID_FACE);
		}
		this.face = face;
	}
}
