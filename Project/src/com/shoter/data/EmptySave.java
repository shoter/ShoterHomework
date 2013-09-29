package com.shoter.data;

import java.util.List;

public class EmptySave implements SchoolWorkSaver
{

	@Override
	public void save(List<SchoolWork> list) {
		
	}

	@Override
	public void load(List<SchoolWork> list) {
	}
	
}
