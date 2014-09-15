package cn.edu.zime.base.domain;

import java.io.Serializable;

import cn.edu.zime.attendanceapp.R;

public class TabGrids implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8983686432256246969L;
	
	private int bkImgId;
	private String displayTxt;

	public TabGrids(int bkImgId, String displayTxt) {
		if (bkImgId == -1)
			bkImgId = R.drawable.ic_launcher;
		else
			this.bkImgId = bkImgId;
		this.displayTxt = displayTxt;
	}

	public int getBkImgId() {
		return bkImgId;
	}

	public void setBkImgId(int bkImgId) {
		this.bkImgId = bkImgId;
	}

	public String getDisplayTxt() {
		return displayTxt;
	}

	public void setDisplayTxt(String displayTxt) {
		this.displayTxt = displayTxt;
	}
	
	

}
