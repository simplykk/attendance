package cn.edu.zime.attendanceapp.fragments;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.FragActivityBase;
import cn.edu.zime.base.domain.BaseHttpInfo;
import cn.edu.zime.domain.Student;
import cn.edu.zime.utils.JSONUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragMain extends Fragment {
	
	private TextView txvUsername,txvClass,txvTeacher,txvPhone;
	View thisView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_main, container,false);
		txvUsername = (TextView) thisView.findViewById(R.id.txv_username);
		txvClass = (TextView) thisView.findViewById(R.id.txv_class);
		txvTeacher = (TextView) thisView.findViewById(R.id.txv_tea);
		txvPhone = (TextView) thisView.findViewById(R.id.txv_phone);
		
		BaseHttpInfo httpInfo = FragActivityBase.httpInfo;
		Log.i("FragMain     ======     ", httpInfo.getRetStr());
		
		JSONObject obj;
		try {
			obj = new JSONObject(httpInfo.getRetStr());
			Log.i("Student     ======     ", obj.getString("retEntity").toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		Student student = new Student();
		try {
			JSONObject json = new JSONObject(httpInfo.getRetStr());
			JSONObject retEntity = new JSONObject(json.get("retEntity").toString());
			if (retEntity.get("stuCode") != null && !"".equals(retEntity.get("stuCode"))) {
				
			} else {
				
			}
			JSONUtil.jsonToBean(retEntity,student);
			
			Log.i("Student     ======     ", student.getStuCode());
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return thisView;
	}
	

}
