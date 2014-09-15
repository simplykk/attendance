package cn.edu.zime.attendanceapp.fragments;

import cn.edu.zime.attendanceapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragHistory extends Fragment {

View thisView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_history, container,false);
		return thisView;
	}
	
}
