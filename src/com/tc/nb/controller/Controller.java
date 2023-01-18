package com.tc.nb.controller;

import com.tc.nb.controller.command.Command;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimiter = ' ';

	public String executeTask(String request){
		String response;
		String commandName;
		Command executeCommand;

		commandName = request.substring(0, request.indexOf(paramDelimiter));
		executeCommand = provider.getCommand(commandName);

		response = executeCommand.execute(request);
		return response;
	}
}
