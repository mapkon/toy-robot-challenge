package com.rea.interviews.command;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.command.impl.UnknownCommand;

@TestInstance(Lifecycle.PER_CLASS)
public class InvocationContextTest extends BaseTest {

	@Test
	public void testThatCreateAnInvocationDoesNotReturnNull() {
		assertNotNull(new InvocationContext(PLACE_INVOCATION));
	}

	@Test
	public void testThatCreateInvocationContextHasACommand() {
		assertNotNull(context.getCommand());
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectPlaceCommand() {
		assertThat(context.getContextCommand(PLACE_INVOCATION), is(equalTo(RobotCommands.PLACE)));
	}


	@Test
	public void testThatGetRobotCommandDoesNotReturnNull() {
		assertNotNull(context.getRobotCommand(RobotCommands.PLACE));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectPlaceCommand() {
		assertThat(context.getRobotCommand(RobotCommands.PLACE), instanceOf(PlaceCommand.class));
	}


	@Test
	public void testThatGetRobotCommandReturnsUnknownForUndefinedCommand() {
		assertThat(context.getRobotCommand(RobotCommands.UNKNOWN), instanceOf(UnknownCommand.class));
	}

	@Test
	public void testThatGetCommandArgumentsDoesNotReturnNull() {
		assertNotNull(context.getContextCommand(PLACE_INVOCATION));
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