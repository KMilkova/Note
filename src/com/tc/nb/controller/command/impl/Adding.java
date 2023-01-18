package com.tc.nb.controller.command.impl;

import java.util.Date;

import com.tc.nb.controller.command.Command;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesCreateService;
import com.tc.nb.service.ServiceProvider;
import com.tc.nb.service.exception.ServiceException;

public class Adding implements Command {

	@Override
	public String execute(String request) {
		String response = null;
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NotesCreateService notesCreateService = serviceProvider.getNotesCreateService();
		String noteForAdd = request.substring(request.indexOf(' ') + 1);
		Note note = new Note(noteForAdd, new Date());
		try {
			notesCreateService.add(note);
			response = "Addition was successful";
		} catch (ServiceException e) {
			response = e.getMessage();
		}
		return response;
	}

}
