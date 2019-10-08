package com.rea.interviews.command;

import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.command.impl.UnknownCommand;
import com.rea.interviews.robot.Robot;

/**
 * The invocation context for a given simulation.
 * <p>
 * This could be a set of commands captured from the command line or command that
 * have been read in from a file. It is assumed that the commands will be in the
 * following format:
 * <p>
 * <code>
 * COMMAND X_COORD,Y_COORD,FACE
 * COMMAND
 * </code>
 *
 * @author Night King
 *
 */
public class InvocationContext {

	private String x;
	private String y;
	private String args = "";
	private String face = "";
	private Command<Robot> command = null;

	public InvocationContext(String invocationContext) {
		this.command = this.getRobotCommand(getContextCommand(invocationContext));
		this.setArgs(this.getCommandArguments(invocationContext));
	}

	public Command<Robot> getCommand() {
		return command;
	}

	public String getArgs() {
		return args;
	}

	public InvocationContext setArgs(String args) {
		this.args = args;
		return this;
	}

	public String getFace() {
		return this.face;
	}

	private InvocationContext setFace(String face) {
		this.face = face;
		return this;
	}

	public String getY() {
		return this.y;
	}

	private InvocationContext setY(String y) {
		this.y = y;
		return this;
	}

	public String getX() {
		return this.x;
	}

	public InvocationContext setX(String x) {
		this.x = x;
		return this;
	}

	RobotCommands getContextCommand(String invocationContext) {
		return RobotCommands.valueOf(invocationContext.split(" ")[0]);
	}

	String getCommandArguments(String invocationContext) {
		String[] context = invocationContext.split(" ");
		if (context.length > 1) {
			String[] args = context[1].split(",");
			this.setX(args[0]);
			this.setY(args[1]);
			this.setFace(args[2]);
			return context[1].toString();
		}
		return "";
	}

	Command<Robot> getRobotCommand(RobotCommands command) {
		switch (command) {
		case PLACE:
			return new PlaceCommand();
		default:
			return new UnknownCommand();
		}
	}
}
