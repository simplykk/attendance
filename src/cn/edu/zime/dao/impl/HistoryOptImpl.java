//package cn.edu.zime.dao.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import cn.edu.zime.constant.Constant;
//import cn.edu.zime.dao.HistoryOpt;
//import cn.edu.zime.domain.History;
//import cn.edu.zime.pub.MyDBHelper;
//
//public class HistoryOptImpl implements HistoryOpt {
//
//	private SQLiteDatabase getDb(Context context) {
//		MyDBHelper helper = new MyDBHelper(context);
//		return helper.getReadableDatabase();
//	}
//
//	@Override
//	public List<History> query(Context context, int uId, int start, int offset) {
//		SQLiteDatabase db = getDb(context);
//		List<History> histories = new ArrayList<History>();
//		Cursor cursor = db.query(Constant.tableName,null, "uId = ? limit ?,?",
//				new String[] { uId + "", start + "", offset + "" }, null, null,
//				"id desc");
//		while (cursor.moveToNext()) {
//			History history = new History();
//			
//			history.setId(cursor.getInt(cursor.getColumnIndex("id")));
//			history.setuId(cursor.getString(cursor.getColumnIndex("uId")));
//			history.setuName(cursor.getString(cursor.getColumnIndex("uName")));
//			history.setReason(cursor.getString(cursor.getColumnIndex("reason")));
//			history.setStartTime(cursor.getString(cursor.getColumnIndex("startTime")));
//			history.setStopTime(cursor.getString(cursor.getColumnIndex("stopTime")));
//			history.setRequestDate(cursor.getString(cursor.getColumnIndex("requestDate")));
//			history.setResult(cursor.getString(cursor.getColumnIndex("result")));
//			history.setType(cursor.getString(cursor.getColumnIndex("type")));
//			
//			histories.add(history);
//		}
//		db.close();
//		return histories;
//	}
//
//	@Override
//	public void insert(Context context, History history) {
//		SQLiteDatabase db = getDb(context);
//		ContentValues values = new ContentValues();
//		values.put("id", history.getId());
//		values.put("uId", history.getuId());
//		values.put("uName", history.getuName());
//		values.put("reason", history.getReason());
//		values.put("startTime", history.getStartTime());
//		values.put("stopTime", history.getStopTime());
//		values.put("requestDate", history.getRequestDate());
//		values.put("result", history.getResult());
//		values.put("type", history.getType());
//		db.insert(Constant.tableName, null, values);
//		db.close();
//	}
//
//	@Override
//	public void delete(Context context, int[] id, boolean isClear) {
//		SQLiteDatabase db = getDb(context);
//		if (isClear) {
//			db.delete(Constant.tableName, null, null);
//			db.close();
//			return;
//		}
//		for (int i = 0; i < id.length; i++) {
//			db.delete(Constant.tableName, "id = ?", new String[]{id[i]+""});
//		}
//		db.close();
//		
//	}
//
//}
