package com.yuguiqi.taskmanager.ui;


import com.example.taskmanager.R;
import com.example.taskmanager.R.id;
import com.example.taskmanager.R.layout;
import com.yuguiqi.taskmanager.Constant;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Person extends Activity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person);
		
		
		textView = (TextView)findViewById(R.id.username);
		textView.setText(Constant.getUSERNAME());
	}
}
