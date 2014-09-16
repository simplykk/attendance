package cn.edu.zime.constant;

public class Constant {

	public static String CUR_IP = "";
	public static String REMOTE_HOST = "";
	
	//===========   SQLite arguments =========
	public static final String LOCAL_DB_NAME = "userDB";//database's name
	//=========== Share preferences name ======
	public static final String SHARED_NAME = "myConfig";//shared preferences file's name
	
	//=========== BaseHpptInfo  ==============
	public static final int SUCCESS = 0;
	public static final int ERROR_SOCKCONNECT = 1;
	public static final int ERROR_JSON = 2;
	public static final int ERROR_SAVEDATABASE = 3;
	public static final int ERROR_OPERDATABASE = 4;
	public static final int ERROR_SOCKTIMEOUT = 5;
	// ========= request mode ================
	public static final int MODE_GET = 1;
	public static final int MODE_POST = 2;
	public static final int MODE_OTHER = 2;
}
