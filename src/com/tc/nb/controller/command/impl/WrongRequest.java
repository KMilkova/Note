package com.tc.nb.controller.command.impl;

import com.tc.nb.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		String respond = "Wrong command";
		return respond;
	}

}
