package cn.edu.zime.factory;

/**
 * 创建一个impl实例，返回实现接口的一个类对象
 * 
 * @author ad
 *
 */
public abstract class ImplFactory {

	/**
	 * 创建实例
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> clazz) throws Exception {
		String className = clazz.getName();
		StringBuffer sb = new StringBuffer(className.substring(0, className.lastIndexOf('.')));
		sb.append(".impl"+className.substring(className.lastIndexOf('.'), className.length())+"Impl");
//		System.out.println(sb.toString());
		return (T) Class.forName(sb.toString()).newInstance();
	}
	
}
