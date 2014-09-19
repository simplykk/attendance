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
		grids = new TabGrids[] { new TabGrids(R.drawable.logo_per_long, "首页"),
				new TabGrids(R.drawable.logo_teacheck_long, "审核"),
//				new TabGrids(R.drawable.logo_stuinfo_long, "学生信息"),
				new TabGrids(R.drawable.logo_history_long, "审核历史记录") };
		initFragments(container);
	}

	@Override
	protected void initFragments(Object container) {
		
		if (container == null) {
			thisFragments = new Fragment[] { new FragMain(), new FragTeaCheck(),
					 new FragHistory() };
		} else {
			System.out.println("    教师父级元素不空     ");
			thisFragments = new Fragment[] { new FragMain(container), new FragTeaCheck(container),
					 new FragHistory(container) };
		}
	}

}
