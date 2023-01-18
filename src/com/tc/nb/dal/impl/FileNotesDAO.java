package com.tc.nb.dal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.NotesDAO;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.entity.Note;

public class FileNotesDAO implements NotesDAO {

	private List<Note> notes = new ArrayList<Note>();
	private static final String soursePath = ".\\resourses\\note.txt";

	public FileNotesDAO() throws DAOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(soursePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				int index = line.lastIndexOf(' ');
				if (index >= 0) {
					notes.add(parseLine(line, index));
				}
			}
			reader.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Note> load() {
		return notes;
	}

	@Override
	public void save(Note note) throws DAOException {
		notes.add(note);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(soursePath));
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			for (Note n : notes) {
				writer.write(n.getContext() + " " + format.format(n.getDate()) + "\n");
			}
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
	}

	public Note parseLine(String line, int index) throws DAOException {
		String context = line.substring(0, index);
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		String strForDate = line.substring(index);
		Date date = new Date();
		try {
			date = format.parse(strForDate);
		} catch (ParseException e) {
			throw new DAOException(e);
		}
		return (new Note(context, date));
	}

}
