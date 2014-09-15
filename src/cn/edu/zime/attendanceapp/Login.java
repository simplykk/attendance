package cn.edu.zime.attendanceapp;

import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.ActivityBase;
import cn.edu.zime.base.activity.MainTabPub;
import cn.edu.zime.constant.Constant;
import cn.edu.zime.utils.HttpUtil;
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

	private SharedPreferences sp;
	private EditText edtUserName, edtPassword;
	// private Button exit;
	private ImageButton imgBtn_login;
	// private CheckBox rememberMe;

	private String TAG = "Login";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		sp = getSharedPreferences(Constant.SHARED_NAME, 0);
		// ========= find view by id =============
		edtUserName = (EditText) findViewById(R.id.edt_username);
		edtPassword = (EditText) findViewById(R.id.edt_password);
		// rememberMe = (CheckBox)findViewById(R.id.rememberpasswordCheckBox);
		imgBtn_login = (ImageButton) findViewById(R.id.btn_login);
		// exit =(Button)findViewById(R.id.registerButton);

		imgBtn_login.setOnClickListener(this);
		// exit.setOnClickListener(this);
		loadConfig();

		promptRemoteServIPChanged("");
	}

	private String rememberMeStr = "rememberMe";

	private void saveConfig() {
		Map<String, String> map = new HashMap<String, String>();
		// map.put(rememberMeStr, rememberMe.isChecked()?"true":"false");
		map.put("USERNAME", edtUserName.getText().toString().trim());
		// map.put("passWord", passwordEditText.getText().toString().trim());
		try {
			String curIP = HttpUtil.getLocalIP(getApplicationContext());
			Log.i(TAG, "===========   curIP   ===========" + curIP);
			map.put("CURRENT_IP", curIP);
		} catch (SocketException e) {
			e.printStackTrace();
		}

		// map.put("currentIP",Constant.currentIP);
		SharedUtil.saveData(sp, map);
	}

	private void loadConfig() {
		// Map<String, String> map = SharedUtil.getData(sp, new
		// String[]{rememberMeStr,"USERNAME","passWord","currentIP"});
		Map<String, String> map = SharedUtil.getData(sp, new String[] {
				"USERNAME", "CURRENT_IP" });
		// if("true".equals(map.get(rememberMeStr))){
		edtUserName.setText(map.get("USERNAME"));
		// passwordEditText.setText(map.get("passWord"));
		// }
		// Constant.currentIP = map.get("currentIP");
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
			imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.button_login_en));// 避免用户重复点击

			saveConfig();

			// 构造json数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("USERNAME", edtUserName.getText().toString().trim());
			//map.put("passWord", passwordEditText.getText().toString().trim());
			try {
				map.put("CURRENT_IP", HttpUtil.getLocalIP(Login.this));
			} catch (SocketException e) {
				e.printStackTrace();
			}
			//String uri = cru.getLoginReq();

			System.out.println("do working in login.......................");
			// doWorking(uri,"{hello:'hello'}");
			//imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
			//		R.drawable.button_login_zh));
			startActivity(new Intent(getApplicationContext(), MainTabPub.class));
			break;
		default:
			break;
		}
	}

	@Override
	public void onWorkCancel() {
		Log.i(TAG, "===========  Login Cencel  ===========");
		//login.setClickable(true);
	}

	@Override
	public void onWorkCompleted() {
		Log.i(TAG, "===========  Login Success  ===========");
		Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG)
				.show();
		imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.button_login_zh));
		startActivity(new Intent(getApplicationContext(), MainTabPub.class));
	}

	@Override
	public void OnWorkFailed() {
		Log.i(TAG, "===========  Login Failed  ===========");
		Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG)
				.show();
		imgBtn_login.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.button_login_zh));
		//startActivity(new Intent(getApplicationContext(), MainTabPub.class));
	}

}
