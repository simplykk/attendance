package cn.edu.zime.domain;

import java.io.Serializable;

public class CommonReqUri implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4531820589899371707L;
	private String servURL = "http://192.168.1.104:8080";
	private String loginReq = servURL+"/attendance-frontweb/request/login";
	private String promptServURL = servURL + "/attendance-frontweb/request/saveClientIP";

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
