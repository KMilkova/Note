package com.tc.nb.service;

import com.tc.nb.service.impl.DataCheckingServiceImpl;
import com.tc.nb.service.impl.NotesCreateServiceImpl;
import com.tc.nb.service.impl.NotesFindServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private final NotesCreateService notesCreateService = new NotesCreateServiceImpl();
	private final NotesFindService notesFindService = new NotesFindServiceImpl();
	private final DataCheckingService dataCheckingService = new DataCheckingServiceImpl();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public NotesCreateService getNotesCreateService() {
		return notesCreateService;
	}

	public NotesFindService getNotesFindService() {
		return notesFindService;
	}

	public DataCheckingService getDataCheckingService() {
		return dataCheckingService;
	}
}
