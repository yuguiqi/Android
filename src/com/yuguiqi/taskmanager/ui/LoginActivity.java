package com.yuguiqi.taskmanager.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskmanager.R;
import com.yuguiqi.taskmanager.util.DialogUtil;
import com.yuguiqi.taskmanager.util.JSONUtil;

public class LoginActivity extends Activity {
	
	/** 
     * 访问的后台地址
     */  
    private static final String BASE_URL = "http://122.10.9.227:7777/";

	private EditText editName,editPwd;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	
		editName = (EditText)findViewById(R.id.username);
		editName.setHint("请输入用户名");//水印效果 
		editPwd = (EditText)findViewById(R.id.password);		
		editPwd.setHint("请输入用密码");
		
		button =(Button)findViewById(R.id.login);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(validate()){
					if(login()){
						Intent intent = new Intent(LoginActivity.this,Main.class);
						intent.putExtra("username", editName.getText().toString());
						intent.putExtra("password", editPwd.getText().toString());
						startActivity(intent);
					}else{
						showDialog("用户密码错误！");
					}
				}
			}
		});
	}
	
	//登陆验证
	private boolean login(){
		String username = editName.getText().toString();
		String password = editPwd.getText().toString();
		String queryString = "name="+username+"&pass="+password;
		String url = BASE_URL+"push/login?"+queryString;
		
		boolean flag =false;
		
		try {
			//获取后台返回的Json对象  
			JSONObject mJsonObject = JSONUtil.getJSON(url);
			Log.d("D", "mJsonObject="+mJsonObject.toString());
			
			String result = mJsonObject.getString("result");
			
			Log.d("D", "result="+result);
			if("OK".equals(result)){
				flag = true;
			}
	        
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  
  
		return flag;
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
		DialogUtil.mpDialog(this, msg, "确定").show();
	}
	
	
}









