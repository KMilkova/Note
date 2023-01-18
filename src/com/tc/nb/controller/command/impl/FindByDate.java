package com.tc.nb.controller.command.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tc.nb.controller.command.Command;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.ServiceProvider;
import com.tc.nb.service.exception.ServiceException;

public class FindByDate implements Command {

	@Override
	public String execute(String request) {
		String respond = "";
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NotesFindService notesFindService = serviceProvider.getNotesFindService();
		String note = request.substring(request.indexOf(' ') + 1);
		Date date = new Date();
		List<Note> notes = new ArrayList<Note>();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = format.parse(note);
			notes = notesFindService.findByDate(date);
			if (!notes.isEmpty()) {
				for (Note n : notes) {
					respond += n.getContext() + " " + format.format(n.getDate())+"\n";
				}
			} else {
				respond = null;
			}
		} catch (ServiceException | ParseException e) {
			respond = e.getMessage();
		}
		return respond;
	}

}
