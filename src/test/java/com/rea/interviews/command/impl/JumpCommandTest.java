package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;
import com.rea.interviews.surface.impl.SquareSurface;

public class JumpCommandTest extends BaseTest {

	Command<Robot> command = new JumpCommand();
	Robot robot = new ToyRobot(new SquareSurface());
	InvocationContext jumpContext = new InvocationContext("JUMP 0,0,2");

	@Before
	public void setUp() throws Exception {
		new PlaceCommand().execute(robot, context);
	}

	@Test
	public void testThatExecuteDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, jumpContext));
	}

	@Test
	public void testThatExecuteSetsTheZCoordinate() throws Exception {
		Position pos = command.execute(robot, jumpContext).getPosition();
		assertThat(pos.getZ(), is(equalTo(2)));
	}
}
