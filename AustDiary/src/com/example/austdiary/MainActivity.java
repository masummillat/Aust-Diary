package com.example.austdiary;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends TabActivity {


	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		
		Resources resource = getResources();
		TabHost tabHost = getTabHost();
		tabHost.setBackgroundColor(Color.parseColor("blue"));
		
		
		//About Aust
		Intent intentAboutAust = new Intent().setClass(this,AboutAustActivity.class);
		TabSpec  AboutSpec = tabHost
				.newTabSpec("Aust")
				.setIndicator("Aust",resource.getDrawable(R.drawable.university))
				.setContent(intentAboutAust);
		
		
		//Department Tab
		
		Intent intentDepartment = new Intent().setClass(this, DepartmentActivity.class);
		TabSpec DepartmentSpec = tabHost
				.newTabSpec("Department")
				.setIndicator("Department",resource.getDrawable(R.drawable.department))
				.setContent(intentDepartment);
		
		//Department Tab
		
				Intent intentClub = new Intent().setClass(this, ClubActivity.class);
				TabSpec ClubSpec = tabHost
						.newTabSpec("Club")
						.setIndicator("Club",resource.getDrawable(R.drawable.clubs))
						.setContent(intentClub);
				
				
		//add all tab
				tabHost.addTab(AboutSpec);
				tabHost.addTab(DepartmentSpec);
				tabHost.addTab(ClubSpec);
				
		//set About as Default Tab
				tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
		return true;
	}


	
	// this function is to popup dialog when about is pressed
	public void openDialog(){
		 final Dialog dialog = new Dialog(this); // context, this etc.
		    dialog.setContentView(R.layout.messagedeveloper);
		    dialog.setTitle("Developers");
		    dialog.show();
		
	}
	
	@Override
	public void onBackPressed() {
		Log.i("Taggggggggggggggg", "faljflajfl");
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MainActivity.this);
        // Setting Dialog Title
        alertDialog.setTitle("Leave application?");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to leave the application?");
        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.question);
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				
			}
		});

        // Showing Alert Message
        alertDialog.show();
        return;
    }
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case android.R.id.home:
            // app icon in action bar clicked; goto parent activity.
        	onBackPressed();
            return true;
        case R.id.menu_exit:
        	//exit from the application       
            onBackPressed();
       
            return true;
            		
            
        case R.id.menu_about:
        	//calling openDialog method to show the developers
            openDialog();
            return true;
 
        case R.id.menu_preferences:
            Toast.makeText(MainActivity.this, "Preferences", Toast.LENGTH_SHORT).show();
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
		}
		
	}

	private void CustomActionBar(){
		
	}
	
}
	
	


