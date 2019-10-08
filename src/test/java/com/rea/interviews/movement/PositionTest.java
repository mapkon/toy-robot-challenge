package com.rea.interviews.movement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.rea.interviews.exception.InvalidArgumentException;

@TestInstance(Lifecycle.PER_CLASS)
public class PositionTest {

	Position position = null;

	@BeforeAll
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

	@Test
	public void testThatNullFaceThrowsException() {
		assertThrows(InvalidArgumentException.class, () -> {
			new Position(0, 0, null);
		});
	}
}
