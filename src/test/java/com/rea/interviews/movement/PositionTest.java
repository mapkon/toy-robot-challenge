package com.rea.interviews.movement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.exception.InvalidArgumentException;

public class PositionTest {

	Position position = null;

	@Before
	public void setUp() throws InvalidArgumentException {
		position = new Position(1, 2, Face.NORTH);
	}

	@Test
	public void testThatNewPositionDoesNotReturnNull() throws InvalidArgumentException {
		assertNotNull(new Position(0, 0, Face.NORTH));
	}

	@Test
	public void testThatNewPositionSetsXCoordinate() {
		assertThat(position.getX(), is(equalTo(1)));
	}

	@Test
	public void testThatNewPositionSetsYCoordinate() {
		assertThat(position.getY(), is(equalTo(2)));
	}

	@Test
	public void testThatNewPositionSetsFace() {
		assertThat(position.getFace(), is(equalTo(Face.NORTH)));
	}

	@Test(expected = InvalidArgumentException.class)
	public void testThatNullFaceThrowsException() throws InvalidArgumentException {
		new Position(0, 0, null);
	}

	@Test(expected = InvalidArgumentException.class)
	public void testThatInvalidXCoordThrowsException() throws InvalidArgumentException {
		new Position(5, 0, null);
	}

	@Test(expected = InvalidArgumentException.class)
	public void testThatNullFaceWithZThrowsException() throws InvalidArgumentException {
		new Position(0, 0, 0, null);
	}

	@Test(expected = InvalidArgumentException.class)
	public void testThatInvalidZCoordThrowsException() throws InvalidArgumentException {
		new Position(5, 0, 0, null);
	}
}
