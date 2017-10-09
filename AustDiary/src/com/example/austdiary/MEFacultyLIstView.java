package com.example.austdiary;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MEFacultyLIstView extends Activity{
	
	ListView lvFacultyList;
	facultyListAdapter adapter;
	final Context context = MEFacultyLIstView.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faculty_list_view);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		lvFacultyList = (ListView) findViewById(R.id.facultyListView);
		final ArrayList<facultyArrayElement> myArrrayList = generateData();
		adapter = new facultyListAdapter(getApplicationContext(), R.layout.item_view, generateData());
		lvFacultyList.setAdapter(adapter);
		lvFacultyList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, final int position,
					long arg3) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);
				
				//tell the Dialog to use the dialog.xml as it's layout description
				dialog.setContentView(R.layout.popup_dialog);
				dialog.setTitle("Details:");
				Button btMakeCall = (Button) dialog.findViewById(R.id.btnDialogPhone);
				Button btSendSms = (Button) dialog.findViewById(R.id.btnDialogSms);
				Button btSendMail = (Button) dialog.findViewById(R.id.btnDialogMail);
				
				//image 
				ImageView imgIcon = (ImageView) dialog.findViewById(R.id.facultyImage);
				imgIcon.setImageResource(myArrrayList.get(position).getIcon());
				
				//Name
				TextView title = (TextView)dialog.findViewById(R.id.facultyName);
				title.setText(myArrrayList.get(position).getTitle());
				
				//Designation
				TextView designation = (TextView)dialog.findViewById(R.id.designationLabel);
				designation.setText(myArrrayList.get(position).getDesignation());
				
				//Degrees
				TextView degrees = (TextView)dialog.findViewById(R.id.facultyDegrees);
				degrees.setText(myArrrayList.get(position).getDegrees());
				
				//Bio
				TextView bio = (TextView)dialog.findViewById(R.id.facultyBio);
				bio.setText(myArrrayList.get(position).getBio());
				
				
				
				btSendSms.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						try {
				            Uri uri = Uri.parse("smsto:"+myArrrayList.get(position).getMobailNumber());
				            // No permisison needed
				            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
				            // Set the message to be sent
				            startActivity(smsIntent);
				        } catch (Exception e) {
				            
				            e.printStackTrace();
				        }
					}
				});
				btMakeCall.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
					      phoneIntent.setData(Uri.parse("tel:"+myArrrayList.get(position).getMobailNumber()));

					      try {
					         startActivity(phoneIntent);
					         finish();
					         Log.i("Finished making a call...", "");
					      } catch (android.content.ActivityNotFoundException ex) {
					         Toast.makeText(MEFacultyLIstView.this, 
					         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
					      }
					      dialog.dismiss();
					
					}
				});
				btSendMail.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
					    Intent email = new Intent(Intent.ACTION_SEND);  
					    email.putExtra(Intent.EXTRA_EMAIL, new String[]{myArrrayList.get(position).getEmail()});
					    //need this to prompts email client only  
					    email.setType("message/rfc822");  
					      
					    startActivity(Intent.createChooser(email, "Choose an Email client :"));  
					}
				});

				dialog.show();
			}
		});
	}
	
	private ArrayList<facultyArrayElement> generateData(){
        ArrayList<facultyArrayElement> models = new ArrayList<facultyArrayElement>();
   
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Prof A. F. M. Anwarul Haque", "Head & Dean", "B. Sc (BUET), M. Sc (BUET), M. Engg (USA), PhD (USA).", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Prof. Dr. M. H. Khan", "Professor", "Founder Vice-Chancellor, AUST.", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Prof. Shyamal Kanti Biswas", "Professor", "B.Sc Eng. (Mechanical), BUET, Master of Eng. (Production), "
        		+ "Kyushu Univ., Japan, Doctor of Eng. (Production), Kyushu Univ., Japan.", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Dr. Dewan Hasan Ahmed", "Associate Professor", "B.Sc (BUET), PhD (Australia).", "Area of Interest: Fluid Mechanics, Heat"
        		+ " Transfer, Renewable Energy, CFD, Automobile.", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Dr. Mohammad Sarwar Morshed", "Associate Professor", "B.Sc (CUET), M. Sc(Belgium) PhD (UK).", "Area of Interest:"
        		+ " Optimization, GA, TS, KB, Scheduling, Public Health.", "??", "??"));

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
	
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
}
