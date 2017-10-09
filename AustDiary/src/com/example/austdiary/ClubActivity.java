package com.example.austdiary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

public class ClubActivity extends Activity{
	ImageButton imgphotoButton,imgDebtButton,imgRoboticsButton;
	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clubs);
		
		
		
		imgphotoButton = (ImageButton)findViewById(R.id.btnPhoto);
		imgDebtButton = (ImageButton)findViewById(R.id.btnDebate);
		imgRoboticsButton = (ImageButton)findViewById(R.id.btnRobotics);
		
		imgphotoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ClubDetails.class);
				intent.putExtra("key", "photo");
				startActivity(intent);
				
			}
		});
		
		
		imgRoboticsButton.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getApplicationContext(),ClubDetails.class);
					intent.putExtra("key", "EEE Project Society");
					startActivity(intent);
					
				}
			});


		imgDebtButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ClubDetails.class);
				intent.putExtra("key", "Debate");
				startActivity(intent);
				
			}
		});
		
	}
	
	//onBackPressed Activity finish alertDialog
	@Override
	public void onBackPressed() {
		Log.i("Taggggggggggggggg", "faljflajfl");
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                ClubActivity.this);
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
	
	

	
	
}
