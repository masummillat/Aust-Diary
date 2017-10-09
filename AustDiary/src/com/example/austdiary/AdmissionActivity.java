package com.example.austdiary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AdmissionActivity extends Activity{
private List<AdmissionItem> myAdmission = new ArrayList<AdmissionItem>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admissionlist);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		
		populateList();
		populateListView();
		registerClickCallBack();
	}
	
	private void populateList() {
		// TODO Auto-generated method stub
		myAdmission.add(new AdmissionItem("Faculties and Departments",R.drawable.admission));
		myAdmission.add(new AdmissionItem("Admission system for bachelor degree programs",R.drawable.admission));
		myAdmission.add(new AdmissionItem("Application process for ssc & hsc candidates",R.drawable.admission));
		myAdmission.add(new AdmissionItem("Application process for O and A-level candidates",R.drawable.admission));
		myAdmission.add(new AdmissionItem("Freedom fighter and remote & undevelop area quota",R.drawable.admission));
		
		myAdmission.add(new AdmissionItem("Admission test",R.drawable.admission));
		
	
	}
	
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<AdmissionItem> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.AdmissionListView);
		list.setAdapter(adapter);
		
	}
	private class MyListAdapter extends ArrayAdapter<AdmissionItem>{
		public MyListAdapter(){
			super(AdmissionActivity.this, R.layout.item_view,myAdmission);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View itemView = convertView;
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
				
			}
			
			//find the Department to work with
			AdmissionItem currentcar = myAdmission.get(position);
			
			//fill the image
			ImageView imageview = (ImageView)itemView.findViewById(R.id.image_icon);
			imageview.setImageResource(currentcar.getIconId());
			
			//Department name
			TextView maketext = (TextView)itemView.findViewById(R.id.txtDept);
			maketext.setText(currentcar.getAdmissionName());
			
			return itemView;
			
			//return super.getView(position, convertView, parent);
		}
		
		
	}
	
	
	private void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list = (ListView)findViewById(R.id.AdmissionListView);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				String message = ""+ position ;
				//Toast.makeText(AboutAustActivity.this, message, Toast.LENGTH_SHORT).show();
				if(message.equals("0")){
					 					
					Intent	go= new Intent("com.example.austdiary.FacaltyAndDepartment");	
					go.putExtra("key", "faculty");
					startActivity(go);
					
				}else if(message.equals("1")){
					
					Intent go = new Intent();
					
					go= new Intent("com.example.austdiary.AdmissionSystem");	
					startActivity(go);	
				}else if(message.equals("2")){
					
					Intent	go= new Intent("com.example.austdiary.FacaltyAndDepartment");	
					go.putExtra("key", "minreq");
					startActivity(go);
				}else if(message.equals("3")){
					Intent	go= new Intent("com.example.austdiary.FacaltyAndDepartment");	
					go.putExtra("key", "minreqoa");
					startActivity(go);
				}else if(message.equals("4")){
					Intent	go= new Intent("com.example.austdiary.FacaltyAndDepartment");	
					go.putExtra("key", "ffremot");
					startActivity(go);
				}else if(message.equals("5")){
					Intent	go= new Intent("com.example.austdiary.FacaltyAndDepartment");	
					go.putExtra("key", "test");
					startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}else if(message.equals("1")){
					Toast.makeText(AdmissionActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					//Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
					//startActivity(go);	
				}
				
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
