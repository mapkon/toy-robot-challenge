package com.rea.interviews.robot.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.command.impl.MoveCommand;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.exception.InvalidArgumentException;
import com.rea.interviews.robot.Robot;

public class ToyRobotTests {

	@Test
	public void testThatToStringDoesNotReturnGibberish() throws InvalidArgumentException {
		assertThat(new ToyRobot().toString(), is(equalTo("0,0,NORTH")));
	}

	@Test
	public void testThatToStringReturnsProperPosition() throws Exception {
		ToyRobot bot = new ToyRobot();
		Command<Robot> pCommand = new PlaceCommand();
		pCommand.execute(bot, new InvocationContext("PLACE 1,2,WEST"));
		assertThat(bot.toString(), is(equalTo("1,2,WEST")));
	}

	@Test
	public void testThatToStringReturnsProperPositionAfterMove() throws Exception {
		ToyRobot bot = new ToyRobot();
		new PlaceCommand().execute(bot, new InvocationContext("PLACE 1,2,WEST"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		assertThat(bot.toString(), is(equalTo("0,2,WEST")));
	}

	@Test
	public void testThatToStringReturnsProperPositionAfterMultipleMoves() throws Exception {
		ToyRobot bot = new ToyRobot();
		new PlaceCommand().execute(bot, new InvocationContext("PLACE 1,2,NORTH"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		new MoveCommand().execute(bot, new InvocationContext("MOVE"));
		assertThat(bot.toString(), is(equalTo("1,4,NORTH")));
	}
}
