package cn.edu.zime.attendanceapp.fragments;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.FragActivityBase;
import cn.edu.zime.base.domain.BaseHttpInfo;
import cn.edu.zime.domain.Student;
import cn.edu.zime.domain.Teacher;
import cn.edu.zime.utils.JSONUtil;

public class FragMain extends PubFragment {
	public FragMain() {
		super();
	}

	public FragMain(Object container) {
		super();
		this.container = container;
	}

	private Object container;

	private TextView txvUsername, txvClass, txvSex, txvPhone;
	View thisView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_main, container, false);
		txvUsername = (TextView) thisView.findViewById(R.id.txv_username);
		txvClass = (TextView) thisView.findViewById(R.id.txv_class);
		txvSex = (TextView) thisView.findViewById(R.id.txv_sex);
		txvPhone = (TextView) thisView.findViewById(R.id.txv_phone);

		BaseHttpInfo httpInfo = FragActivityBase.httpInfo;
		//Log.i("FragMain     ======     ", httpInfo.getRetStr());

		// JSONObject obj;
		// try {
		// obj = new JSONObject(httpInfo.getRetStr());
		// Log.i("Student     ======     ",
		// obj.getString("retEntity").toString());
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }

		try {
			JSONObject json = new JSONObject(httpInfo.getRetStr());
			JSONObject retEntity = new JSONObject(json.get("retEntity")
					.toString());
			String userType = retEntity.getString("userType");
			if (userType != null && !"".equals(userType)) {
				if ("STUDENT".equals(userType)) {
					Student student = new Student();
					JSONUtil.jsonToBean(retEntity, student);

					Log.i("Student     ======     ", student.getStuCode());

					txvUsername.setText(student.getStuName());
					txvPhone.setText(student.getPhone());
					// txvClass.setText(String.valueOf(student.getClassId()));
					txvSex.setText(student.getSex());

				} else if ("TEACHER".equals(userType)) {
					Teacher teacher = new Teacher();
					JSONUtil.jsonToBean(retEntity, teacher);

					txvUsername.setText(teacher.getTeaName());
					txvPhone.setText(teacher.getPhone());
					// txvClass.setText(String.valueOf(student.getClassId()));
					txvSex.setText(teacher.getSex());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
