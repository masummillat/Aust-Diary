package com.example.austdiary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CseDepartment extends Activity{

	Button btnFaculty,btnRoutine,btnResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.department);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		btnFaculty =(Button)findViewById(R.id.btnFaculty);
		btnRoutine =(Button)findViewById(R.id.btnRoutine);
		btnResult = (Button)findViewById(R.id.btnResult);
		btnFaculty.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),CSEFacultyListView.class);
				startActivity(intent);
			}
		});
		
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Routine::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
				btnRoutine.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getApplicationContext(),Routine.class);
						intent.putExtra("pdf", "http://www.aust.edu/cse/class_routine_cse.pdf");
						startActivity(intent);
					}
				});
				
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Result::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				btnResult.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getApplicationContext(),ResultSpinner.class);
						intent.putExtra("dept","cse");
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
