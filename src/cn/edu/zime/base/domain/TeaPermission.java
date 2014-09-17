package cn.edu.zime.base.domain;

import java.io.Serializable;

import android.support.v4.app.Fragment;

import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.attendanceapp.fragments.FragCheckoutReq;
import cn.edu.zime.attendanceapp.fragments.FragHistory;
import cn.edu.zime.attendanceapp.fragments.FragMain;
import cn.edu.zime.attendanceapp.fragments.FragRequest;
import cn.edu.zime.attendanceapp.fragments.FragTeaCheck;

public class TeaPermission extends UserPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7882955613618631862L;
	
	public TeaPermission () {
		initGrids();
	}
	
	public TeaPermission (Object container) {
		this.container = container;
		initGrids();
	}

	@Override
	protected void initGrids() {
		grids = new TabGrids[] { new TabGrids(R.drawable.ic_launcher, "首页"),
				new TabGrids(R.drawable.ic_launcher, "审核"),
				new TabGrids(R.drawable.ic_launcher, "待审核信息"),
				new TabGrids(R.drawable.ic_launcher, "审核历史记录") };
		initFragments(container);
	}

	@Override
	protected void initFragments(Object container) {
		
		if (container == null) {
			thisFragments = new Fragment[] { new FragMain(), new FragTeaCheck(),
					new FragCheckoutReq(), new FragHistory() };
		} else {
			thisFragments = new Fragment[] { new FragMain(container), new FragTeaCheck(container),
					new FragCheckoutReq(container), new FragHistory(container) };
		}
	}

}
