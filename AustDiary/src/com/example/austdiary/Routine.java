package com.example.austdiary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Routine extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_routine);
		android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D74FF")));
		
		Bundle bundle = getIntent().getExtras();
		if(bundle.getString("pdf").equals("msm")){
			WebView webView = new WebView(this);
			webView.getSettings().setLoadsImagesAutomatically(true);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl("http://www.aust.edu/rs/class_routine_math.htm");
			setContentView(webView);
		}
		else{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			String pdf = bundle.getString("pdf");
			intent.setData(Uri.parse("http://docs.google.com/gview?embedded=true&url=" + pdf));
			// Always use string resources for UI text. This says something like "Share this photo with"
			// Create and start the chooser
			Intent chooser = Intent.createChooser(intent, "Choose App:");
			startActivity(chooser);
		}
		
		    
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.routine, menu);
		return true;
	}


	
	
	
	private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            return(false);
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

