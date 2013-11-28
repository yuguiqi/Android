package com.yuguiqi.taskmanager.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.taskmanager.R;
import com.yuguiqi.taskmanager.util.JSONUtil;
import com.yuguiqi.taskmanager.util.LayoutUtil;

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

					TableRow row1 = new TableRow(this);

					TextView textView11 = new TextView(this);
					textView11.setText("任务名称：");

					TextView textView12 = new TextView(this);
					textView12.setText(taskName);

					row1.addView(textView11);
					row1.addView(textView12);

					TableRow row2 = new TableRow(this);

					TextView textView21 = new TextView(this);
					textView21.setText("任务描述：");

					TextView textView22 = new TextView(this);
					textView22.setText(taskInfo);

					row2.addView(textView21);
					row2.addView(textView22);

					TableRow row3 = new TableRow(this);

					TextView textView31 = new TextView(this);
					textView31.setText("任务进度：");
					
					ProgressBar progressBar = new ProgressBar(this);
					progressBar.isHorizontalFadingEdgeEnabled();
					progressBar.setMax(100);
					progressBar.setProgress(taskPercent);
					
					TextView textView32 = new TextView(this);
					textView32.setText(taskPercent + "%");

					row3.addView(textView31);
					row3.addView(progressBar);

					TableRow row4 = new TableRow(this);

					TextView textView41 = new TextView(this);
					textView41.setText("派发人：");

					TextView textView42 = new TextView(this);
					textView42.setText(taskMaker);

					row4.addView(textView41);
					row4.addView(textView42);

					tableLayout.addView(row1);
					tableLayout.addView(row2);
					tableLayout.addView(row3);
					tableLayout.addView(row4);

					TableRow.LayoutParams rowLayoutParams = new TableRow.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.MATCH_PARENT);
					
					TableRow.LayoutParams textLayoutParams1 = new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.MATCH_PARENT,1);
					
					TableRow.LayoutParams textLayoutParams9 = new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.MATCH_PARENT,9);
					
					TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.MATCH_PARENT); 
					
					
					tableLayout.setLayoutParams(lp);
					tableLayout.setBackgroundResource(R.color.white);
					tableLayout.setStretchAllColumns(true);
					tableLayout.setPadding(5, 5, 5, 5);
					
					row1.setLayoutParams(rowLayoutParams);
					row1.setBackgroundResource(R.color.blue_background);
					row1.setPadding(5, 5, 5, 0);
					textView11.setLayoutParams(textLayoutParams1);
					textView11.setBackgroundResource(R.color.white);
					textView12.setLayoutParams(textLayoutParams9);
					textView12.setBackgroundResource(R.color.white);
					
					row2.setLayoutParams(rowLayoutParams);
					row2.setBackgroundResource(R.color.blue_background);
					row2.setPadding(5, 0, 5, 0);
					textView21.setLayoutParams(textLayoutParams1);
					textView21.setBackgroundResource(R.color.white);
					textView22.setLayoutParams(textLayoutParams9);
					textView22.setBackgroundResource(R.color.white);
					
					row3.setLayoutParams(rowLayoutParams);
					row3.setBackgroundResource(R.color.blue_background);
					row3.setPadding(5, 0, 5, 0);
					textView31.setLayoutParams(textLayoutParams1);
					textView31.setBackgroundResource(R.color.white);
					textView32.setLayoutParams(textLayoutParams9);
					textView32.setBackgroundResource(R.color.white);
					progressBar.setLayoutParams(textLayoutParams9);
					
					row4.setLayoutParams(rowLayoutParams);
					row4.setBackgroundResource(R.color.blue_background);
					row4.setPadding(5, 0, 5, 5);
					textView41.setLayoutParams(textLayoutParams1);
					textView41.setBackgroundResource(R.color.white);
					textView42.setLayoutParams(textLayoutParams9);
					textView42.setBackgroundResource(R.color.white);
					
					listLayout.addView(tableLayout);
				}
			} else {
				Log.d(TAG, "请求失败！测试json url：" + BASE_URL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
