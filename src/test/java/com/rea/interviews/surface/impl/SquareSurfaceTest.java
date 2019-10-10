package com.rea.interviews.surface.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.exception.InvalidPositionException;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;
import com.rea.interviews.surface.Surface;

public class SquareSurfaceTest extends BaseTest {

	Position position = null;
	Surface surface = new SquareSurface();

	@Before
	public void setUp() throws InvalidArgumentException {
		position = new Position(0, 1, Face.NORTH);
	}

	@Test
	public void testThatIsValidPositionReturnsTrueForValidPosition() throws Exception {
		assertTrue(surface.isValidPosition(position));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidXCoordinateLessThanMinThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(-6, 0, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidXCoordinateGreaterThanMaxThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(6, 0, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidYCoordinateLessThanMinThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(0, -6, Face.EAST)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatInvalidYCoordinateGreaterThanMaxThrowsException() throws Exception {
		assertTrue(surface.isValidPosition(new Position(0, 6, Face.EAST)));
	}
}
