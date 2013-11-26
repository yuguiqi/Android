package com.yuguiqi.taskmanager.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil {
	
	public static void showDialog(AlertDialog dialog){
		dialog.show();
	}
	
	//全部信息弹出框  
	public static AlertDialog dialog(Context context,String title,String msg,String positive,String cancel ){
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		if(title!=null && !"".equals(title)){
			builder.setTitle(title);
		}
		
		if(positive!=null && !"".equals(positive)){
			builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {		
				public void onClick(DialogInterface dialog, int which) {}
			});
		}
		
		if(cancel!=null && !"".equals(cancel)){
			builder.setNegativeButton(cancel, new DialogInterface.OnClickListener() {		
				public void onClick(DialogInterface dialog, int which) {}
			});
		}else{
			builder.setCancelable(false);
		}
		
		builder.setMessage(msg);
		
		AlertDialog dialog  = builder.create();
		return dialog;
	}
	
	//显示信心和确定按钮的对话框
	public static AlertDialog mpDialog(Context context,String msg,String positive){
		return dialog(context,null,msg,positive,null);
	}
}
