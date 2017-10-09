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

public class CSEFacultyListView extends Activity{
	
	ListView lvFacultyList;
	facultyListAdapter adapter;
	final Context context = CSEFacultyListView.this;
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
					         Toast.makeText(CSEFacultyListView.this, 
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
        models.add(new facultyArrayElement(R.drawable.mamun,"Dr. S. M. Abdullah Al-Mamun","Professor & Head","MS (Comp. Engg.), Ukraine, Ph.D. (Moscow, Russia).",
        		"Wasi Uddin Ahmad  is from Bangladesh, located in South Asia, a small country with eternal beauty and  have "
        		+ "Area Of Intrestes: ","01912-073524","??"));
        
        models.add(new facultyArrayElement(R.drawable.kharul, "Mahammad Kharul","Associate Professor","B.Sc. Engg. (CSE), AUST, M.Sc.(CSE), UIU.",
        		"Area of Interest: Computional Inteligence, Neural Network, Optimization, Combinatorial Optimization,Swarm inteligence","01711-109629"," ??"));
        
        models.add(new facultyArrayElement(R.drawable.shafiqul, "Dr. Mohammad Shafiul Alam","Associate Professor","B.Sc. Engg. (CSE), M.Sc. (CSE) & Ph.D., BUET.",
        		"Area of Interest: Heuristic Algorithms, Swarm inteligence, Continous Optimization","01937-653901"," ??"));
 
        
        models.add(new facultyArrayElement(R.drawable.zakia, "Ms. Umme Zakia","Assistant Professor", "B.Sc. (ECS), JU, M.Sc. (CSE), NSU.",  "Area of Interest: Computer Network, "
        		+ "4G Cellular & Wireless Communications, VLSI, AI for Disaster Managment  System, Web computing", "01722-066975", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Mr. Faisal Muhammad Shah", "Assistant Professor", "B.Sc. Engg. (CSE), AUST, M.Sc.(CSE), UIU, Ph.D.(Ongoing), JU.", "", "01911-090363", "??"));
        
        models.add(new facultyArrayElement(R.drawable.lisa,"Ms. Nusrat Jahan Lisa", "Assistant Professor", "B.Sc. Engg. (CSE), AUST, M.Sc.(CSE), UIU, M.Phil.(Ongoing), DU.", "", "01674-928298", "??"));
        
        models.add(new facultyArrayElement(R.drawable.eity, "Ms. Qamrun Nahar Eity", "Assistant Professor", "B.Sc. Engg.(CSE), AUST, M.Sc.(CSE), UIU.", "", "01727-732788", "??"));
        
        models.add(new facultyArrayElement(R.drawable.tanvir, "Mr. Tanvir Ahmed", "Assistant Professor", "B.Sc. Engg. (CSE), AUST, M.Sc. (CSE), England, Ph.D.(Ongoing), BUET.", "", "01670-014863", "??"));
        
        models.add(new facultyArrayElement(R.drawable.kabir, "Mr. Md. Wasi Ul Kabir", "Assistant Professor", "B.Sc. Engg. (CSE), AUST, M.Sc.(CSE,Ongoing), BUET.", "", "01670-014863", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Mr. S. M. Ferdous", "Assistant Professor", "B.Sc. Engg.(CSE) & M.Sc. (CSE), BUET.", "", "01914-042907", "??"));
        
        models.add(new facultyArrayElement(R.drawable.shabnam, "Ms. Syeda Shabnam Hasan", "Lecturer", "B.Sc. Engg. (CSE), AUST.", "", "01914-130189", "??"));
        
        models.add(new facultyArrayElement(R.drawable.emam, "Mr. Emam Hossain", "Lecturer", "B.Sc. Engg.(CIT), IUT.", "", "01717-584978", "??"));
        
        
        models.add(new facultyArrayElement(R.drawable.unknownuser, "Ms. Shanjida Khatun", "Lecturer", "B.Sc. Engg.(CSE), AUST.", "Area of Interest: Artificial Intelegence ,Data Mining, Genetic Algorithm", "01919-835477", "??"));
      
        models.add(new facultyArrayElement(R.drawable.nayem,"Mr. Mir Tafseer Nayeem", "Lecturer", "B.Sc. Engg.(CIT), IUT.", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser,"Mr. Md. Hosne-Al-Walid Shaiket", "Lecturer", "B.Sc. Engg.(CIT), IUT , M.Sc..(IICT,Ongoing), BUET.", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser,"Mr. Nazmus Sakib", "Lecturer", "B.Sc. Engg.(CIT), IUT.", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser,"Mr. D. M. Anisuzzaman", "Lecturer", "B.Sc. Engg.(CSE), AUST", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.belalbhai,"Mr. Tanveer Ahmed Belal", "Lecturer", "B.Sc. Engg.(CSE), AUST", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.arif,"Mr. M. Arif Imtiazur Rahman", "Lecturer", "B.Sc. Engg.(CSE), BUET", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.unknownuser,"Mr. Saikat Chakraborty", "Lecturer", "B.Sc , CSE, DU, M.Sc, CSE, DU (ongoing).", "", "??", "??"));
        
        models.add(new facultyArrayElement(R.drawable.ridi,"Ms. Ridi Hossain", "Lecturer", "B.Sc. Engg.(CSE), AUST", "", "??", "??"));
        
        
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
