package com.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import com.tc.nb.controller.command.Command;
import com.tc.nb.controller.command.impl.Adding;
import com.tc.nb.controller.command.impl.FindByContent;
import com.tc.nb.controller.command.impl.FindByDate;
import com.tc.nb.controller.command.impl.ViewAll;
import com.tc.nb.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(CommandName.ADD, new Adding());
		repository.put(CommandName.FIND_BY_CONTENT, new FindByContent());
		repository.put(CommandName.FIND_BY_DATE, new FindByDate());
		repository.put(CommandName.VIEW_ALL, new ViewAll());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(commandName.WRONG_REQUEST);
		}
		return command;
	}
}
