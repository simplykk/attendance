package cn.edu.zime.base.activity;

import java.net.SocketException;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.attendanceapp.fragments.PubFragment;
import cn.edu.zime.base.domain.BaseHttpInfo;
import cn.edu.zime.base.domain.ComStuPermission;
import cn.edu.zime.base.domain.TeaPermission;
import cn.edu.zime.base.domain.UserPermission;
import cn.edu.zime.base.domain.ViceMoniPermission;
import cn.edu.zime.utils.HttpUtil;

/**
 * 该类只负责载入各个子页面和进行一些页面切换操作，不涉及任何网络数据访问即本地数据库操作。
 * 
 * @author Geekii
 * 
 */
public class MainTabPub extends FragActivityBase {

	public UserPermission uPermiss;
	private int curFrag = -1;
	
	private String userCode;
	private String transactorId;
	
	
	
	
	
	public String getTransactorId() {
		return transactorId;
	}

	public void setTransactorId(String transactorId) {
		this.transactorId = transactorId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	private PubFragment thisFrag;
	
	

	private void switchFragment(int index) {
		Fragment fragment = uPermiss.getThisFragments()[index];
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.tab_container, fragment).commit();
		thisFrag  = (PubFragment) fragment;
	}

	private void initGridViews() {

		GridView grid = (GridView) this.findViewById(R.id.tab_grid);
		grid.setNumColumns(uPermiss.getGrids().length);
		
		Intent it = getIntent();
		FragActivityBase.httpInfo = (BaseHttpInfo) it.getSerializableExtra("httpInfo");
		//userCode = (String) it.getSerializableExtra("userCode");
		userCode = "120311120101";
		transactorId = "34570001";
		
		//=== 需要自定义文字选这个
		// SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
		// uPermiss.getMaps(), R.layout.tab_grid, new String[] {
		// "displayTxt", "bkImg" }, new int[] { R.id.display_txt,
		// R.id.bk_img });
		
		//=== 不需要自定义文字选这个
		SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
				uPermiss.getMapsWithoutTxt(), R.layout.tab_grid,
				new String[] { "bkImg" }, new int[] { R.id.bk_img });
		
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setTitle(uPermiss.getGrids()[position].getDisplayTxt());
				switchFragment(position);
			}
		});

		if (curFrag == -1) {
			setTitle(uPermiss.getGrids()[0].getDisplayTxt());
			getSupportFragmentManager().beginTransaction()
					.add(R.id.tab_container, uPermiss.getThisFragments()[0])
					.commit();

		}
	}

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main_tab_pub);

		// 初始化操作＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		//uPermiss = new ComStuPermission(this);
//		uPermiss = new TeaPermission(this);
		//uPermiss = new ViceMoniPermission(this);
		if (userCode != null) {
			if (userCode.length() == 12) {
				uPermiss = new ComStuPermission(this);
			} else if (userCode.length() == 8){
				uPermiss = new TeaPermission(this);
			}
		} else {
			uPermiss = new ComStuPermission(this);
		}
		
		
		initGridViews();

		try {
			promptRemoteServIPChanged(userCode,HttpUtil.getLocalIP(getApplicationContext()),"");
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void subWorking (String uri,String sendJSONStr) {
		System.out.println("sub working...");
		this.doWorking(uri, sendJSONStr);
	}

	@Override
	public void onWorkCancel() {
		// TODO Auto-generated method stub
		System.out.println("========= MainTabPub onWorkCancel ========");
		thisFrag.setHttpInfo(httpInfo);
		thisFrag.onCancel();
	}

	@Override
	public void onWorkCompleted() {
		// TODO Auto-generated method stub
		System.out.println("========= MainTabPub onWorkCompleted ========");
		thisFrag.setHttpInfo(httpInfo);
		thisFrag.onCompleted();
	}

	@Override
	public void OnWorkFailed() {
		// TODO Auto-generated method stub
		System.out.println("========= MainTabPub onWorkFailed ========");
		thisFrag.setHttpInfo(httpInfo);
		thisFrag.onFialed();
	}

}
