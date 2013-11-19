package com.example.taskmanager;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
	     
	     Resources res = getResources(); 
	     TabHost tabHost = getTabHost(); 
         TabHost.TabSpec spec; 
         Intent intent;  
         intent = new Intent().setClass(this, Home.class);
         spec = tabHost.newTabSpec("首页").setIndicator("首页",res.getDrawable(R.drawable.home)).setContent(intent);
         
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, List.class);
         spec = tabHost.newTabSpec("列表").setIndicator("列表",res.getDrawable(R.drawable.list)).setContent(intent);
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, Operate.class);
         spec = tabHost.newTabSpec("操作").setIndicator("操作",res.getDrawable(R.drawable.operate)).setContent(intent);
         tabHost.addTab(spec);
         
         intent = new Intent().setClass(this, Person.class);
         spec = tabHost.newTabSpec("个人中心").setIndicator("个人中心",res.getDrawable(R.drawable.person)).setContent(intent);
         tabHost.addTab(spec);
         
         tabHost.setBackgroundColor(res.getColor(R.color.blue_background));
         
         
         
	}
}
