package com.shoter.data;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class EmptySave implements SchoolWorkSaver
{

	@Override
	public void save(List<SchoolWork> list) {
		
	}

	@Override
	public void load(List<SchoolWork> list) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2013);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.DATE, 30);
		
		SchoolWork nowy = new SchoolWork(0, false,Date.valueOf(cal.get(Calendar.YEAR)+ ":" + cal.get(Calendar.MONTH)+":" + cal.get(Calendar.DATE)), "Angielski", "Zadanko", "Damianek <3"  );
		list.add(nowy);
	}
	
}
