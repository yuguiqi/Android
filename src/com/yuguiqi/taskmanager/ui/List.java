package com.yuguiqi.taskmanager.ui;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

import com.example.taskmanager.R;
import com.yuguiqi.taskmanager.ui.list.Doing;
import com.yuguiqi.taskmanager.ui.list.Finish;
import com.yuguiqi.taskmanager.ui.list.Lock;
import com.yuguiqi.taskmanager.ui.list.Undo;

public class List extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.list);		
        
        
	    TabHost tabHost = getTabHost(); 
        TabHost.TabSpec spec; 
        
        Intent intent;  
        intent = new Intent().setClass(this, Undo.class);
        spec = tabHost.newTabSpec("未完成").setIndicator("未完成",null);         
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Doing.class);
        spec = tabHost.newTabSpec("进行").setIndicator("进行",null);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Lock.class);
        spec = tabHost.newTabSpec("冻结").setIndicator("冻结",null);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, Finish.class);
        spec = tabHost.newTabSpec("完成").setIndicator("完成",null);
        tabHost.addTab(spec);
        
        tabHost.setBackgroundResource(R.color.red);
        tabHost.setCurrentTab(0);
	}

	
}
