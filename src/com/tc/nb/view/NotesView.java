package com.tc.nb.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tc.nb.dal.DAOProvider;
import com.tc.nb.entity.Note;

public class NotesView {

	public void printNotes(List<Note> notes) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		for (Note n : notes) {
			System.out.println(n.getContext() + " " + format.format(n.getDate()));
		}
	}
	
	public void printNotes(String response) {
		if(response == null) {
			System.out.println("Fail");
		}else {
			System.out.println(response);
			System.out.println();
		}
	}

}
