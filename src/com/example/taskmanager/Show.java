package com.example.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Show extends Activity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		
		textView =(TextView)findViewById(R.id.show);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		String password = intent.getStringExtra("password");
		textView.setText("User:"+name+"; password:"+password);
	}
}
