package com.rea.interviews.command;

import com.rea.interviews.command.impl.ExitCommand;
import com.rea.interviews.command.impl.JumpCommand;
import com.rea.interviews.command.impl.LeftCommand;
import com.rea.interviews.command.impl.MoveCommand;
import com.rea.interviews.command.impl.PlaceCommand;
import com.rea.interviews.command.impl.ReplayCommand;
import com.rea.interviews.command.impl.ReportCommand;
import com.rea.interviews.command.impl.RightCommand;
import com.rea.interviews.command.impl.UnknownCommand;
import com.rea.interviews.robot.Robot;

/**
 * A factory that takes in the abstract invocation context and returns a
 * concrete command that can be executed on with a robot interface.
 * <p>
 * The invocation context should follow the following pattern:
 * <p>
 * <code>
 * COMMAND X,Y,FACE
 * </code>
 * <p>
 * Some commands are independent and can be invoked separately:
 * <p>
 * <code>
 * MOVE
 * <br>
 * REPORT
 * <br>
 * EXIT
 * <p>
 * </code>
 *
 * Invalid commands should not make the system to crash but gracefully display a
 * notification and expect to continue.
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class CommandFactory {

	public static Command<Robot> getCommand(String context) {
		return getRobotCommand(getContextCommand(context));
	}

	static Command<Robot> getRobotCommand(RobotCommands rCommand) {
		Command<Robot> command = null;
		switch (rCommand) {
		case PLACE:
			command = new PlaceCommand();
			break;
		case MOVE:
			command = new MoveCommand();
			break;
		case JUMP:
			command = new JumpCommand();
			break;
		case LEFT:
			command = new LeftCommand();
			break;
		case RIGHT:
			command = new RightCommand();
			break;
		case REPORT:
			command = new ReportCommand();
			break;
		case REPLAY:
			command = new ReplayCommand();
			break;
		case EXIT:
			command = new ExitCommand();
			break;
		default:
			command = new UnknownCommand();
		}
		return command;
	}

	static RobotCommands getContextCommand(String invocationContext) {
		try {
			return RobotCommands.valueOf(invocationContext.split(" ")[0]);
		} catch (Exception ex) {
			return RobotCommands.UNKNOWN;
		}
	}
}
