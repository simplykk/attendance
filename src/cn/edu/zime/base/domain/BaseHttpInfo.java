package cn.edu.zime.base.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;

public class BaseHttpInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3861310604065599919L;

//	public String key = "AA40AEBFCD04E6FA693EFC50AA484ED"; // test
//	public String key = "A1BF14B6C7FC1D55432E34F3C3DD9DE4"; // 安徽农垦
//	public String key = "1E5369744568B3454D2213365FAD9DB2"; // 黑龙江农垦

	private String charsetCode = "UTF-8"; // default utf-8
	private String retStr;
	private String uri;
	private String sendJSONStr;
	private String retEntity;
	
	public String getRetEntity() {
		return retEntity;
	}
	public void setRetEntity(String retEntity) {
		this.retEntity = retEntity;
	}
	private String lastErrorStr;
	private String dataType = "JSON"; //default JSON,other: FORM
	
	private String reqUrl;
	private String httpMode = "POST"; // GET, POST, SUCCESS(固定返回success，测试用 ) (default : POST)
	private ArrayList<BasicNameValuePair> bnvps = new ArrayList<BasicNameValuePair>();// http请求参数
	private int timeout = 5000; // 网络连接超时时间
	
	
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getSendJSONStr() {
		return sendJSONStr;
	}
	public void setSendJSONStr(String sendJSONStr) {
		this.sendJSONStr = sendJSONStr;
	}
	public String getCharsetCode() {
		return charsetCode;
	}
	public void setCharsetCode(String charsetCode) {
		this.charsetCode = charsetCode;
	}
	public String getRetStr() {
		return retStr;
	}
	public void setRetStr(String retStr) {
		this.retStr = retStr;
	}
	public String getLastErrorStr() {
		return lastErrorStr;
	}
	public void setLastErrorStr(String lastErrorStr) {
		this.lastErrorStr = lastErrorStr;
	}
	public String getReqUrl() {
		return reqUrl;
	}
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	public ArrayList<BasicNameValuePair> getBnvps() {
		return bnvps;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getHttpMode() {
		return httpMode;
	}
	public void setHttpMode(String httpMode) {
		this.httpMode = httpMode;
	}
	public void setBnvps(ArrayList<BasicNameValuePair> bnvps) {
		this.bnvps = bnvps;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
