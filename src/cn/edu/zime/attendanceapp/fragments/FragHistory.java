package cn.edu.zime.attendanceapp.fragments;

import cn.edu.zime.attendanceapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragHistory extends PubFragment {
	public FragHistory() {
		super();
	}

	public FragHistory(Object container) {
		super();
		this.container = container;
	}
	
	private Object container;

	View thisView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_history, container, false);
		return thisView;
	}

	@Override
	protected void doWording() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFialed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

}
