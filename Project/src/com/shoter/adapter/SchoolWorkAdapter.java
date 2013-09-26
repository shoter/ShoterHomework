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
		int layoutID;
		
		public SchoolWorkAdapter( Context context, int layoutID, List<SchoolWork> data)
		{
			super(context, layoutID , data);
			this.layoutID = layoutID;
			this.context = context;
			this.data = data;
		}
		
		
		@Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        RowWidgets rowWidgets = new RowWidgets();
	        SchoolWork work = data.get(position);
	        
	        
	        if(row == null)
	        {
	            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	            row = inflater.inflate(layoutID, parent, false);
	            
	            rowWidgets.icon = (ImageView) row.findViewById( R.id.iconView );
	            rowWidgets.subject = (TextView) row.findViewById( R.id.tv_subject );
	            rowWidgets.author = (TextView) row.findViewById( R.id.tv_author );
	            rowWidgets.date = (TextView) row.findViewById( R.id.tv_date );
	            rowWidgets.description = (TextView) row.findViewById( R.id.tv_description );
	          
	            row.setTag(rowWidgets);
	        }
	        else
	        {
	        	rowWidgets = (RowWidgets) row.getTag();
	        }     
	        
	        rowWidgets.subject.setText(work.getSubject());
	        rowWidgets.author.setText( work.getAuthor());
	        rowWidgets.date.setText( work.getDate());
	        rowWidgets.description.setText( work.getDescription());
	    
	        
	        return row;
	    }
		
		class RowWidgets
		{
			public ImageView icon;
			public TextView subject, author, date, description;
		}


}
