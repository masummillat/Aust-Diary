package com.example.austdiary;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AdminstrationMemberlist extends Activity{
	
	ListView lvFacultyList;
	public String position;
	
	final Context context = AdminstrationMemberlist.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faculty_list_view);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		lvFacultyList = (ListView) findViewById(R.id.facultyListView);
		Bundle bundle = getIntent().getExtras();
		position= bundle.getString("key");
		final ArrayList<AdminstrationArrayElement> myArrrayList = generateData();
		ArrayAdapter<AdminstrationArrayElement> adapter = new ArrayAdapter<AdminstrationArrayElement>(this, android.R.layout.simple_list_item_1,generateData());
		adapter = new AdminstrationListAdapter(getApplicationContext(), R.layout.adminstration_member_list_view, myArrrayList);
		lvFacultyList.setAdapter(adapter);
			
		
		
		
	}
	private ArrayList<AdminstrationArrayElement> generateData(){
        ArrayList<AdminstrationArrayElement> models = new ArrayList<AdminstrationArrayElement>();
        if(position.equals("0")){
        	models.add(new AdminstrationArrayElement("Mr. Kazi Rafiqul Alam", "President"+'\n'+"Dhaka Ahsania Mission (DAM)", "Chairman"));
        	models.add(new AdminstrationArrayElement("Prof. Dr. M. H. Khan", "Founder Vice-Chancellor,AUST"+'\n'+"and Ex- Vice-Chancellor, BUET","Member"));
        	models.add(new AdminstrationArrayElement("Barrister Rafique-ul Huq","Ex-Attorney General and Senior Advocate,"+'\n'+"Supreme Court, Bangladesh","Member"));
        	models.add(new AdminstrationArrayElement("Prof.Dr.A.M.M.Safiullah", " Vice-Chancellor,AUST", "Member"));
        	models.add(new AdminstrationArrayElement("Prof. Dr. Abu Tweb Abu Ahmed", "Department of Zoology,DU", "Member"));
        	models.add(new AdminstrationArrayElement("Mr. Zahir Ahmed", "Vice President,DAM", "Member"));
        	models.add(new AdminstrationArrayElement("Mr. Muhammad Abdus Sobhan", "General Secretary, DAM", "Member"));
        	models.add(new AdminstrationArrayElement("Mr. M. Ehsanur Rahman", "Executive Director, DAM", "Member"));
        	models.add(new AdminstrationArrayElement("Mr. Shibbir Mahmud", "Chairman, Swiss Tex Group", "Member"));
        	models.add(new AdminstrationArrayElement("Mr. Mansurul Alam Khan","President & CEOKhan's Tutorial, USA", "Member"));
        	
        	
        }else if(position.equals("1")){
        	models.add(new AdminstrationArrayElement("Prof.Dr.A.M.M.Safiullah", "Vice-Chancellor, AUST", "Chairman"));
        	models.add(new AdminstrationArrayElement("Prof. Dr. Kazi Shariful Alam", "Treasurer, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Kazi Shariful Alam", "Treasurer, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. M. Kaykobad", "Professor, CSE,BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. A. F. M. Anwarul Haque", "Dean, Faculty of Engineering, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. A. Muktadir", "Head, Department of Architecture, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Dipak Kanti Das", "Professor, ME, BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Abu Tweb Abu Ahmed", "Professor, Department of Zoology, DU", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. Ehsanur Rahman", "Executive Director, Dhaka Ahsania Mission", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Mr. Shibbir Mahmud", "Chairman, Swiss Tex Group", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. M. Feroze Ahmed", "Professor, Department of Civil Engineering, BUET", "Member"));
        	
        	
        	
        }else if(position.equals("2")){
        	models.add(new AdminstrationArrayElement("Prof.Dr.A.M.M.Safiullah", "Vice-Chancellor, AUST", "Chairman"));
        	models.add(new AdminstrationArrayElement("Prof.Dr.Md.Amanullah", "Dean, Faculty of Business &"+'\n'+"Social Sciences, AUST", "Member"));

        	models.add(new AdminstrationArrayElement("Prof. Dr. M. Kaykobad", "Professor, CSE,BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. A. F. M. Anwarul Haque", "Dean, Faculty of Engineering, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. A. Muktadir", "Head, Department of Architecture, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Dipak Kanti Das", "Professor, ME, BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Abu Tweb Abu Ahmed", "Professor, Department of Zoology, DU", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. Ehsanur Rahman", "Executive Director, Dhaka Ahsania Mission", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Mr. Shibbir Mahmud", "Chairman, Swiss Tex Group", "Member"));
        	
        }else if(position.equals("3")){
        	models.add(new AdminstrationArrayElement("Dr.Muhammad Abdul Mazid", "Ex-Chairman,NBR &"+'\n'+"Chief Coordinator,BADAS", "Chairman"));
        	
models.add(new AdminstrationArrayElement("Prof. Dr. M. Kaykobad", "Professor, CSE,BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. A. F. M. Anwarul Haque", "Dean, Faculty of Engineering, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. A. Muktadir", "Head, Department of Architecture, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Dipak Kanti Das", "Professor, ME, BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Abu Tweb Abu Ahmed", "Professor, Department of Zoology, DU", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. Ehsanur Rahman", "Executive Director, Dhaka Ahsania Mission", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Mr. Shibbir Mahmud", "Chairman, Swiss Tex Group", "Member"));
        }else if(position.equals("4")){
        	models.add(new AdminstrationArrayElement("Professor A.M.M. Safiullah", "Ph.D.(University of Strathclyde)", "Vice-Chancellor"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. M. Kaykobad", "Professor, CSE,BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. A. F. M. Anwarul Haque", "Dean, Faculty of Engineering, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. A. Muktadir", "Head, Department of Architecture, AUST", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Dipak Kanti Das", "Professor, ME, BUET", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Prof. Dr. Abu Tweb Abu Ahmed", "Professor, Department of Zoology, DU", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Dr. M. Ehsanur Rahman", "Executive Director, Dhaka Ahsania Mission", "Member"));
        	
        	models.add(new AdminstrationArrayElement("Mr. Shibbir Mahmud", "Chairman, Swiss Tex Group", "Member"));
        }
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
