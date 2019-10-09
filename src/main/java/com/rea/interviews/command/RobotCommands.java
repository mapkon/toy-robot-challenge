package com.rea.interviews.command;

/**
 * Models the command constants that can be superimposed onto the robot in a
 * given simulation.
 *
 * <p>
 * The following commands are supported:
 * <p>
 * <code>
 *  <br>PLACE
 *  <br>MOVE
 *  <br>LEFT
 *  <br>RIGHT
 *  <br>REPORT
 *  <br>REPLAY
 *  </code>
 *
 * @author Night King
 *
 */
public enum RobotCommands {
	PLACE, MOVE, LEFT, RIGHT, REPORT, REPLAY, EXIT, UNKNOWN
}
