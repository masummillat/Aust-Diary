package com.example.austdiary;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ResultSpinner extends Activity {

	Spinner spinner1,spinner2;
	private Button btnSubmit;
	String deptName;
	WebView webResult;
	TextView DepartmentName;
	//WebView webView = new WebView(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_result_spinner);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		DepartmentName = (TextView)findViewById(R.id.tvDepartmentName);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		webResult = (WebView)findViewById(R.id.resultWebView);
		
		
		
		webResult.setWebViewClient(new WebViewClient());
		 WebSettings webSettings = webResult.getSettings();
	     webSettings.setJavaScriptEnabled(true);
	     
	     
	     
		addItemsOnSpinner1();
		addItemsOnSpinner2();
		//setting department name in the activity_result_spinner
		SetDepartmentName();
		
		addListenerOnButton();
	}
	
	public void SetDepartmentName(){
		if(deptName.equals("arc")){
			DepartmentName.setText("Architecture");
		}else if(deptName.equals("bba")){
			DepartmentName.setText("BBA");
		}
		else if(deptName.equals("ce")){
			DepartmentName.setText("CE");
		}
		else if(deptName.equals("cse")){
			DepartmentName.setText("CSE");
		}
		else if(deptName.equals("eee")){
			DepartmentName.setText("EEE");
		}
		else if(deptName.equals("ipe")){
			DepartmentName.setText("IPE");
			
		}else if(deptName.equals("me")){
			DepartmentName.setText("ME");
			
		}else if(deptName.equals("te")){
			DepartmentName.setText("TE");
		}
		
		
	}
	public void addItemsOnSpinner1(){
		Bundle bundle = getIntent().getExtras();
		//Getting Department Name
		deptName = bundle.getString("dept");
		//Toast.makeText(getApplicationContext(), "Selected department name is :"+deptName, Toast.LENGTH_SHORT).show();
		if(bundle.getString("dept").equals("bba")){
		List<String> list1 = new ArrayList<String>();
		list1.add("Theory");
		list1.add("Clearance");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);
		}else{
			List<String> list1 = new ArrayList<String>();
			list1.add("Theory");
			list1.add("Seassional");
			list1.add("Clearance");
			
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner1.setAdapter(dataAdapter);
		}
	}

	public void addItemsOnSpinner2() {
		Bundle bundle = getIntent().getExtras();
		if(bundle.getString("dept").equals("arc")){
		List<String> list = new ArrayList<String>();
		list.add("1st year 1st semester");
		list.add("1st year 2nd semester");
		list.add("2nd year 1st semester");
		list.add("2nd year 2nd semester");
		list.add("3rd year 1st semester");
		list.add("3rd year 2nd semester");
		list.add("4th year 1st semester");
		list.add("4th year 2nd semester");
		list.add("5th year 1st semester");
		list.add("5th year 2nd semester");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
		}else{
			List<String> list = new ArrayList<String>();
			list.add("1st year 1st semester");
			list.add("1st year 2nd semester");
			list.add("2nd year 1st semester");
			list.add("2nd year 2nd semester");
			list.add("3rd year 1st semester");
			list.add("3rd year 2nd semester");
			list.add("4th year 1st semester");
			list.add("4th year 2nd semester");
			
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(dataAdapter);
			
		}
	}
	
	//get the selected dropdown list value
		public void addListenerOnButton() {

			
			
			btnSubmit = (Button) findViewById(R.id.btnSubmit);

			btnSubmit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String examType = String.valueOf(spinner1.getSelectedItem());
					String resultFor = String.valueOf(spinner2.getSelectedItem());
				
				/*	Toast.makeText(ResultSpinner.this,
							"OnClickListener : " + 
							"\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
							"\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
							Toast.LENGTH_SHORT).show();
					*/
					
					String exam="";
					
					if(examType.equals("Theory")){
						exam = "t";
					}else if(examType.equals("Seassional")){
						exam = "s";
					}else if(examType.equals("Clearance")){
						exam = "c";
					}
					//geting REsult for
					String year="",semester="";
					if(resultFor.equals("1st year 1st semester")){
						year = "1";
						semester = "1";
					}else if(resultFor.equals("1st year 2nd semester")){
						year = "1";
						semester = "2";
					}else if(resultFor.equals("2nd year 1st semester")){
						year = "2";
						semester = "1";
					}else if(resultFor.equals("2nd year 2nd semester")){
						year = "2";
						semester = "2";
					}else if(resultFor.equals("3rd year 1st semester")){
						year = "3";
						semester = "1";
					}else if(resultFor.equals("3rd year 2nd semester")){
						year = "3";
						semester = "2";
					}else if(resultFor.equals("4th year 1st semester")){
						year = "4";
						semester = "1";
					}else if(resultFor.equals("4th year 2nd semester")){
						year = "4";
						semester = "2";
					}else if(resultFor.equals("5th year 1st semester")){
						year = "5";
						semester = "1";
					}else if(resultFor.equals("5th year 2nd semester")){
						year = "5";
						semester = "2";
					}
					
						
						String result = getImages(deptName,exam,year,semester);
						Log.i("string", result);
						
						webResult.loadData(result, "text/html", null);
						 		
					
				}

			});

		}
		
		//Dinamically getting the image form aust website
		public String getImages(String dept, String type, String year, String semester){
			StringBuilder str = new StringBuilder();
			str.append("<html><body>");
			int i= 0;
			for(i=1; i<=20; i++){
				if(i<=9){
					str.append("<img src='http://www.aust.edu/result_images/"+dept+"_"+type+"_"+year+"_"+semester+"_0"+i+".jpg'>");
				}
				
				else{
					str.append("<img src='http://www.aust.edu/result_images/"+dept+"_"+type+"_"+year+"_"+semester+"_"+i+".jpg'>");
				}
			}
			str.append("</body></html>");
			return str.toString();
		}
		
		
	
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_spinner, menu);
		return true;
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
