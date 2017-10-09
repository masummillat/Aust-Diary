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
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;




public class AboutAustActivity extends Activity{
	private List<AboutItem> myAbout = new ArrayList<AboutItem>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutlist);
		
		
		
		populateList();
		populateListView();
		registerClickCallBack();
		
		
		
	}
	
	private void populateList() {
		// TODO Auto-generated method stub
		myAbout.add(new AboutItem("History",R.drawable.history));
		myAbout.add(new AboutItem("Adminstration",R.drawable.admin));
		myAbout.add(new AboutItem("Admission",R.drawable.admission));
	
	}
	
	private void populateListView() {
		// TODO Auto-generated method stub
		ArrayAdapter<AboutItem> adapter = new MyListAdapter();
		ListView list = (ListView)findViewById(R.id.AboutListView);
		list.setAdapter(adapter);
		
	}
	private class MyListAdapter extends ArrayAdapter<AboutItem>{
		public MyListAdapter(){
			super(AboutAustActivity.this, R.layout.item_view,myAbout);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View itemView = convertView;
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
				
			}
			
			//find the Department to work with
			AboutItem currentcar = myAbout.get(position);
			
			//fill the image
			ImageView imageview = (ImageView)itemView.findViewById(R.id.image_icon);
			imageview.setImageResource(currentcar.getIconId());
			
			//Department name
			TextView maketext = (TextView)itemView.findViewById(R.id.txtDept);
			maketext.setText(currentcar.getAboutName());
			
			return itemView;
			
			//return super.getView(position, convertView, parent);
		}
		
		
	}
	
	
	
	
	private void registerClickCallBack() {
		// TODO Auto-generated method stub
		ListView list = (ListView)findViewById(R.id.AboutListView);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// TODO Auto-generated method stub
				String message = ""+ position ;
				//Toast.makeText(AboutAustActivity.this, message, Toast.LENGTH_SHORT).show();
				if(message.equals("0")){
					//Toast.makeText(AboutAustActivity.this, "History & Detail", Toast.LENGTH_SHORT).show();
					Intent go = new Intent("com.example.austdiary.DetailAust");	
					startActivity(go);
				}else if(message.equals("1")){
					//Toast.makeText(AboutAustActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					Intent go = new Intent("com.example.austdiary.Adminstration");	
					startActivity(go);
					
				}else if(message.equals("2")){
					//Toast.makeText(AboutAustActivity.this, "Admission", Toast.LENGTH_SHORT).show();
					Intent go = new Intent("com.example.austdiary.AdmissionActivity");	
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
                AboutAustActivity.this);
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
            this.finish();
            return true;
        default:
            return super.onOptionsItemSelected(item);
		}
		
	}
	
}
