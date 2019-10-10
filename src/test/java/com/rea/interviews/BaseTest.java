package com.rea.interviews;

import com.rea.interviews.command.InvocationContext;
import com.rea.interviews.surface.Surface;
import com.rea.interviews.surface.impl.SquareSurface;

public abstract class BaseTest {

	protected Surface surface = new SquareSurface();
	protected final String PLACE_INVOCATION = "PLACE 0,0,NORTH";
	protected final String PLACE_CONTEXT_EAST = "PLACE 1,2,EAST";
	protected final String PLACE_CONTEXT_WEST = "PLACE 2,1,WEST";
	protected final String PLACE_CONTEXT_SOUTH = "PLACE 1,1,SOUTH";
	protected final InvocationContext context = new InvocationContext(PLACE_INVOCATION);
	protected final InvocationContext eastContext = new InvocationContext(PLACE_CONTEXT_EAST);
	protected final InvocationContext westContext = new InvocationContext(PLACE_CONTEXT_WEST);
	protected final InvocationContext southContext = new InvocationContext(PLACE_CONTEXT_SOUTH);

}
