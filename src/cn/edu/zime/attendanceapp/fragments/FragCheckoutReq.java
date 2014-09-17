package cn.edu.zime.attendanceapp.fragments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.MainTabPub;
import cn.edu.zime.domain.CommonReqUri;
import cn.edu.zime.domain.Request;
import cn.edu.zime.utils.JSONUtil;

public class FragCheckoutReq extends PubFragment implements OnClickListener {
	
	Request updateReq = new Request();

	public FragCheckoutReq() {
		super();
	}

	public FragCheckoutReq(Object container) {
		super();
		this.container = container;
	}

	CommonReqUri cru = new CommonReqUri();

	private Object container;

	View thisView;
	private Button btn_update, btn_cancel, btnBeginDate, btnBeginTime,
			btnEndDate, btnEndTime;

	private EditText edtReason;
	private Spinner spnType;

	private int curYear;
	private int curMonth;
	private int curDate;
	private int curHour;
	private int curMinute;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_updatereq, container, false);
		// 获取系统日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		curYear = calendar.get(Calendar.YEAR);// 得到系统年份
		curMonth = calendar.get(Calendar.MONTH);// 得到系统月份
		curDate = calendar.get(Calendar.DATE);// 得到系统日
		curHour = calendar.get(Calendar.HOUR);// 得到系统时
		curMinute = calendar.get(Calendar.MINUTE);// 得到系统分

		// find view by id
		btn_update = (Button) thisView.findViewById(R.id.btn_update);
		btn_cancel = (Button) thisView.findViewById(R.id.btn_cancel);
		btnBeginDate = (Button) thisView.findViewById(R.id.edtdate);
		btnBeginTime = (Button) thisView.findViewById(R.id.edttime);
		btnEndDate = (Button) thisView.findViewById(R.id.edtlastdate);
		btnEndTime  = (Button) thisView.findViewById(R.id.edtlasttimeinfo);
		edtReason =  (EditText) thisView.findViewById(R.id.edtreson);
		spnType = (Spinner) thisView.findViewById(R.id.spn_type);
		
		btn_update.setOnClickListener(this);
		btn_cancel.setOnClickListener(this);
		btnBeginDate.setOnClickListener(this);
		btnBeginTime.setOnClickListener(this);
		btnEndDate.setOnClickListener(this);
		btnEndTime.setOnClickListener(this);

		doWording();

		// ((Button) thisView.findViewById(R.id.edtdate)).setText(curYear + "-"
		// + formatTimeTwoNumber(curMonth + 1) + "-"
		// + formatTimeTwoNumber(curDate));
		// ((Button) thisView.findViewById(R.id.edttime))
		// .setText(formatTimeTwoNumber(curHour) + "-"
		// + formatTimeTwoNumber(curMinute));
		// ((Button) thisView.findViewById(R.id.edtlastdate)).setText(curYear
		// + "-" + formatTimeTwoNumber(curMonth + 1) + "-"
		// + formatTimeTwoNumber(curDate));
		// ((Button) thisView.findViewById(R.id.edtlasttimeinfo))
		// .setText(formatTimeTwoNumber(curHour) + "-"
		// + formatTimeTwoNumber(curMinute));

		

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

	// private void doWording () {
	// // if (container == null) {
	// // System.out.println("============ NULL =============");
	// // }
	// ((MainTabPub) container).subWorking(cru.getPromptServURL(), "{}");
	// }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_update:// 确定按钮的设定
			// Start();// 确定按钮的事件
//			if (updateReq == null) {
//				System.out.println("updateReq is null!");
//				return;
//			}
			updateReq.setRequestReason(edtReason.getText().toString());
			//updateReq.setRequestTime(new Date(curYear-1900,curMonth-1,curDate,curHour,curMinute));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			updateReq.setRequestTime(sdf.format(new Date()));
			try {
//				updateReq.setBeginTime(sdf.parse(btnBeginDate.getText().toString().trim()+"-"+btnBeginTime.getText().toString().trim()));
//				updateReq.setEndTime(sdf.parse(btnEndDate.getText().toString().trim()+"-"+btnEndTime.getText().toString().trim()));
				updateReq.setRequestTypeCode("D0130001");
				updateReq.setBeginTime(btnBeginDate.getText().toString().trim()+" "+btnBeginTime.getText().toString().trim()+":00");
				updateReq.setEndTime(btnEndDate.getText().toString().trim()+" "+btnEndTime.getText().toString().trim()+":00");
				((MainTabPub)container).subWorking(cru.getUpdateReqInfo(), JSONUtil.beanToJson(updateReq).toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
		Request request = new Request();

		String stuCode = ((MainTabPub) container).getUserCode();
		
		request.setStuCode(stuCode);
		request.setCheckState("0");

		try {
			((MainTabPub) container).subWorking(cru.getViewWaitCheckRecord(),
					JSONUtil.beanToJson(request).toString());
		} catch (java.lang.InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub
		System.out.println("========= FragCheckoutReq onWorkCancel ========");
		// 设置默认值
		String retStr = getHttpInfo().getRetStr();
		System.out.println("?????   this string is the fragcheckout json   :   "+retStr+"  ?????");
		
		try {
			JSONObject retEntity = new JSONObject((new JSONObject(retStr)).getString("retEntity"));
			
			if (retEntity.has("rows")) {
				
				JSONArray rows = new JSONArray(retEntity.getString("rows"));
				for (int i = 0; i < rows.length(); i++) {
					// 得到请假的记录
					JSONObject rowModel = rows.getJSONObject(i);
					System.out.println("rows["+i+"]............"+rowModel.toString());
					
					try {
						JSONUtil.jsonToBean(rowModel, updateReq);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFialed() {
		// TODO Auto-generated method stub
		System.out.println("========= FragCheckoutReq onWorkCancel ========");
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		System.out.println("========= FragCheckoutReq onWorkCancel ========");
	}

}
