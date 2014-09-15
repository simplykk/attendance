package cn.edu.zime.dao;

import java.util.List;

import android.content.Context;
import cn.edu.zime.domain.History;

public interface HistoryOpt {

	public List<History> query(Context context,int uId, int start, int offset);
	
	public void insert(Context context, History history);
	
	public void delete(Context context, int[] id, boolean isClear);
}
