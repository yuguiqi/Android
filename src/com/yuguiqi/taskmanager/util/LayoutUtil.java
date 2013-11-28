package com.yuguiqi.taskmanager.util;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.ViewGroup;

public class LayoutUtil {
	
	public static LayoutParams getMWParams(){
		
		return (LayoutParams) new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
	}
	
	public static LayoutParams getMMParams(){
		
		return (LayoutParams) new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
	}
	
	public static LayoutParams getWWParams(){
		
		return (LayoutParams) new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
	}
	
    public static LayoutParams getWMParams(){
		
		return (LayoutParams) new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
	}
}
