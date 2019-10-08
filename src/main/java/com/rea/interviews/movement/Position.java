package com.rea.interviews.movement;

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

	/**
	 * Creates a position given valid coordinates and face direction.
	 *
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param face The compass Face
	 *
	 * @throws InvalidArgumentException If the face is null.
	 */
	public Position(int x, int y, Face face) throws InvalidArgumentException {
		this.x = x;
		this.y = y;
		this.setFace(face);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Face getFace() {
		return this.face;
	}

	private void setFace(Face face) throws InvalidArgumentException {
		if (face == null) {
			throw new InvalidArgumentException("Face cannot be null.");
		}
		this.face = face;
	}
}
