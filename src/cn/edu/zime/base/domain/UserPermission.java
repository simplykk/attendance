package cn.edu.zime.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v4.app.Fragment;



public abstract class UserPermission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6814356061756896241L;
	TabGrids[] grids;
	Fragment[] thisFragments;
	
	Object container;
	
	
	
	public TabGrids[] getGrids() {
		return grids;
	}

	public void setGrids(TabGrids[] grids) {
		this.grids = grids;
	}
	

	public Fragment[] getThisFragments() {
		return thisFragments;
	}

	public void setThisFragments(Fragment[] thisFragments) {
		this.thisFragments = thisFragments;
	}

	protected abstract void initGrids(); 
	protected abstract void initFragments(Object container);
	
	public List<Map<String,Object>> getMaps () {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0;grids != null && i < grids.length; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("displayTxt", grids[i].getDisplayTxt());
			map.put("bkImg", grids[i].getBkImgId());
			list.add(map);
		}
		return list;
	}
	
	public List<Map<String,Object>> getMapsWithoutTxt () {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0;grids != null && i < grids.length; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("bkImg", grids[i].getBkImgId());
			list.add(map);
		}
		return list;
	}

}
