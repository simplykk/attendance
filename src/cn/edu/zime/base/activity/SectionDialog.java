package cn.edu.zime.base.activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;

public class SectionDialog {

	private boolean mChoice = false; // my choice : yes or no
	private boolean isQuitDlg = false;
	private Method mMsgQueueNextMethod = null; // next msg method
	private Field mMsgTargetField = null; // target field
	private String title = ""; // msg title

	public SectionDialog() {

	}

	public SectionDialog(String title) {
		this.title = title;
	}
	
	// 准备所需场景
	private boolean prepareSection() {
		Class<?> clsMsgQueue = null;   
		Class<?> clsMessage = null;  
		try {        
			clsMsgQueue = Class.forName("android.os.MessageQueue");   
			clsMessage = Class.forName("android.os.Message"); 
		} catch (ClassNotFoundException e) {         
			e.printStackTrace();      
			return false;   
		} try {    
			mMsgQueueNextMethod = clsMsgQueue.getDeclaredMethod("next", new Class[]{});  
		} catch (SecurityException e) {   
			e.printStackTrace();     
			return false;    
		} catch (NoSuchMethodException e) {  
			e.printStackTrace();      
			return false;  
		}     
		mMsgQueueNextMethod.setAccessible(true);  // 设置方法外部可访问
		try {        
			mMsgTargetField = clsMessage.getDeclaredField("target");  
		} catch (SecurityException e) {  
			e.printStackTrace();        
			return false;     
		} catch (NoSuchFieldException e) {   
			e.printStackTrace();       
			return false;    
		}      
		mMsgTargetField.setAccessible(true);  // 设置字段外部可访问
		return true; 
		
	}
	
	// 执行场景
	private void doSection() {
		isQuitDlg = false;
		// Get message queue associated with main UI thread 
		MessageQueue mQueue = Looper.myQueue();
		while (!isQuitDlg) {
			// Call queue.next(), might block
			Message msg = null;
			try {          
				msg = (Message)mMsgQueueNextMethod.invoke(mQueue, new Object[]{});  
			} catch (IllegalArgumentException e) {  
				e.printStackTrace();      
			} catch (IllegalAccessException e) {   
				e.printStackTrace();        
			} catch (InvocationTargetException e) {  
				e.printStackTrace();        
			}          
			if (null != msg) {       
				Handler target = null;  
				try {        
					target = (Handler)mMsgTargetField.get(msg);   
				} catch (IllegalArgumentException e) {  
					e.printStackTrace();       
				} catch (IllegalAccessException e) { 
					e.printStackTrace();   
				}            
				if (target == null) {   
					// No target is a magic identifier for the quit message.    
					isQuitDlg = true;    
				}         
				target.dispatchMessage(msg); 
				msg.recycle();     
			}   
		}
	}

	public void showAlertDialog(Context context, String content,int theme) {
		if (! prepareSection()) return;
		
		// Dynamically build alert dialog  
		AlertDialog.Builder builder;
		if (theme == -1) 
			builder = new AlertDialog.Builder(context);
		else 
			builder = new AlertDialog.Builder(context,theme);
		if (title != null && !"".equals(title))
			builder.setTitle(title);
		builder.setMessage(content);
		builder.setCancelable(false); // 这句话非常重要，设置不能取消
		builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				SectionDialog.this.isQuitDlg = true;
				dialog.dismiss();
			}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
		
		// Run the section
		doSection();
	}
	
	public boolean showConfirmDialog(Context context, String content,int theme) {
		return showDoubleSelectDialog(context, content, "是", "否",-1);
		
	}

	public boolean showDoubleSelectDialog(Context context, String content,
			String sel1, String sel2,int theme) { // 选sel1返回true，sel2返回false
		if (!prepareSection()) {
			return false;
		}
		// Reset choice
		mChoice = false;
		
		AlertDialog.Builder builder;
		if (theme == -1) 
			builder = new AlertDialog.Builder(context);
		else 
			builder = new AlertDialog.Builder(context, theme);
		if (title != null && !"".equals(title))
			builder.setTitle(title);
		builder.setMessage(content);
		builder.setCancelable(false); // 这句话非常重要，设置不能取消
		builder.setPositiveButton(sel1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				SectionDialog.this.isQuitDlg = true;
				SectionDialog.this.mChoice = true;
				dialog.dismiss();
			}
		}).setNegativeButton(sel2, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				SectionDialog.this.isQuitDlg = true;
				SectionDialog.this.mChoice = false;
				dialog.cancel();
			}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
		
		doSection();
		return mChoice;

	}

}
