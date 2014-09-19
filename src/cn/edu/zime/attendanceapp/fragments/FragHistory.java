package cn.edu.zime.attendanceapp.fragments;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import cn.edu.zime.attendanceapp.R;
import cn.edu.zime.base.activity.MainTabPub;
import cn.edu.zime.domain.CommonReqUri;
import cn.edu.zime.domain.Request;
import cn.edu.zime.utils.JSONUtil;

public class FragHistory extends PubFragment implements OnScrollListener {

	private SimpleAdapter adapter;// Adapter
	private ListView list_history;
	private Button bt;
	private ProgressBar pb;
	private List<Map<String, String>> list = new ArrayList<Map<String,String>>();

	// the view of listview's bottom
	private View moreView;
	private Handler handler;

	// Setting the max data counts
	private int maxDataNum = 1000;

	private List<Request> resultReqs = new ArrayList<Request>();

	private int lastVisibleIndex;// The last record index

	public FragHistory() {
		super();
	}

	public FragHistory(Object container) {
		super();
		this.container = container;
	}

	CommonReqUri cru = new CommonReqUri();

	private Object container;

	View thisView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		thisView = inflater.inflate(R.layout.frag_history, container, false);

		list_history = (ListView) thisView.findViewById(R.id.list_history);
		resultReqs.clear();
		list.clear();
		curPage = 1;
		isAdapted = false;

		// Initialize the bottom layout
		moreView = getActivity().getLayoutInflater().inflate(
				R.layout.more_data, null);

		bt = (Button) moreView.findViewById(R.id.bt_load);
		pb = (ProgressBar) moreView.findViewById(R.id.pb);

		handler = new Handler();

		// Use the map to package data , initialize 10 pice of record
//		list = getList();

		// // Initialize the adapter
		// adapter = new SimpleAdapter(getActivity(), list,
		// R.layout.history_item,
		// new String[] { "stuCode", "beginTime", "endTime", "reqType",
		// "reason", "result" }, new int[] { R.id.txv_Code,
		// R.id.txv_beginTime, R.id.txv_endTime, R.id.txv_reqType,
		// R.id.txv_reason, R.id.txv_result });

		// 加上底部View，注意要放在setAdapter方法前
		list_history.addFooterView(moreView);
		// list_history.setAdapter(adapter);

		list_history.setOnScrollListener(this);

		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pb.setVisibility(View.VISIBLE);// 将进度条可见
				bt.setVisibility(View.GONE);// 按钮不可见

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						//loadMoreDate();// 加载更多数据
						// bt.setVisibility(View.VISIBLE);
						// pb.setVisibility(View.GONE);
						// adapter.notifyDataSetChanged();// 通知listView刷新数据
						doWording();
					}

				}, 0);
			}
		});

		doWording();

		return thisView;
	}

	private void addList() {
		//List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Request resultReq : resultReqs) {
			Map<String, String> map = new HashMap<String, String>();
			// map.put("ItemTitle", "第" + (i + 1) + "行标题");
			// map.put("ItemText", "第" + (i + 1) + "行内容");
			resultReq.setBeginTime(new Date(Long.valueOf(resultReq.getBeginTime())).toLocaleString());
			resultReq.setEndTime(new Date(Long.valueOf(resultReq.getEndTime())).toLocaleString());
			String typeCode = resultReq.getRequestTypeCode();
			if (typeCode.endsWith("1")) {
				resultReq.setRequestTypeCode("病假");
			} else if (typeCode.endsWith("2")) {
				resultReq.setRequestTypeCode("事假");
			} else if (typeCode.endsWith("3")) {
				resultReq.setRequestTypeCode("公假");
			}
			
			String result = resultReq.getCheckState();
			if (result.endsWith("0")) {
				resultReq.setCheckState("未审核");
			} else if (result.endsWith("2")) {
				resultReq.setCheckState("审核未通过");
			} else if (result.endsWith("1")) {
				resultReq.setCheckState("审核通过");
			}
			
			map.put("stuCode", "学生学号： "+resultReq.getStuCode());
			map.put("beginTime", "请假开始时间： "+resultReq.getBeginTime());
			map.put("endTime", "请假结束时间： "+resultReq.getEndTime());
			map.put("reqType", "请假类型： "+resultReq.getRequestTypeCode());
			map.put("reason", "请假原因： "+resultReq.getRequestReason());
			map.put("result", "请假结果： "+resultReq.getCheckState());
			map.put("remark", "审核备注： "+resultReq.getCheckRemark());

			list.add(map);
		}

	}

	private void loadMoreDate() {
//		int count = adapter.getCount();
//		if (count + 5 < maxDataNum) {
			// 每次加载5条
//			for (int i = count; i < count + 5; i++) {
//				HashMap<String, String> map = new HashMap<String, String>();
//				map.put("ItemTitle", "新增第" + i + "行标题");
//				map.put("ItemText", "新增第" + i + "行内容");
//				list.add(map);
//			}
			addList();
//		} else {
			// 数据已经不足5条
//			for (int i = count; i < maxDataNum; i++) {
//				HashMap<String, String> map = new HashMap<String, String>();
//				map.put("ItemTitle", "新增第" + i + "行标题");
//				map.put("ItemText", "新增第" + i + "行内容");
//				list.add(map);
//			}
//		}

	}

	private int curPage = 1;

	@Override
	protected void doWording() {
		// TODO Auto-generated method stub
		
		System.out.println("cur is adapter........"+isAdapted);

		// 每次加载10条记录
		Request req = new Request();
		//req.setCheckState("2");
//		req.setStuCode(((MainTabPub) container).getUserCode());
		String code = ((MainTabPub) container)==null?null: ((MainTabPub) container).getUserCode();
		if (code != null) {
			if (code.length() == 12) {
				req.setStuCode(code);
			} else {
				req.setTransactorId(code);
			}
			
		}
		
		JSONObject json;
		try {
			json = JSONUtil.beanToJson(req);

			json.put("limits", "10");
			json.put("curPage", curPage + "");

			((MainTabPub) container).subWorking(cru.getViewWaitCheckRecord(),
					json.toString());
		} catch (java.lang.InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	boolean isAdapted = false;

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub

		String jsonStr = getHttpInfo().getRetStr();

		try {
			JSONObject json = new JSONObject(jsonStr);
			JSONObject retEntity = new JSONObject(json.get("retEntity")
					.toString());

			System.out.println("retEntity=================" + retEntity);

			if (retEntity.has("rows")) {

				JSONArray rows = new JSONArray(retEntity.get("rows").toString());
				resultReqs.clear();

				for (int i = 0; i < rows.length(); i++) {
					JSONObject row = rows.getJSONObject(i);

					Request req = new Request();
					JSONUtil.jsonToBean(row, req);

					resultReqs.add(req);

				}

				if (!isAdapted) {
					//list = getList();
					addList();
					// Initialize the adapter
					adapter = new SimpleAdapter(getActivity(), list,
							R.layout.history_item, new String[] { "stuCode",
									"beginTime", "endTime", "reqType",
									"reason", "result","remark" }, new int[] {
									R.id.txv_Code, R.id.txv_beginTime,
									R.id.txv_endTime, R.id.txv_reqType,
									R.id.txv_reason, R.id.txv_result,R.id.txv_remark });

					list_history.setAdapter(adapter);
					isAdapted = true;
				} else {
					loadMoreDate();
				}

				bt.setVisibility(View.VISIBLE);
				pb.setVisibility(View.GONE);
				adapter.notifyDataSetChanged();// 通知listView刷新数据

				curPage += 1;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFialed() {
		// TODO Auto-generated method stub

		Toast.makeText(getActivity(), "加载失败...已无记录...", Toast.LENGTH_LONG).show();

		bt.setVisibility(View.VISIBLE);
		pb.setVisibility(View.GONE);
//		adapter.notifyDataSetChanged();// 通知listView刷新数据
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub

		bt.setVisibility(View.VISIBLE);
		pb.setVisibility(View.GONE);
//		adapter.notifyDataSetChanged();// 通知listView刷新数据
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub

		// 滑到底部后自动加载，判断listview已经停止滚动并且最后可视的条目等于adapter的条目
		if (scrollState == OnScrollListener.SCROLL_STATE_IDLE
				&& lastVisibleIndex == adapter.getCount()) {
			// 当滑到底部时自动加载
			// pg.setVisibility(View.VISIBLE);
			// bt.setVisibility(View.GONE);
			// handler.postDelayed(new Runnable() {
			//
			// @Override
			// public void run() {
			// loadMoreDate();
			// bt.setVisibility(View.VISIBLE);
			// pg.setVisibility(View.GONE);
			// mSimpleAdapter.notifyDataSetChanged();
			// }
			//
			// }, 2000);

		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub

		// 计算最后可见条目的索引
		lastVisibleIndex = firstVisibleItem + visibleItemCount - 1;

		// 所有的条目已经和最大条数相等，则移除底部的View
		if (totalItemCount == maxDataNum + 1) {
			list_history.removeFooterView(moreView);
			Toast.makeText(getActivity(), "数据全部加载完成，没有更多数据！", Toast.LENGTH_LONG)
					.show();
		}
	}

}
