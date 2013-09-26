package com.shoter.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shoter.data.SchoolWork;
import com.shoter.homework.R;

public class SchoolWorkAdapter extends ArrayAdapter<SchoolWork>
{
		Context context;
		List<SchoolWork> data = null;
		
		public SchoolWorkAdapter( Context context, int layoutID, List<SchoolWork> data)
		{
			super(context, layoutID , data);
			this.context = context;
			this.data = data;
		}
		
		
		@Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        RowWidgets rowWidgets = new RowWidgets();
	        
	        if(row == null)
	        {
	            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	            
	            rowWidgets.textView = (TextView) row.findViewById( R.id.title );
	            rowWidgets.imageView = (ImageView) row.findViewById(R.id.bookImage);
	            row.setTag(rowWidgets);
	        }
	        else
	        {
	        	rowWidgets = (RowWidgets) row.getTag();
	        }     
	        RawBook book = data.get(position);
	        
	        rowWidgets.textView.setText(book.getTitle());
	        rowWidgets.imageView.setImageBitmap(book.getBookImage());
	        
	        rowWidgets.textView.setTag(book.getID());
	        rowWidgets.imageView.setTag(book.getID());*/
	        
	       // rowWidgets.imageView.setOnClickListener(this);
	       // rowWidgets.textView.setOnClickListener(this);
	        
	        return row;
	    }
		
		class RowWidgets
		{
			public ImageView icon;
			public String date;
			public String subject;
			public String author;
		}


}
