package com.example.taskmanager;


import android.app.Activity;
import android.os.Bundle;
import android.widget.SlidingDrawer;

public class List extends Activity {
	@SuppressWarnings("deprecation")
	private SlidingDrawer sd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		sd=(SlidingDrawer)this.findViewById(R.id.doing_sd);
		
	}
}