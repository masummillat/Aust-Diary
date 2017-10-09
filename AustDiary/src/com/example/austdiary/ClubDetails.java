package com.example.austdiary;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ClubDetails extends Activity {
	
	TextView ClubName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_club_details);
		
		ClubName = (TextView)findViewById(R.id.tvClubName);
		String url="",Club=""; 
		
		Bundle bundle = getIntent().getExtras();
		if(bundle.getString("key").equals("photo")){
		 url = "http://www.austpc.org/";
		 Club ="Aust Photography Club"; 
		
		}else if(bundle.getString("key").equals("EEE Project Society")){
			url = "https://www.facebook.com/AustEeeProjectSociety";
			 Club ="Aust Robotics Society"; 
		}else if(bundle.getString("key").equals("Debate")){
			url = "https://www.facebook.com/austdc";
			 Club ="Aust Debate Club"; 
		}
			
			ClubName.setText(Club);
			WebView webView = new WebView(this);
			webView.getSettings().setLoadsImagesAutomatically(true);
			webView.getSettings().setJavaScriptEnabled(true);
			
			webView.setWebViewClient(new WebViewClient() {
		        @Override
		        public boolean shouldOverrideUrlLoading(WebView view, String url) {
		            view.loadUrl(url);
		            return false;
		        }
		    });
		    
			webView.loadUrl(url);
			
			setContentView(webView);		
		
	}
	
	
	private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            return(false);
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.club_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
