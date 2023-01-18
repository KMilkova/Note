package com.tc.nb.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.tc.nb.entity.Note;
import com.tc.nb.service.exception.ServiceException;

public interface NotesFindService {
	List<Note> findByContent(String content);

	List<Note> findByDate(Date date) throws ServiceException;
}
