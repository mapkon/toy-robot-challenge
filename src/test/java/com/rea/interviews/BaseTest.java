package com.rea.interviews;

import com.rea.interviews.command.InvocationContext;

public abstract class BaseTest {

	protected final String PLACE_INVOCATION = "PLACE 0,0,NORTH";
	protected final String PLACE_CONTEXT_SOUTH = "PLACE 1,1,SOUTH";
	protected final InvocationContext context = new InvocationContext(PLACE_INVOCATION);
	protected final InvocationContext southContext = new InvocationContext(PLACE_CONTEXT_SOUTH);

}
