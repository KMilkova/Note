package com.tc.nb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Note {
	private String context;
	private Date date;

	public Note() {
		super();
	}

	public Note(String context, Date date) {
		this.context = context;
		this.date = date;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(context, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(context, other.context) && Objects.equals(date, other.date);
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return "Note [context=" + context + ", date=" + format.format(date) + "]";
	}

}
