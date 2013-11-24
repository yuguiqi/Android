package com.example.taskmanager.ui;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.taskmanager.R;
import com.example.taskmanager.util.JSONUtil;

@SuppressLint("ResourceAsColor")
public class Home extends Activity {
	
	private static final String TAG = "HOME";
	/** 
     * 访问的后台地址
     */  
    private static final String BASE_URL = "http://122.10.9.227:7777/pull/getAll";

	private LinearLayout linearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		linearLayout = (LinearLayout)findViewById(R.id.myLinearLayout);
		linearLayout.removeAllViews();
		try {
			//获取后台返回的Json对象  
			JSONObject mJsonObject = JSONUtil.getJSON(BASE_URL);
			Log.d(TAG, "mJsonObject="+mJsonObject.toString());
			
			
			JSONArray array = mJsonObject.getJSONArray("result_message");
			for(int i=0;i<array.length();i++){
				
				JSONObject object = array.getJSONObject(i);
				String name = object.getString("taskName");
				String taskMaker = object.getString("taskMaker");
				
				Log.d(TAG, "taskName="+name);
				Log.d(TAG, "taskMaker="+taskMaker);
				
				TableLayout tableLayout = new TableLayout(this);
				tableLayout.setBackgroundColor(R.color.white);
				
				TableRow row1 = new TableRow(this);
				
				TextView textView1 = new TextView(this);
				textView1.setText("任务名称：");				
				textView1.setWidth(LayoutParams.WRAP_CONTENT);
				
				TextView taskName = new TextView(this);
				taskName.setText(name);				
				taskName.setWidth(LayoutParams.WRAP_CONTENT);
				
				row1.addView(textView1);
				row1.addView(taskName);
				
				

				TableRow row2 = new TableRow(this);
				
				TextView textView2 = new TextView(this);
				textView2.setText("发起人：");
				textView2.setWidth(LayoutParams.WRAP_CONTENT);
				
				TextView taskDetail = new TextView(this);
				taskDetail.setText(taskMaker);
				taskDetail.setWidth(LayoutParams.WRAP_CONTENT);
				
				row2.addView(textView2);
				row2.addView(taskDetail);
				
				tableLayout.addView(row1);
				tableLayout.addView(row2);
				linearLayout.addView(tableLayout);
				
			}
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TextView textView = new TextView(this);
		textView.setText("nihao");
		textView.setWidth(LayoutParams.WRAP_CONTENT);
		linearLayout.addView(textView);	
		
	}
}
