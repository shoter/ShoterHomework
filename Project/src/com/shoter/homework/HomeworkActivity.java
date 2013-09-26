package com.shoter.homework;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.shoter.adapter.SchoolWorkAdapter;
import com.shoter.data.EmptySave;
import com.shoter.data.SchoolWork;
import com.shoter.data.SchoolWorkSaver;

public class HomeworkActivity extends Activity
{
	ArrayList<SchoolWork> schoolWorks = new ArrayList<SchoolWork>();
	SchoolWorkSaver saver = new EmptySave();
	
	ListView lv;
	SchoolWorkAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l_homework);
		saver.load(schoolWorks);
		
		lv = (ListView) findViewById(R.id.lv_homework);
		
		adapter = new SchoolWorkAdapter(this, R.layout.e_schoolwork, schoolWorks);
		lv.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homework, menu);
		return true;
	}

}
