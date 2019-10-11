package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Position;
import com.rea.interviews.robot.Robot;

public class JumpCommand implements Command<Robot> {

	@Override
	public Robot execute(Robot robot, InvocationContext context) throws Exception {
		if (robot.isPlaced()) {
			Position newPosition = new Position(Integer.parseInt(context.getX()), Integer.parseInt(context.getY()),
					Integer.parseInt(context.getZ()), robot.getPosition().getFace());
			robot.setPosition(newPosition);
		}
		return robot;
	}
}
