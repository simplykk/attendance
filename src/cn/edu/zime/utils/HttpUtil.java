package cn.edu.zime.utils;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * @since Sept 8th 2014
 * @version 1.0
 * <p>
 * 关于HTTP请求的工具类，此类包含了以下方法
 * <ul>
 * 	<li>String getLocalIP(Context context) throws SockeException : 
 *  	<i>获取当前用户的IPv4地址（支持Wi-Fi和移动数据网络）</i></li><br/>
 *  <li>String postReqAsJson (String requestJson) throws ClientProtocolException,
 *  	IOException : <i>发送JSON字符串向服务器请求数据，返回服务器响应的消息</i></li><br/>
 * </ul>
 * </p>
 * 
 * @author Geekii
 *
 */
public class HttpUtil {
	
	private static final String TAG = "HttpUtil";

	/**
	 * @param context 传入当前的ActivityContext对象，获取当前的移动设备IP地址
	 * @return 返回当前移动设备的IPv4地址，以xxx.xxx.xxx.xxx的形式返回
	 * @throws SocketException This {@code SocketException} may be thrown 
	 * during socket creation or setting
	 * options, and is the superclass of all other socket related exceptions.
	 * 
	 */
	public static String getLocalIP(Context context) throws SocketException {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()
							&& inetAddress instanceof Inet4Address) {// 判断是否环回地址或非ipv4
						return inetAddress.getHostAddress();
					}
				}
			}
		} else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
			WifiManager manager = (WifiManager) context
					.getSystemService(Context.WIFI_SERVICE);
			WifiInfo info = manager.getConnectionInfo();
			int intIp = info.getIpAddress();
			String ipAddress = ((intIp & 0xFF) + "." + ((intIp >> 8) & 0xFF)
					+ "." + ((intIp >> 16) & 0xFF) + "." + ((intIp >> 24) & 0xFF));
			Log.i(TAG, "======== local ip address ========"+ipAddress);
			return ipAddress;
		}
		return null;
	}

	/**
	 * @param requestJson 向服务器发送的JSON请求字符串
	 * @return 返回服务器响应的结果,如果响应的状态码不是200，则返回状态码+"ERROR"，提示后续处理
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String postReqAsJson(String uri,String requestJson)
			throws ClientProtocolException, IOException {
		Log.i(TAG, "Send data to :"+uri+" ========== and the data str:"+requestJson);
		HttpPost post = new HttpPost(uri);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("attendanceClientJSON", requestJson));
		post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);
		if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
			String retStr = EntityUtils.toString(response.getEntity());
			Log.i(TAG, "=================response str:"+retStr);
			return retStr;
		}
		
		return response.getStatusLine().getStatusCode()+"ERROR";
	}
	
	/**
	 * @param requestJson 向服务器发送的JSON请求字符串,可以添加额外的参数
	 * @return 返回服务器响应的结果,如果响应的状态码不是200，则返回状态码+"ERROR"，提示后续处理
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String postReqAsJsonAddParam(String uri,String requestJson,Map<String,String> param) throws ClientProtocolException, IOException{
		Log.i(TAG, "Send data to :"+uri+" ========== and the data str:"+requestJson);
		HttpPost post = new HttpPost(uri);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String,String> entry : param.entrySet()) {
			parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		parameters.add(new BasicNameValuePair("attendanceClientJSON", requestJson));
		post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);
		if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
			String retStr = EntityUtils.toString(response.getEntity());
			Log.i(TAG, "=================response str:"+retStr);
			return retStr;
		}
		
		return response.getStatusLine().getStatusCode()+"ERROR";
	}

//	public static String mapToJsonStr(Map<String, Object> map)
//			throws JSONException {
//		JSONObject json = new JSONObject();
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			json.put(entry.getKey(), entry.getValue());
//		}
//		return json.toString();
//	}
//
//	public static Map<String, Object> jsonStrToMap(String jsonStr)
//			throws JSONException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		JSONObject json = new JSONObject(jsonStr);
//		Iterator<String> iterator = json.keys();
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			map.put(key, json.get(key));
//		}
//		return map;
//	}
}
