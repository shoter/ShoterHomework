package com.shoter.data;

import java.sql.Date;

import android.util.Log;

public class SchoolWork
{
	protected boolean isTest;
	protected Date date;
	protected String subject;
	protected String description;
	protected String author;
	
	public SchoolWork( boolean isTest, Date date, String subject, String description, String author)
	{
		this.isTest = isTest;
		this.date = date;
		this.subject = subject;
		this.description = description; 
		this.author = author;
	}
	
	public void log()
	{
		Log.d("SchoolWork", isTest + " id - " + " " + date + " subject : " + subject + " desc : " + description);
	}
	
	public String getDate()
	{
		return date.toString();
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getAuthor()
	{
		return author;
	}
}
