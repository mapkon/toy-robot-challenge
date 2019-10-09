package com.rea.interviews.command.impl;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.movement.Face;
import com.rea.interviews.movement.Position;

/**
 * Models the command that moves rotates the Robot 90 degrees. This command
 * should not change the coordinates, but should change the Face of the Robot.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class RightCommand extends LeftCommand {

	private final int RIGHT_TURN_PREDICATE = 1;
	Face getFace(Position position) {
		Face currentFace = position.getFace();
		int ordinal = (currentFace.ordinal() + RIGHT_TURN_PREDICATE) < 0 ? MAX_FACE_NUM - 1
				: (currentFace.ordinal() + 1) % MAX_FACE_NUM;
		return Face.values()[ordinal];
	}
}
