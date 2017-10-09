package com.example.austdiary;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailAust extends Activity{

	TextView textView;
	Typeface font;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutaust);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		textView = (TextView)findViewById(R.id.tvAboutAust);
		show();
		
	}
	
	public void show(){
		try {
			AssetManager assetMenager = getAssets();
			InputStream inputStream = assetMenager.open("aust.txt");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			String st = "";
			StringBuilder stringBuilder = new StringBuilder();
			while((st=bufferReader.readLine())!=null){
				stringBuilder.append(st+"");
				textView.setText(stringBuilder.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
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
