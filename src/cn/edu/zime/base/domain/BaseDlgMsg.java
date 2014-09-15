package cn.edu.zime.base.domain;

import java.io.Serializable;

public class BaseDlgMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5018559033344888354L;
	
	private String title="连接网络";
	private String promptWait="正在获取数据...";
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPromptWait() {
		return promptWait;
	}
	public void setPromptWait(String promptWait) {
		this.promptWait = promptWait;
	}

}
