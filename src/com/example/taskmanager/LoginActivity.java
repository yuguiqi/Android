package com.example.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText editName,editPwd;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		editName = (EditText)findViewById(R.id.username);
		editName.setHint("请输入用户名");//水印效果 
		editPwd = (EditText)findViewById(R.id.password);
		//editPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//*号
		editPwd.setHint("请输入用密码");
		button =(Button)findViewById(R.id.login);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,Main.class);
				intent.putExtra("name", editName.getText().toString());
				intent.putExtra("password", editPwd.getText().toString());
				startActivity(intent);
				
			}
		});
	}

}
