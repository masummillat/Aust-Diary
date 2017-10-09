package com.example.austdiary;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Architecture extends Activity{
	TextView archiHomeText1,archiHomeText2,archiHomeText3;
	
	Button btnFaculty, btnRoutine,btnResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.department);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
	
		btnFaculty =(Button)findViewById(R.id.btnFaculty);
		btnRoutine = (Button) findViewById(R.id.btnRoutine);
		btnResult = (Button)findViewById(R.id.btnResult);
		btnFaculty.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ArchiFacultyListView.class);
				startActivity(intent);
			}
		});
		btnRoutine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),Routine.class);
				intent.putExtra("pdf", "http://www.aust.edu/barch/class_routine_arc.pdf");
				startActivity(intent);
			}
		});
		
		btnResult.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ResultSpinner.class);
				intent.putExtra("dept", "arc");
				startActivity(intent);
			}
		});
		
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
