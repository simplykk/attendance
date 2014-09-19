package cn.edu.zime.attendanceapp.fragments;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.MainTabPub;
import cn.edu.zime.domain.CommonReqUri;
import cn.edu.zime.domain.Request;
import cn.edu.zime.utils.JSONUtil;

public class FragTeaCheck extends PubFragment {
	public FragTeaCheck() {
		super();
	}

	public FragTeaCheck(Object container) {
		super();
		this.container = container;
	}

	View thisView;
	private CommonReqUri cru = new CommonReqUri();
	private List<Request> reqs = new ArrayList<Request>();
	private Object container;

	private ListView listView;

	private TextView txv_stuName, txv_beginTime, txv_endTime, txv_reason;

	private List<Map<String, String>> list = new ArrayList<Map<String, String>>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		thisView = inflater.inflate(R.layout.frag_teacheck, container, false);

		isFirst = true;
		checking = false;
		curChecking = -1;
		list.clear();

		listView = (ListView) thisView.findViewById(R.id.list_teacheckout);
		// txv_stuName = (TextView) thisView.findViewById(R.id.txv_stuName);
		// txv_beginTime = (TextView) thisView.findViewById(R.id.txv_beginTime);
		// txv_endTime = (TextView) thisView.findViewById(R.id.txv_endTime);
		// txv_reason = (TextView) thisView.findViewById(R.id.txv_reason);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("提示");
				builder.setMessage("请选择您对该学生请假意见");
				final Request curReq = reqs.get(position);
				curChecking = position;
				builder.setNegativeButton("同意", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						curReq.setCheckState("1");

						checkout(curReq);
					}
				}).setPositiveButton("不同意", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						curReq.setCheckState("2");
						checkout(curReq);
					}
				});
				AlertDialog dlg = builder.create();
				dlg.show();
			}
		});

		doWording();

		return thisView;
	}

	private boolean checking = false;
	private int curChecking = -1;

	private void checkout(Request req) {
		try {
			checking = true;
			((MainTabPub) container).subWorking(cru.getCheckReq(), JSONUtil
					.beanToJson(req).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addList() {
		// for (Request req : reqs) {
		//
		// }
		try {
			JSONObject json = new JSONObject(getHttpInfo().getRetStr());

			JSONObject retEntity = new JSONObject(json.get("retEntity")
					.toString());

			if (retEntity.has("rows")) {
				JSONArray rows = new JSONArray(retEntity.get("rows").toString());

				for (int i = 0; i < rows.length(); i++) {
					Map<String, String> map = new HashMap<String, String>();

					Request request = new Request();
					JSONUtil.jsonToBean(rows.getJSONObject(i), request);

					map.put("stuName", "学生姓名： " + request.getStuCode());
					map.put("beginTime",
							"请假开始时间： "
									+ new Date(Long.valueOf(request
											.getBeginTime())).toLocaleString());
					map.put("endTime",
							"请假结束时间： "
									+ new Date(Long.valueOf(request
											.getEndTime())).toLocaleString());
					map.put("reason", "请假原因： " + request.getRequestReason());
					list.add(map);
					reqs.add(request);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doWording() {
		// TODO Auto-generated method stub
		Request request = new Request();
		request.setCheckState("0");
		String transactorId = ((MainTabPub) container).getUserCode();
		request.setTransactorId(transactorId);

		try {
			((MainTabPub) container).subWorking(cru.getViewWaitCheckRecord(),
					JSONUtil.beanToJson(request).toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isFirst = true;
	SimpleAdapter adapter;

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub

		if (checking) {
			list.remove(curChecking);
			curChecking = -1;
			adapter.notifyDataSetChanged();
			checking = false;
		}

		if (isFirst) {
			addList();

			adapter = new SimpleAdapter(getActivity(), list,
					R.layout.tea_items, new String[] { "stuName", "beginTime",
				"endTime", "reason" }, new int[] { R.id.txv_stuName,
				R.id.txv_beginTime, R.id.txv_endTime, R.id.txv_reason });
			listView.setAdapter(adapter);
			isFirst = false;
		}
	}

	@Override
	public void onFialed() {
		// TODO Auto-generated method stub

		// if (isFirst) {
		// addList();
		//
		// SimpleAdapter adapter = new SimpleAdapter(getActivity(), list,
		// R.layout.tea_items, new String[] { "stuName", "beginTime",
		// "endTime", "reason" }, new int[] {
		// R.id.txv_stuName, R.id.txv_beginTime,
		// R.id.txv_endTime, R.id.txv_reason });
		// listView.setAdapter(adapter);
		// isFirst = false;
		// }

	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub

	}
}
