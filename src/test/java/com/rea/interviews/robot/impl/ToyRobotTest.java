package com.rea.interviews.robot.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.command.impl.LeftCommand;
import com.rea.interviews.command.impl.MoveCommand;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.command.impl.ReportCommand;
import com.rea.interviews.exception.InvalidPositionException;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.surface.impl.SquareSurface;

public class ToyRobotTest extends BaseTest {

	ToyRobot bot = new ToyRobot(surface);
	Command<Robot> pCommand = new PlaceCommand();

	@Test
	public void testThatToStringDoesNotReturnDefaultString() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 0,0,NORTH"));
		assertThat(bot.toString(), is(equalTo("0,0,NORTH")));
	}

	@Test
	public void testThatToStringReturnsProperPosition() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,WEST"));
		assertThat(bot.toString(), is(equalTo("1,2,WEST")));
	}

	@Test
	public void testThatToStringReturnsProperPositionAfterMove() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,WEST"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		assertThat(bot.toString(), is(equalTo("0,2,WEST")));
	}

	@Test
	public void testThatToStringReturnsProperPositionAfterMultipleMoves() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,NORTH"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		assertThat(bot.toString(), is(equalTo("1,4,NORTH")));
	}

	@Test(expected = InvalidPositionException.class)
	public void testThatExceptionIsThrownOnInvalidMultipleMoves() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,NORTH"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		assertThat(bot.toString(), is(equalTo("1,5,NORTH")));
	}

	public void testThatExcuteReturnsCorrectReportOnMultipleMoves() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 0,0,NORTH"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new ReportCommand().execute(bot, new InvocationContext("REPORT"));
		assertThat(bot.toString(), is(equalTo("0,1,NORTH")));
	}

	public void testThatExcuteReturnsCorrectReportOnMultipleMoves1() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 0,0,NORTH"));
		new LeftCommand().execute(bot, new InvocationContext("LEFT"));
		new ReportCommand().execute(bot, new InvocationContext("REPORT"));
		assertThat(bot.toString(), is(equalTo("0,0,WEST")));
	}

	public void testThatExcuteReturnsCorrectReportOnMultipleMoves2() throws Exception {
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,EAST"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new LeftCommand().execute(bot, new InvocationContext("LEFT"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new ReportCommand().execute(bot, new InvocationContext("REPORT"));
		assertThat(bot.toString(), is(equalTo("3,3,NORTH")));
	}

	@Test
	public void testThatRobotHasSurface() {
		assertNotNull(new ToyRobot(new SquareSurface()));
	}
}
