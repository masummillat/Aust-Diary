package com.example.austdiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread t = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent go = new Intent("com.example.austdiary.MainActivity");
					startActivity(go);
				}
			}
			
		};
		t.start();
			

}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
