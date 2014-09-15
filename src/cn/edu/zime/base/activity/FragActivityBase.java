package cn.edu.zime.base.activity;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.zime.base.domain.BaseDlgMsg;
import cn.edu.zime.base.domain.BaseHttpInfo;
import cn.edu.zime.domain.CommonReqUri;
import cn.edu.zime.utils.HttpUtil;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public abstract class FragActivityBase extends FragmentActivity {

	private static final int WORKCOMPLETED = 1;// 执行正常结束
	private static final int WAITCANCEL = 2; // 取消
	private static final int WORKFAILED = 3; // 执行网络请求失败
	
	protected CommonReqUri cru = new CommonReqUri();
	

	private boolean isWorking = false;
	private boolean isReStart = false;
	public ProgressDialog pd; //
	public BaseHandler handler = new BaseHandler();
	private BaseHttpInfo httpInfo;
	private BaseDlgMsg dlgMsg;
	public Thread myThread = null; // 长时间处理线程

	protected Context context = null;

	protected Object[][] picSrc = null; // 加到到列表中的图片资源
	
	/**
	 * 取消执行工作，由子类实现
	 */
	public abstract void onWorkCancel();

	/**
	 * 执行工作成功时，由子类实现
	 */
	public abstract void onWorkCompleted();

	/**
	 * 工作执行失败中止，由子类实现
	 */
	public abstract void OnWorkFailed();
	
	//================ 类方法  =================

	// 一些实例化工作也在这里执行
	private void prepareWorking(String uri,String sendData) {
		httpInfo = new BaseHttpInfo();
		dlgMsg = new BaseDlgMsg();
		
		isWorking = true;
		
		httpInfo.setSendJSONStr(sendData);
		httpInfo.setUri(uri);
	}

	private void sendCancelMsg() {
		Message msg = new Message();
		msg.what = WAITCANCEL;
		handler.sendMessage(msg);
	}

	/**
	 * 工作执行成功完成
	 * @throws JSONException 
	 */
	private void finishWork() throws JSONException {
		String retStr = httpInfo.getRetStr();
		if (retStr == null || "".equals(retStr)) {
			this.OnWorkFailed();
			return;
		}

		if ("JSON".equals(httpInfo.getDataType())) {
			JSONObject jObj = new JSONObject(retStr);

			String reqRetCode = jObj.getString("reqRetCode");

			if ("SUCCESS".equals(reqRetCode)) {
				this.onWorkCompleted();
				return;
			}

			if (reqRetCode == null || "".equals(reqRetCode)) {
				httpInfo.setLastErrorStr("返回数据格式有误！");
			} else if ("FAILED".equals(reqRetCode)) {
				httpInfo.setLastErrorStr("请求数据失败！请稍后重试...");
			} else if ("TIMEOUT".equals(reqRetCode)) {
				httpInfo.setLastErrorStr("请求超时!请检查网络或重试...");
			} else if ("SERVER_REFUSE".equals(reqRetCode)) {
				httpInfo.setLastErrorStr("服务器拒绝服务!请重启应用程序或重试!");
			} else if ("LOST_PERMISSION".equals(reqRetCode)) {
				httpInfo.setLastErrorStr("权限不足或未登录！");
			}

			this.OnWorkFailed();

		}
	}
	
	private void reStart(){
		isReStart = false;
		doWorking(httpInfo.getUri(),httpInfo.getSendJSONStr());
	}
	
	@SuppressLint("HandlerLeak") class BaseHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (isWorking != true) // 防止工作取消后,线程中再次发送完成或失败消息
				return;
			// myBar.setVisibility(View.GONE);
			switch (msg.what) {
			case WAITCANCEL: // 取消等待,要强制结束线程
				Log.i("WAITPROGRESS",
						"----------------WAITCANCEL-----------------");
				if (myThread != null)
					if (myThread.isAlive()) {
						myThread.interrupt();
						myThread = null;
					}
				onWorkCancel();
				break;
			case WORKCOMPLETED: // 线程函数执行成功,自动结束
				// 刷新UI，显示数据，并关闭进度条
				Log.i("WAITPROGRESS",
						"----------------WORKCOMPLETED-----------------");
				if (pd != null)
					pd.dismiss(); // 关闭进度条
				try {
					finishWork();
				} catch (JSONException e) {
					e.printStackTrace();
					httpInfo.setLastErrorStr("处理数据时出错!");
					OnWorkFailed();
					
				}
				break;
			case WORKFAILED: // 线程函数执行失败,自动结束
				// 刷新UI，显示数据，并关闭进度条
				Log.i("WAITPROGRESS",
						"----------------WORKFAILED-----------------");
				if (pd != null)
					pd.dismiss(); // 关闭进度条
				OnWorkFailed();
				break;
			}
			myThread = null;
			isWorking = false;
			if (isReStart) {
				reStart();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this.getParent(); // 因为子活动中,ProgressDialog.show会出异常,所以要传入其父类
		if (context == null) // 取父窗口,当父窗口关闭时,会有问题. 所以,要么就取框架类对象
			context = this;

	}

	@Override
	public void onBackPressed() { // 当用户点击回退按钮时
		if (isWorking)
			sendCancelMsg();
		else
			super.onBackPressed();
	}

	// ===================== 下面的方法由子类调用 =============================
	
	/**
	 * 执行工作,此工作可能需要较长时间,在线程中执行,并在执行时,有等待提示
	 * @param uri 请求的uri
	 * @param sendJSONStr  向服务器发送的JSON字符串
	 */
	protected void doWorking(String uri,String sendJSONStr) {
		prepareWorking(uri,sendJSONStr);
		
		myThread = new Thread() {
			@Override
			public void run() {
				Message msg = new Message();
				try {
					//1. 弹出对话框
					
					//2. 执行工作
					String sendData = httpInfo.getSendJSONStr();
					String retStr = HttpUtil.postReqAsJson(httpInfo.getUri(),sendData);
					if (retStr.endsWith("ERROR")) 
						msg.what = WORKFAILED;
					else {
						msg.what = WORKCOMPLETED;
						httpInfo.setRetStr(retStr);
					}
				} catch (Exception e) {
					// 显示gui数据
					// tv.setText("Error: " + e.getMessage());
					e.printStackTrace();
					httpInfo.setLastErrorStr(dlgMsg.getPromptWait() + "出现异常错误!");
					msg.what = WORKFAILED;
				}
				handler.sendMessage(msg);
			}
		};
		myThread.start();

	}
	
	/**
	 * 有以下几种情况必定会调用此方法，通知远程服务器本地IP发生变化:
	 * <ul>
	 *  <li>进入应用程序时</li>
	 *  <li>网络中断初始恢复时（即网络状态发生改变时）</li>
	 *  <li>本地IP地址发生变化时</li>
	 * </ul>
	 * @param uri 请求的远程服务器URI
	 * @param jsonStr 发送请求的JSON字符串
	 */
	public void promptRemoteServIPChanged(String jsonStr){
		(new AsyncTask<String, Object, String>(){

			@Override
			protected String doInBackground(String... params) {
				try {
					System.out.println("promptRemoteServIPChanged.........");
					String retStr = HttpUtil.postReqAsJson(cru.getPromptServURL(), params[0]);
					System.out.println("prompt successed ........");
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
			}
			
		}).execute(jsonStr);
	}

	// show dialog =================== 交由子类调用 =====================
	protected void showPromptDlg(String msg) {
		if (this.isFinishing())
			return;
		// ShowAlertDlg("", msg);
		SectionDialog dlg = new SectionDialog();
		dlg.showAlertDialog(context, msg,-1);
	}

	protected void showPromptDlg(String title, String msg) {
		if (this.isFinishing())
			return;
		// ShowAlertDlg(title, msg);
		SectionDialog dlg = new SectionDialog(title);
		dlg.showAlertDialog(context, msg,-1);
	}

	protected void showCloseActDlg(String msg, Activity actClosed) {
		showPromptDlg(msg);
		if (actClosed != null)
			actClosed.finish();
	}

	protected void showRestartDlg(String msg, Activity actClosed, boolean bRestart) {
		if (bRestart) {
			SectionDialog dlg = new SectionDialog();
			if (dlg.showDoubleSelectDialog(context, msg, "重新执行", "取消",-1))
				isReStart = true;
			else if (actClosed != null)
				actClosed.finish();
		} else
			showCloseActDlg(msg, actClosed);
	}

	protected void showAlertDlg(String title, String msg) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		if (title != null && title.length() > 0)
			dialog.setTitle(title);
		dialog.setMessage(msg);
		dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 点击确认后的操作
			}
		}).create().show();
	}
}
