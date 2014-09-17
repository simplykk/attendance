package cn.edu.zime.domain;

import java.io.Serializable;

import cn.edu.zime.constant.Constant;

public class CommonReqUri implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4531820589899371707L;
	private String servURL = "http://192.168.1.104:8080";
	private String loginReq = Constant.REMOTE_HOST+"/attendance-frontweb/request/login";
	private String promptServURL = Constant.REMOTE_HOST + "/attendance-frontweb/request/saveClientIP";
	private String viewWaitCheckRecord = Constant.REMOTE_HOST + "/attendance-frontweb/request/viewHistory";
	private String chargeReq = Constant.REMOTE_HOST + "/attendance-frontweb/request/chargeReq";
	private String cancelReq = Constant.REMOTE_HOST + "/attendance-frontweb/request/cancelReq";
	private String checkReq = Constant.REMOTE_HOST  + "/attendance-frontweb/request/checkReq";
	private String confirmReq = Constant.REMOTE_HOST + "/attendance-frontweb/request/confirmReq";
	private String updateReqInfo  = Constant.REMOTE_HOST + "/attendance-frontweb/request/updateReqInfo";
	
	public String getServURL() {
		return servURL;
	}

	public void setServURL(String servURL) {
		this.servURL = servURL;
	}

	public String getViewWaitCheckRecord() {
		return viewWaitCheckRecord;
	}

	public void setViewWaitCheckRecord(String viewWaitCheckRecord) {
		this.viewWaitCheckRecord = viewWaitCheckRecord;
	}

	public String getChargeReq() {
		return chargeReq;
	}

	public void setChargeReq(String chargeReq) {
		this.chargeReq = chargeReq;
	}

	public String getCancelReq() {
		return cancelReq;
	}

	public void setCancelReq(String cancelReq) {
		this.cancelReq = cancelReq;
	}

	public String getCheckReq() {
		return checkReq;
	}

	public void setCheckReq(String checkReq) {
		this.checkReq = checkReq;
	}

	public String getConfirmReq() {
		return confirmReq;
	}

	public void setConfirmReq(String confirmReq) {
		this.confirmReq = confirmReq;
	}

	public String getUpdateReqInfo() {
		return updateReqInfo;
	}

	public void setUpdateReqInfo(String updateReqInfo) {
		this.updateReqInfo = updateReqInfo;
	}

	public String getLoginReq() {
		return loginReq;
	}

	public void setLoginReq(String loginReq) {
		this.loginReq = loginReq;
	}

	public String getPromptServURL() {
		return promptServURL;
	}

	public void setPromptServURL(String promptServURL) {
		this.promptServURL = promptServURL;
	}

	

}
