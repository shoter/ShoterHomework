package com.shoter.data;

import java.util.List;


public abstract interface SchoolWorkSaver
{
	public abstract void save(List<SchoolWork> list);
	public abstract void load(List<SchoolWork> list);
}
