package com.shoter.data;

import java.sql.Date;

import android.util.Log;

public class SchoolWork
{
	protected int ID;
	protected boolean isTest;
	protected Date date;
	protected String subject;
	protected String description;
	protected String author;
	
	public SchoolWork(int ID, boolean isTest, Date date, String subject, String description, String author)
	{
		this.ID = ID;
		this.isTest = isTest;
		this.date = date;
		this.subject = subject;
		this.description = description; 
		this.author = author;
	}
	
	public void log()
	{
		Log.d("SchoolWork", isTest + " id - " + ID + " " + date + " subject : " + subject + " desc : " + description);
	}
}
