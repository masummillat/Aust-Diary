package com.example.austdiary;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.austdiary.facultyListAdapter.ViewHolder;

public class AdminstrationListAdapter extends ArrayAdapter<AdminstrationArrayElement> {
	ArrayList<AdminstrationArrayElement> facultyInfo;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	public AdminstrationListAdapter(Context context, int resource, ArrayList<AdminstrationArrayElement> objects) {
		super(context, resource, objects);
		vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		facultyInfo = objects;
		Log.d("bug", "after subject Info");
	}
	@Override
	public View getView( final int position, View convertView, ViewGroup parent) {
		// convert view = design
		View v = convertView;
		if (v == null) {
			holder = new ViewHolder();
			v = vi.inflate(Resource, null);
			Log.d("bug", "before textview itnt");
			holder.AdminJob = (TextView) v.findViewById(R.id.tvAdminJobPostion);
			holder.AdminDesignation= (TextView) v.findViewById(R.id.tvAdminDesignation);
			holder.AdminName = (TextView) v.findViewById(R.id.tvAdminName);
			Log.d("bug", "after textview init");
			
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}
		Log.d("bug", "after textview init");
		holder.AdminName.setText(facultyInfo.get(position).getName());
		holder.AdminDesignation.setText(facultyInfo.get(position).getDesignation());
		holder.AdminJob.setText(facultyInfo.get(position).getJobPosition());
		
		return v;

	}
	static class ViewHolder {
		public TextView AdminDesignation;
		public TextView AdminName;
		public TextView AdminJob;
	}

}
