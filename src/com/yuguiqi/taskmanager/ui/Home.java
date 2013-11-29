package com.yuguiqi.taskmanager.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.taskmanager.R;
import com.yuguiqi.taskmanager.util.JSONUtil;

@SuppressLint("ResourceAsColor")
public class Home extends Activity {

	private static final String TAG = "HOME";
	/**
	 * 访问的后台地址
	 */
	private static final String BASE_URL = "http://122.10.9.227:7777/pull/getAll";

	private LinearLayout listLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		listLayout = (LinearLayout) findViewById(R.id.listLayout);
		listLayout.removeAllViews();
		try {
			JSONObject JsonObject = JSONUtil.getJSON(BASE_URL);

			if ("OK".equals(JsonObject.get("result"))) {
				Log.d(TAG, "taskList:" + JsonObject.toString());
				JSONArray jsonArray = JsonObject.getJSONArray("result_message");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String taskInfo = object.getString("taskInfo");
					String taskMaker = object.getString("taskMaker");
					String taskName = object.getString("taskName");
					int taskPercent = object.getInt("taskPercent");

					TableLayout tableLayout = new TableLayout(this);
					tableLayout.setBackgroundColor(R.color.white);

					TableRow row1 = getRow();

					TextView textView11 = getTextView(1);
					textView11.setText("任务名称：");

					TextView textView12 = getTextView(9);
					textView12.setText(taskName);

					row1.addView(textView11);
					row1.addView(textView12);

					TableRow row2 = getRow();

					TextView textView21 = getTextView(1);
					textView21.setText("任务描述：");

					TextView textView22 = getTextView(9);
					textView22.setText(taskInfo);

					row2.addView(textView21);
					row2.addView(textView22);

					TableRow row3 = getRow();

					TextView textView31 = getTextView(1);
					textView31.setText("任务进度：");

					ProgressBar progressBar = new ProgressBar(this);
					// 設置为横条
					progressBar.setProgressDrawable(getResources().getDrawable(
							android.R.drawable.progress_horizontal));
					progressBar
							.setIndeterminateDrawable(getResources()
									.getDrawable(
											android.R.drawable.progress_horizontal));
					progressBar.setIndeterminate(false);
					progressBar.setBackgroundResource(R.
							color.white);
					progressBar.setMax(100);
					progressBar.setProgress(taskPercent);
					progressBar.setEnabled(false);
					
					TextView textView32 = getTextView(9);
					textView32.setText(taskPercent + "%");

					row3.addView(textView31);
					row3.addView(progressBar);

					TableRow row4 = getRow();

					TextView textView41 = getTextView(1);
					textView41.setText("派发人：");

					TextView textView42 = getTextView(9);
					textView42.setText(taskMaker);

					row4.addView(textView41);
					row4.addView(textView42);

					tableLayout.addView(row1);
					tableLayout.addView(row2);
					tableLayout.addView(row3);
					tableLayout.addView(row4);


					TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.MATCH_PARENT);

					tableLayout.setLayoutParams(lp);
					tableLayout.setBackgroundResource(R.color.white);
					tableLayout.setStretchAllColumns(true);
					tableLayout.setPadding(5, 5, 5, 5);

					row1.setPadding(5, 5, 5, 0);
					row2.setPadding(5, 0, 5, 0);
					row3.setPadding(5, 0, 5, 0);
					progressBar.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT, 15, 9));
					row4.setPadding(5, 0, 5, 5);
					

					listLayout.addView(tableLayout);
				}
			} else {
				Log.d(TAG, "请求失败！测试json url：" + BASE_URL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	//定义白色背景的textView 以及权重
	private TextView getTextView(int weight){
		TextView textView = new TextView(this);
		
		TableRow.LayoutParams textLayoutParams = new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT,
				TableRow.LayoutParams.MATCH_PARENT, weight);
		textView.setBackgroundResource(R.color.white);
		textView.setLayoutParams(textLayoutParams);
		
		return textView; 
	}
	
	//定义蓝色背景的TableRow 以及样式
	private TableRow getRow(){
		TableRow row = new TableRow(this);
		TableRow.LayoutParams rowLayoutParams = new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.MATCH_PARENT);
		row.setLayoutParams(rowLayoutParams);
		row.setBackgroundResource(R.color.blue_background);
		return row;
	}
	
	// 获取数据返回list 对应适配器Adapter
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			JSONObject JsonObject = JSONUtil.getJSON(BASE_URL);
			if ("OK".equals(JsonObject.get("result"))) {
				JSONArray jsonArray = JsonObject.getJSONArray("result_message");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String taskInfo = object.getString("taskInfo");
					String taskMaker = object.getString("taskMaker");
					String taskName = object.getString("taskName");
					int taskPercent = object.getInt("taskPercent");

					Map<String, Object> map = new HashMap<String, Object>();
					map.put("taskName", "任务名称：" + taskName);
					map.put("taskInfo", "任务描述：" + taskInfo);
					map.put("taskMaker", "派发人：" + taskMaker);
					map.put("taskPercent", "任务进度：" + taskPercent + "%");

					list.add(map);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
