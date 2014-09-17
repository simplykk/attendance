package cn.edu.zime.attendanceapp.fragments;

import cn.edu.zime.base.domain.BaseHttpInfo;
import android.support.v4.app.Fragment;

public abstract class PubFragment extends Fragment {
	
	private BaseHttpInfo httpInfo;
	
	
	
	public BaseHttpInfo getHttpInfo() {
		return httpInfo;
	}
	public void setHttpInfo(BaseHttpInfo httpInfo) {
		this.httpInfo = httpInfo;
	}
	protected abstract void doWording();
	public abstract void onCompleted();
	public abstract void onFialed();
	public abstract void onCancel();

}
