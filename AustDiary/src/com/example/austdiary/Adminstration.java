package com.example.austdiary;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Adminstration extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faculty_list_view);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		final ListView adminstrationList = (ListView)findViewById(R.id.facultyListView); //we useing faculty listview here as a listview
		
		//String[] items = {"Board of Trustees","Syndicate","Academic Council","Finance Committee","University Administration"};
		final ArrayList<AdminstrationBoardArrayElement> myList = generateData();
		ArrayAdapter<AdminstrationBoardArrayElement> adapter = new ArrayAdapter<AdminstrationBoardArrayElement>(this, android.R.layout.simple_list_item_1,generateData());
		
		//calling adminstrationBoardListAdapter 
		adapter = new AdminstrationBoardListAdapter(getApplicationContext(), R.layout.adminstration_item_view, myList);
		
		
		adminstrationList.setAdapter(adapter);
		
		adminstrationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), ""+adminstrationList.getPositionForView(v), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent("com.example.austdiary.AdminstrationMemberlist");
				intent.putExtra("key", ""+position);
				startActivity(intent);
				
				
			}
		});
		
	
	}
	
	private ArrayList<AdminstrationBoardArrayElement> generateData(){
        ArrayList<AdminstrationBoardArrayElement> models = new ArrayList<AdminstrationBoardArrayElement>();
        	models.add(new AdminstrationBoardArrayElement("Board Of Trustees"));
        	models.add(new AdminstrationBoardArrayElement("Syndicate"));
        	models.add(new AdminstrationBoardArrayElement("Academic Council"));
        	models.add(new AdminstrationBoardArrayElement("Finance Committee"));
        	models.add(new AdminstrationBoardArrayElement("University Administration"));
        	
        return models;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case android.R.id.home:
            // app icon in action bar clicked; goto parent activity.
            this.finish();
            return true;
        default:
            return super.onOptionsItemSelected(item);
		}
		
	}
}
	


