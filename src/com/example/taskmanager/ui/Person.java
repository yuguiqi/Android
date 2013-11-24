package com.example.taskmanager.ui;


import com.example.taskmanager.Constant;
import com.example.taskmanager.R;
import com.example.taskmanager.R.id;
import com.example.taskmanager.R.layout;

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
