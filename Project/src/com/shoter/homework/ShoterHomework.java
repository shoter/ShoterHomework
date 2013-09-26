package com.shoter.homework;


import com.shoter.data.Subjects;

import android.app.Application;
import android.util.Log;

public class ShoterHomework extends Application
{
	
	
	@Override
	public void onCreate() 
	{
		instance = this;
		
		Subjects.init();
		for(String subject : Subjects.subjects)
			Log.d("APP", subject);
		
	}
	
	private static ShoterHomework instance;
	
	public static ShoterHomework get()
	{
		return instance;
	}
}
