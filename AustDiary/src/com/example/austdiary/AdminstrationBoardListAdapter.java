package com.example.austdiary;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.austdiary.AdminstrationListAdapter.ViewHolder;

public class AdminstrationBoardListAdapter extends ArrayAdapter<AdminstrationBoardArrayElement> {
	ArrayList<AdminstrationBoardArrayElement> facultyInfo;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	public AdminstrationBoardListAdapter(Context context, int resource, ArrayList<AdminstrationBoardArrayElement> objects) {
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
			
			holder.BoardName = (TextView) v.findViewById(R.id.tvAdminstration);
			Log.d("bug", "after textview init");
			
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}
		Log.d("bug", "after textview init");
		holder.BoardName.setText(facultyInfo.get(position).getBoardName());

		
		return v;

	}
	static class ViewHolder {
		
		public TextView BoardName;
		
	}}
