package com.shoter.dialogs;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.shoter.data.Subjects;
import com.shoter.homework.R;

public class SchoolWorkDialog implements OnClickListener
{
	Context context;
	Dialog dialog;
	
	TextView tv_author, tv_description;
	CheckBox cb_istest;
	Spinner spin_subject;
	DatePicker dp_date;
	
	
	public SchoolWorkDialog(Context context)
	{
		this.context = context;
		dialog = new Dialog(context);
		dialog.setContentView(R.layout.d_homework);
		dialog.setTitle("Testowy");
		((Button)dialog.findViewById(R.id.bttn_submit)).setOnClickListener(this);
		
		tv_author = (TextView) dialog.findViewById(R.id.tv_author);
		tv_description = (TextView) dialog.findViewById(R.id.tv_description);
		cb_istest = (CheckBox) dialog.findViewById(R.id.cb_istest);
		spin_subject = (Spinner) dialog.findViewById(R.id.spin_subject);
		dp_date = (DatePicker) dialog.findViewById(R.id.dp_date);
		
			    Method m;
				try {
					m = dp_date.getClass().getMethod("setCalendarViewShown", boolean.class);
					m.invoke(dp_date, false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		List<String> spinnerArray = new ArrayList<String>();
		
		for(String string : Subjects.subjects)
			spinnerArray.add(string);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, spinnerArray );
		spin_subject.setAdapter(adapter);
	}
	
	public void show()
	{
		dialog.show();
	}
	
	public void cancel()
	{
		dialog.cancel();
	}
	
	@Override
	public void onClick(View v) {
		String subject = "";
		if(spin_subject.getSelectedItem() != null)
			subject = spin_subject.getSelectedItem().toString();
		String description = tv_description.getText().toString();
		String author = tv_author.getText().toString();
		Date date = getDate();
		boolean isTest = cb_istest.isChecked();
		
		if(onSubmit(subject, description, author, date, isTest))
		{
			dialog.cancel();
		}
	}
	
	public Date getDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, dp_date.getYear());
		calendar.set(Calendar.MONTH, dp_date.getMonth());
		calendar.set(Calendar.DATE, dp_date.getDayOfMonth());
		
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * 
	 * @param subject
	 * @param description
	 * @param author
	 * @param date
	 * @param isTest
	 * @return true if message is correct, otherwise false. True will close the dialog
	 */
	public boolean onSubmit(String subject, String description, String  author, Date date, boolean isTest)
	{
		
		return true;
	}

	
	
}
