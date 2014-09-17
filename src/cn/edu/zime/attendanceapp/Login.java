package cn.edu.zime.attendanceapp;

import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.ActivityBase;
import cn.edu.zime.base.activity.MainTabPub;
import cn.edu.zime.constant.Constant;
import cn.edu.zime.domain.AuthUser;
import cn.edu.zime.utils.HttpUtil;
import cn.edu.zime.utils.JSONUtil;
import cn.edu.zime.utils.SharedUtil;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends ActivityBase implements OnClickListener {

//	private SharedPreferences sp;
	private EditText edtUserName, edtPassword;
	private ImageButton imgBtn_login;

	private String TAG = "Login";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
//		sp = getSharedPreferences(Constant.SHARED_NAME, 0);
		// ========= find view by id =============
		edtUserName = (EditText) findViewById(R.id.edt_username);
		edtPassword = (EditText) findViewById(R.id.edt_password);
		imgBtn_login = (ImageButton) findViewById(R.id.btn_login);

		imgBtn_login.setOnClickListener(this);

		loadConfig();

		
//		promptRemoteServIPChanged();
	}


	private void saveConfig() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("USERNAME", edtUserName.getText().toString().trim());
		try {
			String curIP = HttpUtil.getLocalIP(getApplicationContext());
			Log.i(TAG, "===========   curIP   ===========" + curIP);
			map.put("CUR_IP", curIP);
		} catch (SocketException e) {
			e.printStackTrace();
		}

		SharedUtil.saveData(sp, map);
	}

	private void loadConfig() {
		Map<String, String> map = SharedUtil.getData(sp, new String[] {
				"USERNAME", "CURRENT_IP","REMOTE_HOST" });
		
		edtUserName.setText(map.get("USERNAME"));
		Constant.CUR_IP = map.get("CUR_IP");
		//Constant.REMOTE_HOST = map.get("REMOTE_HOST"); // 根据设定的IP
		Constant.REMOTE_HOST = "http://192.168.1.104:8080";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			imgBtn_login.setImageDrawable(getResources().getDrawable(R.drawable.bk_button_login));// 避免用户重复点击

			saveConfig();

			// 构造json数据
			AuthUser user = new AuthUser();
			user.setUserCode(edtUserName.getText().toString());
			user.setPassWord(edtPassword.getText().toString());
			
			if (edtUserName.getText().toString().trim().length() == 12) {
				user.setUserType("STUDENT");
			} else if (edtUserName.getText().toString().trim().length() == 8) {
				user.setUserType("TEACHER");
			}
			
			try {
				JSONObject json = JSONUtil.beanToJson(user);
				
				String uri = cru.getLoginReq();

				System.out.println("do working in login......................."+json.toString());
				//doWorking(uri,json.toString());
				startActivity(new Intent(getApplicationContext(), MainTabPub.class));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			break;
		default:
			break;
		}
	}

	@Override
	public void onWorkCancel() {
		Log.i(TAG, "===========  Login Cencel  ===========");
		// login.setClickable(true);
	}

	@Override
	public void onWorkCompleted() {
		Log.i(TAG, "===========  Login Success  ===========");
		Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG)
				.show();
		imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.button_login_zh));
		Intent intent = new Intent(getApplicationContext(), MainTabPub.class);
		intent.putExtra("httpInfo", httpInfo);
		intent.putExtra("userCode", edtUserName.getText().toString());
		startActivity(intent);
	}

	@Override
	public void OnWorkFailed() {
		Log.i(TAG, "===========  Login Failed  ===========");
		Toast.makeText(getApplicationContext(), httpInfo.getLastErrorStr(), Toast.LENGTH_LONG)
				.show();
		imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.button_login_zh));
	}

}
