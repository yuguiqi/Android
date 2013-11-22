package com.example.taskmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
				if(validate()){
					Intent intent = new Intent(LoginActivity.this,Main.class);
					intent.putExtra("username", editName.getText().toString());
					intent.putExtra("password", editPwd.getText().toString());
					startActivity(intent);
				}
				
			}
		});
	}
	
	//校验输入不为空
	private boolean validate(){
		String username = editName.getText().toString();
		String password = editPwd.getText().toString();
		
		if("".equals(username)){
			showDialog("用户名不能为空！");
			return false;
		}

		if("".equals(password)){
			showDialog("用户密码不能为空！");
			return false;
		}
		
		return true;
	}

	//显示对话框	
	private void showDialog(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setMessage(msg)
			   .setCancelable(false)
			   .setPositiveButton("确定", new DialogInterface.OnClickListener() {		
						public void onClick(DialogInterface dialog, int which) {}
					});
		AlertDialog dialog  = builder.create();
		dialog.show();
	}
}









