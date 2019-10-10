package com.rea.interviews.command;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.impl.ExitCommand;
import com.rea.interviews.command.impl.LeftCommand;
import com.rea.interviews.command.impl.MoveCommand;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.command.impl.ReportCommand;
import com.rea.interviews.command.impl.RightCommand;
import com.rea.interviews.command.impl.UnknownCommand;

public class CommandFactoryTest extends BaseTest {

	final String exitInvocationContext = "EXIT";
	final String moveInvocationContext = "MOVE";
	final String leftInvoicationContext = "LEFT";
	final String rightInvoicationContext = "RIGHT";
	final String reportInvoicationContext = "REPORT";
	final String replayInvoicationContext = "REPLAY";

	@Test
	public void testThatCreateInvocationContextHasACommand() {
		assertNotNull(CommandFactory.getContextCommand(PLACE_INVOCATION));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectPlaceCommand() {
		assertThat(CommandFactory.getContextCommand(PLACE_INVOCATION), is(equalTo(RobotCommands.PLACE)));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectMoveCommand() {
		assertThat(CommandFactory.getContextCommand(moveInvocationContext), is(equalTo(RobotCommands.MOVE)));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectLeftCommand() {
		assertThat(CommandFactory.getContextCommand(leftInvoicationContext), is(equalTo(RobotCommands.LEFT)));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectRightCommand() {
		assertThat(CommandFactory.getContextCommand(rightInvoicationContext), is(equalTo(RobotCommands.RIGHT)));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectReportCommand() {
		assertThat(CommandFactory.getContextCommand(reportInvoicationContext), is(equalTo(RobotCommands.REPORT)));
	}

	@Test
	public void testThatGetContextCommandReturnsCorrectExitCommand() {
		assertThat(CommandFactory.getContextCommand(exitInvocationContext), is(equalTo(RobotCommands.EXIT)));
	}

	@Test
	public void testThatGetCommandArgumentsDoesNotReturnNull() {
		assertNotNull(CommandFactory.getContextCommand(PLACE_INVOCATION));
	}

	@Test
	public void testThatGetCommandDoesNotReturnNull() {
		assertNotNull(CommandFactory.getCommand(PLACE_INVOCATION));
	}

	@Test
	public void testThatGetRobotCommandDoesNotReturnNull() {
		assertNotNull(CommandFactory.getRobotCommand(RobotCommands.PLACE));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectPlaceCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.PLACE), instanceOf(PlaceCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectMoveCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.MOVE), instanceOf(MoveCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectLeftCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.LEFT), instanceOf(LeftCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectRightCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.RIGHT), instanceOf(RightCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectReportCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.REPORT), instanceOf(ReportCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsUnknownForUndefinedCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.UNKNOWN), instanceOf(UnknownCommand.class));
	}

	@Test
	public void testThatGetRobotCommandReturnsCorrectExitCommand() {
		assertThat(CommandFactory.getRobotCommand(RobotCommands.EXIT), instanceOf(ExitCommand.class));
	}
}
