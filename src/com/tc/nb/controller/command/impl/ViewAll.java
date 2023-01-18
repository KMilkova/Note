package com.tc.nb.controller.command.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.controller.command.Command;
import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;

public class ViewAll implements Command {

	@Override
	public String execute(String request) {
		String response = "";

		DAOProvider provider = DAOProvider.getInstance();
		NotesDAO notesDAO = provider.getNotesDAO();
		List<Note> notes = new ArrayList<Note>();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		notes = notesDAO.load();
		if (!notes.isEmpty()) {
			for (Note n : notes) {
				response += n.getContext() + " " + format.format(n.getDate())+"\n";
			}				
		} else {
			response = "Fail";
		}
		return response;
	}

}
