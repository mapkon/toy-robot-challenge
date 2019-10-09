package com.rea.interviews.command;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rea.interviews.BaseTest;

public class InvocationContextTest extends BaseTest {

	@Test
	public void testThatCreateAnInvocationDoesNotReturnNull() {
		assertNotNull(new InvocationContext(PLACE_INVOCATION));
	}

	@Test
	public void testThatGetCommandArgumentsReturnsCorrectArgs() {
		assertThat(context.getCommandArguments(PLACE_INVOCATION), is(equalTo("0,0,NORTH")));
	}

	@Test
	public void testThatGetCommandArgumentsSetsXCoord() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertNotNull(context.getX());
	}

	@Test
	public void testThatGetCommandArgumentsSetsCorrectXCoord() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertThat(context.getX(), is(equalTo(String.valueOf(0))));
	}

	@Test
	public void testThatGetCommandArgumentsSetsYCoord() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertNotNull(context.getY());
	}

	@Test
	public void testThatGetCommandArgumentsSetsCorrectYCoord() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertThat(context.getY(), is(equalTo(String.valueOf(0))));
	}

	@Test
	public void testThatGetCommandArgumentsSetsFaceCoord() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertNotNull(context.getFace());
	}

	@Test
	public void testThatGetCommandArgumentsSetsCorrectFace() {
		context.getCommandArguments(PLACE_INVOCATION);
		assertThat(context.getFace(), is(equalTo("NORTH")));
	}
}