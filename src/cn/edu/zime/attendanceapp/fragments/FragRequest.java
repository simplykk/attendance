package cn.edu.zime.attendanceapp.fragments;

import java.util.Calendar;

import cn.edu.zime.attendanceapp.R;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class FragRequest extends PubFragment implements OnClickListener {
	public FragRequest() {
		super();
	}

	public FragRequest(Object container) {
		super();
		this.container = container;
	}

	private Object container;
	View thisView;

	private Button btn_ok, btn_cancel;

	private int curYear;
	private int curMonth;
	private int curDate;
	private int curHour;
	private int curMinute;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_request, container, false);

		// 获取系统日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		curYear = calendar.get(Calendar.YEAR);// 得到系统年份
		curMonth = calendar.get(Calendar.MONTH);// 得到系统月份
		curDate = calendar.get(Calendar.DATE);// 得到系统日
		curHour = calendar.get(Calendar.HOUR);// 得到系统时
		curMinute = calendar.get(Calendar.MINUTE);// 得到系统分

		// 设置默认值
		((Button) thisView.findViewById(R.id.edtdate)).setText(curYear + "-"
				+ formatTimeTwoNumber(curMonth + 1) + "-"
				+ formatTimeTwoNumber(curDate));
		((Button) thisView.findViewById(R.id.edttime))
				.setText(formatTimeTwoNumber(curHour) + "-"
						+ formatTimeTwoNumber(curMinute));
		((Button) thisView.findViewById(R.id.edtlastdate)).setText(curYear
				+ "-" + formatTimeTwoNumber(curMonth + 1) + "-"
				+ formatTimeTwoNumber(curDate));
		((Button) thisView.findViewById(R.id.edtlasttimeinfo))
				.setText(formatTimeTwoNumber(curHour) + "-"
						+ formatTimeTwoNumber(curMinute));

		((Button) thisView.findViewById(R.id.btn_ok)).setOnClickListener(this);
		((Button) thisView.findViewById(R.id.btn_cancel))
				.setOnClickListener(this);
		((Button) thisView.findViewById(R.id.edtdate)).setOnClickListener(this);
		((Button) thisView.findViewById(R.id.edttime)).setOnClickListener(this);
		((Button) thisView.findViewById(R.id.edtlastdate))
				.setOnClickListener(this);
		((Button) thisView.findViewById(R.id.edtlasttimeinfo))
				.setOnClickListener(this);

		return thisView;
	}

	private static String formatTimeTwoNumber(int i) {
		// TODO Auto-generated method stub

		String string = Integer.toString(i);
		if (string.length() == 1) {
			string = "0" + string;
		}
		return string;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_ok:// 确定按钮的设定
			// Start();// 确定按钮的事件
			break;
		case R.id.btn_cancel:// 取消按钮的设定
			// Intent intent = new Intent();
			// if (APPData.flag == 1) {
			// if (APPData.stutype == 1) {
			// intent.setClass(RequestInfo.this, User_monitor.class);
			// } else {
			// intent.setClass(RequestInfo.this, User_stu.class);
			// }
			// }
			// startActivity(intent);
			break;
		case R.id.edtdate:// 起始设置日期
			DatePickerDialog beginDateDlg = new DatePickerDialog(getActivity(),
					new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							// TODO Auto-generated method stub
							// 返回选择的值
							((Button) thisView.findViewById(R.id.edtdate))
									.setText(year
											+ "-"
											+ formatTimeTwoNumber(monthOfYear + 1)
											+ "-"
											+ formatTimeTwoNumber(dayOfMonth));
						}
					}, curYear, curMonth, curDate);
			beginDateDlg.setTitle("设置起始日期");
			beginDateDlg.show();
			break;
		case R.id.edttime:// 起始设置时间
			// edttime.setText("");
			TimePickerDialog beginTimeDlg = new TimePickerDialog(getActivity(),
					new TimePickerDialog.OnTimeSetListener() {
						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							// TODO Auto-generated method stub
							((Button) thisView.findViewById(R.id.edttime))
									.setText(formatTimeTwoNumber(hourOfDay)
											+ ":" + formatTimeTwoNumber(minute));
						}
					}, curHour, curMinute, true);
			beginTimeDlg.setTitle("设置起始时间");
			beginTimeDlg.show();
			break;
		case R.id.edtlastdate: // 终止设置日期
			DatePickerDialog endDateDlg = new DatePickerDialog(getActivity(),
					new DatePickerDialog.OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							// TODO Auto-generated method stub
							// 返回选择的值
							((Button) thisView.findViewById(R.id.edtlastdate))
									.setText(year
											+ "-"
											+ formatTimeTwoNumber(monthOfYear + 1)
											+ "-"
											+ formatTimeTwoNumber(dayOfMonth));
						}
					}, curYear, curMonth, curDate);
			endDateDlg.setTitle("设置结束日期");
			endDateDlg.show();
			break;
		case R.id.edtlasttimeinfo:// 终止设置时间
			TimePickerDialog endTimeDlg = new TimePickerDialog(getActivity(),
					new TimePickerDialog.OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							// TODO Auto-generated method stub
							((Button) thisView
									.findViewById(R.id.edtlasttimeinfo))
									.setText(formatTimeTwoNumber(hourOfDay)
											+ ":" + formatTimeTwoNumber(minute));
						}
					}, curHour, curMinute, true);
			endTimeDlg.setTitle("设置结束时间");
			endTimeDlg.show();
			break;
		default:
			break;
		}
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
