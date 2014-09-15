package cn.edu.zime.base.activity;

import cn.edu.zime.constant.Constant;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

	public MyDBHelper(Context context) {
		super(context, Constant.LOCAL_DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE HISTORY(ID INTEGER,USER_ID VARCHAR(12), USER_NAME VARCHAR(64), REQ_REASON " +
				"VARCHAR(128),START_TIME VARCHAR(64), STOP_TIME VARCHAR(64),REQUEST_TIME" +
				" VARCHAR(64), RESULT VARCHAR(16),REQ_TYPE VARCHAR(16));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("upgrade");
	}

}
