package com.example.taskmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TextView;

public class Main extends TabActivity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
	     setContentView(R.layout.main);
	     
	     TabHost tabHost = getTabHost(); 
         TabHost.TabSpec spec; 
         Intent intent;  
         intent = new Intent().setClass(this, Undo.class);
         spec = tabHost.newTabSpec("未完成").setIndicator("未完成",null).setContent(intent);
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, Doing.class);
         spec = tabHost.newTabSpec("進行").setIndicator("進行",null).setContent(intent);
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, Lock.class);
         spec = tabHost.newTabSpec("凍結").setIndicator("凍結",null).setContent(intent);
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, Finished.class);
         spec = tabHost.newTabSpec("完成").setIndicator("完成",null).setContent(intent);
         tabHost.addTab(spec);
         
         
         
	}
}
