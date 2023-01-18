package com.tc.nb.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.NotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.exception.ServiceException;

public class NotesFindServiceImpl implements NotesFindService {

	@Override
	public List<Note> findByContent(String content) {
		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList = notesDAO.load();
		List<Note> notes = new ArrayList<Note>();

		for (Note n : sourceList) {
			if (n.getContext().contains(content)) {
				notes.add(n);
			}
		}

		return notes;
	}

	@Override
	public List<Note> findByDate(Date date) {
		DAOProvider provider = DAOProvider.getInstance();

		NotesDAO notesDAO = provider.getNotesDAO();

		List<Note> sourceList = notesDAO.load();
		List<Note> notee = new ArrayList<Note>();

		for (Note n : sourceList) {
			if (n.getDate().equals(date)) {
				notee.add(n);
			}
		}

		return notee;
	}

}
