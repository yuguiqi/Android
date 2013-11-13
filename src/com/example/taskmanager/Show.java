package com.example.taskmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Show extends Activity {
	private TextView textView;
	private DatePicker datePicker;
	private TimePicker timePicker;
	private Calendar calendar;
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
		
		calendar = Calendar.getInstance();
		
		datePicker = (DatePicker)findViewById(R.id.datePicker1);
		datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
				
				new DatePicker.OnDateChangedListener() {
			//当前日期更改时，在这里设置 
				@Override
				public void onDateChanged(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					calendar.set(year,monthOfYear,dayOfMonth);  
					
				}
			});
		//点击调日期
		datePicker.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DatePickerDialog(Show.this,
						new DatePickerDialog.OnDateSetListener() {
							
							@Override
							public void onDateSet(DatePicker view, int year, int monthOfYear,
									int dayOfMonth) {
								
								//设置日历
							}
						},calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
				
			}
		});
		
		timePicker = (TimePicker)findViewById(R.id.timePicker1);
		//设置24小时制
		timePicker.setIs24HourView(true);
		 //监听时间改变  
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {  
              
            @Override  
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {  
                // TODO Auto-generated method stub  
                //时间改变处理  
               calendar.set(hourOfDay,minute);  
            }  
        });  
		
		//点击调时间
		timePicker.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new TimePickerDialog(Show.this, new TimePickerDialog.OnTimeSetListener() {
					
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						
						//设置时间
					}
				}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true).show();
				
			}
		});
	}
}
