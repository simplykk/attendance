package cn.edu.zime.base.domain;

import java.io.Serializable;

public class UserBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2033830593416900009L;
	private UserPermission userPermission;
	public UserPermission getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

}
