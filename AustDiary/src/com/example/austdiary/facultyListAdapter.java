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
public class facultyListAdapter extends ArrayAdapter<facultyArrayElement> {
	ArrayList<facultyArrayElement> facultyInfo;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	public facultyListAdapter(Context context, int resource, ArrayList<facultyArrayElement> objects) {
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
			holder.facultyImage = (ImageView) v.findViewById(R.id.image_icon);
			holder.facultyName = (TextView) v.findViewById(R.id.txtDept);
			Log.d("bug", "after textview init");
			
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}
		Log.d("bug", "after textview init");
		holder.facultyName.setText(facultyInfo.get(position).getTitle());
		holder.facultyImage.setImageResource(facultyInfo.get(position).getIcon());
		
		return v;

	}
	static class ViewHolder {
		public ImageView facultyImage;
		public TextView facultyName;
	}
}