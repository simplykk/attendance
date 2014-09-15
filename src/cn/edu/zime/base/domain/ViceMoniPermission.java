package cn.edu.zime.base.domain;

import java.io.Serializable;

import android.support.v4.app.Fragment;

import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.attendanceapp.fragments.FragCheckoutReq;
import cn.edu.zime.attendanceapp.fragments.FragHistory;
import cn.edu.zime.attendanceapp.fragments.FragMain;
import cn.edu.zime.attendanceapp.fragments.FragMonitorConfirm;
import cn.edu.zime.attendanceapp.fragments.FragRequest;

public class ViceMoniPermission extends UserPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5222666136542064497L;
	
	public ViceMoniPermission () {
		initGrids();
	}

	@Override
	protected void initGrids() {
		grids = new TabGrids[] { new TabGrids(R.drawable.ic_launcher, "首页"),
				new TabGrids(R.drawable.ic_launcher, "请假"),
				new TabGrids(R.drawable.ic_launcher, "待审核信息"),
				new TabGrids(R.drawable.ic_launcher, "确认信息"),
				new TabGrids(R.drawable.ic_launcher, "历史记录") };
		initFragments();
	}

	@Override
	protected void initFragments() {
		thisFragments = new Fragment[]{
				new FragMain(),
				new FragRequest(),
				new FragCheckoutReq(),
				new FragMonitorConfirm(),
				new FragHistory()
		};
		
	}

}