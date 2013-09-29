package com.shoter.homework;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.shoter.adapter.SchoolWorkAdapter;
import com.shoter.data.EmptySave;
import com.shoter.data.SchoolWork;
import com.shoter.data.SchoolWorkSaver;
import com.shoter.dialogs.SchoolWorkDialog;

public class HomeworkActivity extends Activity
{
	ArrayList<SchoolWork> schoolWorks = new ArrayList<SchoolWork>();
	SchoolWorkSaver saver = new EmptySave();
	SchoolWorkDialog dialog;
	
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
		
		dialog  = new SchoolWorkDialog(this)
		{
			public boolean onSubmit(String subject, String description, String author, java.sql.Date date, boolean isTest) 
			{
				return HomeworkActivity.this.onSubmit(subject, description, author, date, isTest);
			};
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homework, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
		switch(item.getItemId())
		{
		case R.id.action_add :
			dialog.show();
			break;
		}
		return true;
    }
	
	public boolean onSubmit(String subject, String description, String author, java.sql.Date date, boolean isTest) 
	{
		if(description.isEmpty() || subject.isEmpty() || author.isEmpty())
			return false;
		
		SchoolWork sw = new SchoolWork(isTest, date, subject, description, author);
		schoolWorks.add(sw);
		
		adapter.notifyDataSetChanged();
		
		return true;
	}

}
