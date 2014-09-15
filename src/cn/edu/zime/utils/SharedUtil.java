package cn.edu.zime.utils;

import java.util.HashMap;
import java.util.Map;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @since Sept 9th 2014
 * @version 1.0
 * 
 * <p>
 * 	这个工具类提供用户读取和存储SharePreferences文件的操作方法。
 *  This class provide save and get share preferences xml
 *   file data which you want to saved to. There are some method :
 *   <ul>
 *    <li>void saveData(SharedPreferences sp, Map<String, String> datas) : 
 *    <i>保存用户数据到xml文件的方法。Let you save data to a xml file</i></li><br/>
 *    <li>Map<String, String> getData(SharedPreferences sp, String[] keys) : 
 *    <i>读取用户参数数据并以Map集合返回的方法。Get the share preferences file data for user</i></li><br/>
 *   </ul>
 * </p>
 * 
 * @author Geekii
 *
 */
public class SharedUtil {

	/**
	 * 提供用户保存数据的方法，需要SharePreferences文件和保存参数的Map集合两个参数。
	 * 
	 * @param sp 提供保存数据的SharePreferences文件。The share preferences file object
	 * @param datas 保存数据的Map集合。 The Map<String, String > set that saved your data
	 * 
	 */
	public static void saveData(SharedPreferences sp, Map<String, String> datas){
		Editor editor = sp.edit();
		for (Map.Entry<String, String> entry : datas.entrySet()) {
			editor.putString(entry.getKey(), entry.getValue());
		}
		editor.commit();
	}
	
	/**
	 * 提供用户读取xml文件数据的方法，并以Map集合返回
	 * 
	 * @param sp  用户读取的SharePreferences文件。
	 * @param keys 用户所需数据的关键字，根据关键字查找xml文件中的对应值
	 * @return 以Map集合的方式返回数据，如果没有找到关键字对应的值则会以空字符串值放入Map中。
	 */
	public static Map<String, String> getData(SharedPreferences sp, String[] keys){
		Map<String, String> map = new HashMap<String, String>();
		for (String key : keys) {
			map.put(key, sp.getString(key, ""));
		}
		return map;
	}
}
