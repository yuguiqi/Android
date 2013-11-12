package com.example.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
		textView.setText(name);
		
		if("登录".equals(textView.getText().toString())){
			textView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent1 = new Intent(Show.this,LoginActivity.class);
					startActivity(intent1);
				}
			});
		}
	}
}
