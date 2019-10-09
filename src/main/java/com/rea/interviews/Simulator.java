package com.rea.interviews;

import java.io.Console;

import com.rea.interviews.command.Command;
import com.rea.interviews.command.CommandFactory;
import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.exception.ExitException;
import com.rea.interviews.robot.Robot;
import com.rea.interviews.robot.impl.ToyRobot;

public class Simulator {

	public static void main(String[] args) throws Exception {

		boolean isReady = true;
		Robot robot = new ToyRobot();
		Console simulationConsole = System.console();

		if (simulationConsole == null) {
			System.err.println("No available console for simulation.");
			System.exit(1);
		}
		// House ice keeping
		System.out.print("\033\143");
		System.out.println("=== REA Robot Simulator === \n");
		System.out.println("Hey, my name is Toy Robot. To move me around, you will need to enter commands.");
		System.out.println("Valid commands are:\n");
		System.out.println("\'PLACE X,Y,NORTH | EAST | WEST | SOUTH\', MOVE, LEFT, RIGHT, REPORT and EXIT.\n");
		while (isReady) {
			String invocationContext = simulationConsole.readLine("~: ");
			try {
				Command<Robot> command = CommandFactory.getCommand(invocationContext);
				command.execute(robot, new InvocationContext(invocationContext));
			} catch(ExitException ex) {
				System.out.println(ex.getMessage());
				System.exit(0);
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
