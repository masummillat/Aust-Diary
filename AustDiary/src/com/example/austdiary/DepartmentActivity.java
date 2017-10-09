package com.example.austdiary;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DepartmentActivity extends Activity{
	private List<DeptItem> myDepartment = new ArrayList<DeptItem>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deptlist);
		populateList();
		populateListView();
		registerClickCallBack();
		
	}
	
	private void populateList() {
		// TODO Auto-generated method stub
		myDepartment.add(new DeptItem("ARCHI",R.drawable.archi));
		myDepartment.add(new DeptItem("BBA",R.drawable.bba));
		myDepartment.add(new DeptItem("CE",R.drawable.civil));
		myDepartment.add(new DeptItem("CSE",R.drawable.cse));
		myDepartment.add(new DeptItem("EEE",R.drawable.eee));
		myDepartment.add(new DeptItem("IPE",R.drawable.ipe));
		myDepartment.add(new DeptItem("ME",R.drawable.mpe));
		myDepartment.add(new DeptItem("MBA/EMBA",R.drawable.mba));
		myDepartment.add(new DeptItem("MSM",R.drawable.msm));
		myDepartment.add(new DeptItem("TE",R.drawable.textial));
		
		
	}
	
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<DeptItem> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.DeptListView);
		list.setAdapter(adapter);
		
	}
	private class MyListAdapter extends ArrayAdapter<DeptItem>{
		public MyListAdapter(){
			super(DepartmentActivity.this, R.layout.item_view,myDepartment);
		
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View itemView = convertView;
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
				
			}
			
			//find the Department to work with
			DeptItem currentcar = myDepartment.get(position);
			
			//fill the image
			ImageView imageview = (ImageView)itemView.findViewById(R.id.image_icon);
			imageview.setImageResource(currentcar.getIconId());
			
			//Department name
			TextView maketext = (TextView)itemView.findViewById(R.id.txtDept);
			maketext.setText(currentcar.getDeptName());
			
			return itemView;
			
			//return super.getView(position, convertView, parent);
		}
		
		
	}
	private void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list = (ListView)findViewById(R.id.DeptListView);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				String message = ""+ position ;
				//Toast.makeText(DepartmentActivity.this, message, Toast.LENGTH_SHORT).show();
				if(message.equals("0")){
					Intent go = new Intent("com.example.austdiary.Architecture");
					startActivity(go);
				}else if(message.equals("1")){
					Intent go = new Intent("com.example.austdiary.BBA");	
					startActivity(go);
				}else if(message.equals("2")){
					Intent go = new Intent("com.example.austdiary.CivilDepartment");	
					startActivity(go);
				}else if(message.equals("3")){
					Intent go = new Intent("com.example.austdiary.CseDepartment");	
					startActivity(go);
				}else if(message.equals("4")){
					Intent go = new Intent("com.example.austdiary.EeeDepartment");	
					startActivity(go);
				}else if(message.equals("5")){
					Intent go = new Intent("com.example.austdiary.IPEDepartment");	
					startActivity(go);
				}else if(message.equals("6")){
					Intent go = new Intent("com.example.austdiary.MEDepartment");	
					startActivity(go);
				}else if(message.equals("7")){
					Intent go = new Intent("com.example.austdiary.MBA");	
					startActivity(go);
				}else if(message.equals("8")){
					Intent go = new Intent("com.example.austdiary.MSM");	
					startActivity(go);
				}else if(message.equals("9")){
					Intent go = new Intent("com.example.austdiary.TextileDepartment");	
					startActivity(go);
				}
			}
		});
		
	}
	
	//onBackPressed Activity finish alertDialog
	@Override
	public void onBackPressed() {
		Log.i("Taggggggggggggggg", "faljflajfl");
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                DepartmentActivity.this);
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
