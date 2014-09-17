package cn.edu.zime.base.domain;

import java.io.Serializable;

import android.support.v4.app.Fragment;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.attendanceapp.fragments.FragCheckoutReq;
import cn.edu.zime.attendanceapp.fragments.FragHistory;
import cn.edu.zime.attendanceapp.fragments.FragMain;
import cn.edu.zime.attendanceapp.fragments.FragRequest;

public class ComStuPermission extends UserPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996450954215172876L;

	public ComStuPermission() {
		initGrids();
	}

	public ComStuPermission(Object container) {
		this.container = container;
		initGrids();
	}

	@Override
	protected void initGrids() {
		grids = new TabGrids[] { new TabGrids(R.drawable.logo_per_long, "首页"),
				new TabGrids(R.drawable.logo_request_long, "请假"),
				new TabGrids(R.drawable.logo_updatereq_long, "更改请假"),
				new TabGrids(R.drawable.logo_history_long, "历史记录") };
		initFragments(container);
	}

	@Override
	protected void initFragments(Object container) {
		
		if (container == null) {
			System.out.println("========= NULL ==========");
			thisFragments = new Fragment[] { new FragMain(), new FragRequest(),
					new FragCheckoutReq(), new FragHistory() };
		} else {
			thisFragments = new Fragment[] { new FragMain(container), new FragRequest(container),
					new FragCheckoutReq(container), new FragHistory(container) };
		}
	}
}
