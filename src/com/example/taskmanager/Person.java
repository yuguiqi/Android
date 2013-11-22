package com.example.taskmanager;


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
