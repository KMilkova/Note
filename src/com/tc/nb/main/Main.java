package com.tc.nb.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tc.nb.controller.Controller;
import com.tc.nb.dal.DAOProvider;
import com.tc.nb.dal.exception.DAOException;
import com.tc.nb.dal.impl.FileNotesDAO;
import com.tc.nb.entity.Note;
import com.tc.nb.service.NotesFindService;
import com.tc.nb.service.impl.NotesCreateServiceImpl;
import com.tc.nb.service.impl.NotesFindServiceImpl;
import com.tc.nb.view.NotesView;

public class Main {

	public static void main(String[] args) throws Exception {

		Controller controller = new Controller();
		NotesView notesView = new NotesView();
		
		int x;
		System.out.println("");
		boolean cheak = true;
		while (cheak) {
			Scanner in = new Scanner(System.in);
			System.out.print("1 - Add добавить запись в блокнот\n" 
			+ "2 - Find context найти запись по содержимому\n"
			+ "3 - Find date найти запись по дате создания\n" 
			+ "4 - Show notes показать записи\n");
			x = in.nextInt();
			switch (x) {
			case 1:
				notesView.printNotes(controller.executeTask("ADD "));
				break;
			case 2:
				notesView.printNotes(controller.executeTask("FIND_BY_CONTENT aaaa fff"));
				break;
			case 3:
				String resp = controller.executeTask("FIND_BY_DATE 12.01.2023");
				notesView.printNotes(resp);
				break;
			case 4:
				notesView.printNotes(controller.executeTask("VIEW_ALL "));
				break;
			default:
				notesView.printNotes(controller.executeTask("WRONG_REQUEST "));
				break;
			}
		}
		System.out.println("end");

	}

}
