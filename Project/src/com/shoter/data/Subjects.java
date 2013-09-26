package com.shoter.data;

import com.shoter.homework.R;
import com.shoter.homework.ShoterHomework;

public class Subjects
{
	public static String[] subjects;
	
	public static void init()
	{
		subjects = ShoterHomework.get().getResources().getStringArray(R.array.Subjects);
	}

}
