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
	private int z = 0;
	private Face face;

	public Position() {
	}

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
		this.x = x;
		this.y = y;
		this.setFace(face);
	}

	/**
	 * Creates a position given valid coordinates and face direction.
	 *
	 * @param x    The X coordinate
	 * @param y    The Y coordinate
	 * @param z    The Z coordinate for determining depth
	 * @param face The compass Face
	 *
	 * @throws InvalidArgumentException If the face is null.
	 */
	public Position(int x, int y, int z, Face face) throws InvalidArgumentException {
		this.x = x;
		this.y = y;
		this.z = z;
		this.setFace(face);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getZ() {
		return this.z;
	}

	public Position setZ(int z) {
		this.z = z;
		return this;
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
