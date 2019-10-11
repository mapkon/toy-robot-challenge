package com.rea.interviews.command;

/**
 * The invocation context for a given simulation.
 * <p>
 * This could be a set of commands captured from the command line or command
 * that have been read in from a file. It is assumed that the commands will be
 * in the following format:
 * <p>
 * <code>
 * COMMAND X_COORD,Y_COORD,FACE
 * COMMAND
 * </code>
 *
 * @see Command
 * @see CommandFactory
 * @see InvocationContext
 *
 * @author Night King
 *
 */
public class InvocationContext {

	private String x;
	private String y;
	private String z;
	private String args = "";
	private String face = "";

	public InvocationContext(String invocationContext) {
		this.setArgs(this.getCommandArguments(invocationContext));
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

	public InvocationContext setZ(int z) {
		this.z = String.valueOf(z);
		return this;
	}

	public String getZ() {
		return this.z;
	}

	String getCommandArguments(String invocationContext) {
		String[] context = invocationContext.split(" ");
		if (context.length > 1) {
			String[] args = context[1].split(",");
			this.setX(args[0]);
			if (args.length > 1) {
				this.setY(args[1]);
			}
			if (args.length > 2) {
				this.setThirdArg(args[2]);
			}
			return context[1].toString();
		}
		return "";
	}

	private InvocationContext setThirdArg(String arg) {
		InvocationContext context = null;
		try {
			context = this.setZ(Integer.parseInt(arg));
		} catch (Exception ex) {
			context = this.setFace(arg);
		}
		return context;
	}
}
