package com.rea.interviews.command.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rea.interviews.BaseTest;
import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Face;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;
import com.rea.interviews.surface.impl.SquareSurface;

public class ReplayCommandTest extends BaseTest {

	Command<Robot> command = new ReplayCommand();
	Robot robot = new ToyRobot(new SquareSurface());

	@Test
	public void testThatExecuteDoesNotReturnNull() throws Exception {
		assertNotNull(command.execute(robot, new InvocationContext("PLACE 2,3,EAST")));
	}
	
	@Test
	public void testThatReplayReturnsToOriginalFace() throws Exception {
		this.executeCommandLeft(robot);
		command.execute(robot, new InvocationContext("REPLAY"));
		assertThat(robot.getPosition().getFace(), is(equalTo(Face.NORTH)));
	}
	
	@Test
	public void testThatReplayReturnsToOriginalXCoordinate() throws Exception {
		this.executeCommandLeft(robot);
		command.execute(robot, new InvocationContext("REPLAY"));
		assertThat(robot.getPosition().getX(), is(equalTo(0)));
	}
	
	@Test
	public void testThatReplayReturnsToOriginalYCoordinate() throws Exception {
		this.executeCommandLeft(robot);
		command.execute(robot, new InvocationContext("REPLAY"));
		assertThat(robot.getPosition().getY(), is(equalTo(0)));
	}
}
