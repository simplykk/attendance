package cn.edu.zime.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @since Sept 9th 2014
 * @version 1.0
 * 
 * <p>
 *  提供JSON对象相关操作的工具类，包括：
 *  <ul>
 *   <li><T> JSONObject beanToJson(T  srcBean) throws InstantiationException,
 *    IllegalAccessException, JSONException : 反射javaBean中到属性，并将值封装进JSON对象</li><br/>
 *    <li><T> JSONArray beansToJsonArray(T... beans) throws IllegalArgumentException, 
 *    IllegalAccessException, JSONException : 反射多个javaBean，并逐个放入JSON对象最后封装成JSON数组</li><br/>
 *    <li><T> T jsonToBean(JSONObject json, T targetBean) throws IntrospectionException, 
 *    IllegalAccessException, InvocationTargetException, JSONException : 将JSON对象中的值封装到一个javaBean中并返回</li><br/>
 *  </ul>
 * </p>
 * 
 * @author Geekii
 *
 */
public class JSONUtil {

	/**
	 * 获取一个javaBean的所有属性并把它放入一个JSON对象中返回
	 * 
	 * @param srcBean  提供数据的源javaBean对象，存放了需要封装的数据。
	 * @return 返回一个JSON对象集合，封装了javaBean中的所有属性
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws JSONException
	 */
	public static <T> JSONObject beanToJson(T  srcBean) throws InstantiationException, IllegalAccessException, JSONException{
		JSONObject json = new JSONObject();
		Field[] fields = srcBean.getClass().getDeclaredFields();//获取源Bean的字段
		for (Field field : fields) {
			field.setAccessible(true);//强制访问私有字段
			String name = field.getName();
			Object value =field.get(srcBean);
			
			json.put(name, value);
		}
		return json;
	}
	
	/**
	 * 提供多个JSON和javaBean间的封装，每个javaBean封装到一个JSONObject中，多个JSONObject封装到一个JSONArray中并返回这个JSONArray对象
	 * 
	 * @param beans 需要封装的javaBean数组，提供多个javaBean
	 * @return 返回封装后的JSONArray集合，包含了多个JSONObject
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws JSONException
	 */
	public static <T> JSONArray beansToJsonArray(T... beans) throws IllegalArgumentException, IllegalAccessException, JSONException{
		JSONArray jArr = new JSONArray();
		for (T bean : beans) {
			JSONObject jObj = new JSONObject();
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String name = field.getName();
				Object value = field.get(bean);
				
				jObj.put(name, value);
			}
			jArr.put(jObj);
		}
		return jArr;
	}
	
	/**
	 * 提取JSON对象中的数据到javaBean中，并将这个javaBean返回
	 * 
	 * @param json 需要进行提取数据的JSON对象
	 * @param beanCls 存放数据的javaBean，封装数据到这个javaBean中返回
	 * @return 返回封装后到javaBean
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws JSONException
	 */
	public static <T> T jsonToBean(JSONObject json, T targetBean) throws IntrospectionException, IllegalAccessException, InvocationTargetException, JSONException {
//		BeanInfo beanInfo = Introspector.getBeanInfo(targetBean.getClass());
//		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		
		Field[] fields = targetBean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
//			String name = pd.getName();
			String name = field.getName();
			
			if (json.has(name)) {
				//pd.getWriteMethod().invoke(targetBean, json.get(name));
				Object obj = json.get(name);
				if (obj instanceof Long) {
					String str = String.valueOf(obj);
					field.set(targetBean, str);
				} else {
					field.set(targetBean, obj);
				}
			}
		}
		return targetBean;
	}
	
}
