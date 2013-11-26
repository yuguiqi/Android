package com.yuguiqi.taskmanager.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.example.taskmanager.R;
import com.yuguiqi.taskmanager.util.JSONUtil;

@SuppressLint("ResourceAsColor")
public class Home extends ListActivity {

	private static final String TAG = "HOME";
	/**
	 * 访问的后台地址
	 */
	private static final String BASE_URL = "http://122.10.9.227:7777/pull/getAll";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(),
				R.layout.scroll, new String[] { "taskName", "taskInfo",
						"taskMaker", "taskPercent" }, new int[] {
						R.id.taskName, R.id.taskInfo, R.id.taskMaker,
						R.id.taskPercent });
		
		setListAdapter(simpleAdapter);

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
