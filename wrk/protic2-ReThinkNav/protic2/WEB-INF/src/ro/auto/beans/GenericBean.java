package ro.auto.beans;

//import com.gd.dao.fill.GenericDAO;

//import javax.servlet.http.HttpServletRequest;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * This class provide basic infra-structure for all data beans
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 27, 2004
 */
public abstract class GenericBean implements Serializable, Cloneable {

	//--------------------------------------------------------//
	//                        CONSTANTS                       //
	//--------------------------------------------------------//

	public static final int STATUS_INERT = 0;
	public static final int STATUS_TO_INSERT = 1;
	public static final int STATUS_TO_UPDATE = 2;
	public static final int STATUS_TO_DELETE = 3;

	private static final int INT_TYPE = 0;
	private static final int STRING_TYPE = 1;
	private static final int LONG_TYPE = 2;
	private static final int BOOLEAN_TYPE = 3;
	private static final int DATE_TYPE = 4;
	private static final int STRING_ARRAY_TYPE = 5;
	private static final int INT_ARRAY_TYPE = 6;
	private static final Class[] TYPES_TABLE = new Class[7];


	static {
		TYPES_TABLE[INT_TYPE] = Integer.TYPE;
		TYPES_TABLE[STRING_TYPE] = String.class;
		TYPES_TABLE[LONG_TYPE] = Long.TYPE;
		TYPES_TABLE[BOOLEAN_TYPE] = Boolean.TYPE;
		TYPES_TABLE[DATE_TYPE] = Date.class;
		TYPES_TABLE[STRING_ARRAY_TYPE] = String[].class;
		TYPES_TABLE[INT_ARRAY_TYPE] = int[].class;
	}

	//--------------------------------------------------------//
	//                          FIELDS                        //
	//--------------------------------------------------------//

	private int status; // internal status

	//--------------------------------------------------------//
	//                OVERWRITES 'Object'                     //
	//--------------------------------------------------------//

	public String toString () {
		StringBuffer out = new StringBuffer();
		try {
			BeanInfo info = Introspector.getBeanInfo(getClass());
			PropertyDescriptor[] properyes = info.getPropertyDescriptors();
			out.append(getClass().getName());
			out.append("={");
			for (int i = 0, len = properyes.length; i < len; i++) {
				Method readMethod = properyes[i].getReadMethod();
				if (readMethod != null) {
					String propertyName = properyes[i].getName();
					if (propertyName.equals("class")) {
						continue;
					}
					out.append(propertyName);
					out.append("=");
					out.append(readMethod.invoke(this, null));
					out.append("; ");
				}
			}
			out.append("}");
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return out.toString();
	}

	public Object clone () throws CloneNotSupportedException {
		return super.clone();
	}

	//--------------------------------------------------------//
	//                         METHODS                        //
	//--------------------------------------------------------//

	/**
	 * Get associated one-2-one bean from the specified context.<br>
	 * <b>NOTE:</b> This method should be overwriten to provide real functionality
	 *
	 * @param contextId id used as a key to filter the specified bean
	 * @return the associated one-2-one bean
	 */
	public GenericBean getLinkedBean (int contextId) {
		return null;
	}

	/**
	 * Set associated one-2-one bean in the specified context.<br>
	 * <b>NOTE:</b> This method should be overwriten to provide real functionality
	 *
	 * @param contextId id used as a key to filter the specified bean
	 * @param bean      associated one-2-one bean
	 */
	public void setLinkedBean (int contextId, GenericBean bean) {
	}

	/**
	 * Get associated one-2-many beans from the given context.<br>
	 * <b>NOTE:</b> This method should be overwriten to provide real functionality
	 *
	 * @param contextId id used as a key to filter the specified beans
	 * @return the associated one-2-many bean
	 */
	public List getLinkedBeans (int contextId) {
		return null;
	}

	/**
	 * Set associated one-2-many bean in the specified context.<br>
	 * <b>NOTE:</b> This method should be overwriten to provide real functionality
	 *
	 * @param contextId id used as a key to filter the specified beans
	 * @param beans     associated one-2-many beans
	 */
	public void setLinkedBean (int contextId, List beans) {
	}

	/**
	 * Auto-fill bean properties with the parameters from find in HttpServletRequest.<br>
	 * for ints the default value will be -1, for other types (arrays, strings) will be null.
	 *
	 * @param map map used to store name, value property
	 */
	public void setPropertiesFromMap (Map map) /*throws Exception */ {
		Object[] invokeParams = new Object[1];
		try {
			BeanInfo info = Introspector.getBeanInfo(getClass());
			PropertyDescriptor[] properties = info.getPropertyDescriptors();

			int type;
			String requestParamValue;
			Method writeMethod;
			for (int i = properties.length; i-- != 0;) {
				requestParamValue = (String)map.get(properties[i].getName());
				if (requestParamValue == null) {
					continue;
				}
				type = findType(properties[i].getPropertyType());
				switch (type) {
					case INT_TYPE:
//						invokeParams[0] = new Integer(ro.generic.util.NumberUtil.parseInt(requestParamValue, -1));
						break;
					case STRING_TYPE:
						invokeParams[0] = requestParamValue;
						break;
					case BOOLEAN_TYPE:
						invokeParams[0] = Boolean.valueOf(requestParamValue);
						break;
					case DATE_TYPE:
						break;
					case STRING_ARRAY_TYPE:
						invokeParams[0] = map.get(properties[i].getName());
						break;
					case INT_ARRAY_TYPE:
						invokeParams[0] = parseIntArray((String[])map.get(properties[i].getName()));
						break;
					default:
						continue;
				}
				writeMethod = properties[i].getWriteMethod();
				if (writeMethod != null) {
					writeMethod.invoke(this, invokeParams);
				}
			}
		} catch (Exception e) {
			System.err.println("Crash in " + this.getClass() + ".setPropertiesFromRequest()");
			e.printStackTrace(System.err);
			//			throw e;
		}
	}

	/**
	 * Auto-fill bean properties with the parameters from find in HttpServletRequest.<br>
	 * for ints the default value will be -1, for other types (arrays, strings) will be null.
	 *
	 * @param request
	 */
/*	public final void setPropertiesFromRequest (HttpServletRequest request) {
		Object[] invokeParams = new Object[1];
		try {
			if (request == null) {
				return;
			}
			BeanInfo info = Introspector.getBeanInfo(this.getClass());
			PropertyDescriptor[] properties = info.getPropertyDescriptors();

			int type;
			String requestParamValue;
			Method writeMethod;
			for (int i = properties.length; i-- != 0;) {
				requestParamValue = request.getParameter(properties[i].getName());
				if (requestParamValue == null) {
					continue;
				}
				type = findType(properties[i].getPropertyType());
				switch (type) {
					case INT_TYPE:
						invokeParams[0] = new Integer(NumberUtil.parseInt(requestParamValue, -1));
						break;
					case STRING_TYPE:
						invokeParams[0] = requestParamValue;
						break;
					case BOOLEAN_TYPE:
						invokeParams[0] = Boolean.valueOf(requestParamValue);
						break;
					case DATE_TYPE:
						break;
					case STRING_ARRAY_TYPE:
						invokeParams[0] = request.getParameterValues(properties[i].getName());
						break;
					case INT_ARRAY_TYPE:
						invokeParams[0] = parseIntArray(request.getParameterValues(properties[i].getName()));
						break;
					default:
						continue;
				}
				writeMethod = properties[i].getWriteMethod();
				if (writeMethod != null) {
					writeMethod.invoke(this, invokeParams);
				}
			}
		} catch (Exception e) {
			System.err.println("Crash in " + this.getClass() + ".setPropertiesFromRequest()");
			e.printStackTrace(System.err);
			//			throw e;
		}
	}

	public void setPropertiesFromResultSet (ResultSet result)  {
		Object[] invokeParams = new Object[1];
		try {
			if (result == null) {
				return;
			}
			BeanInfo info = Introspector.getBeanInfo(this.getClass());
			PropertyDescriptor[] properyes = info.getPropertyDescriptors();
			int type;
			Method writeMethod;
			String propertyName;
			for (int i = properyes.length; --i >= 0;) {
				propertyName = properyes[i].getName();

				//[AUREL]
				boolean toContinue = false;
				try {
					if (result.getString(propertyName) == null) {
						toContinue = true;
					}
				} catch (Exception e) {
					toContinue = true;
				}
				if (toContinue) {
					continue;
				}

				type = findType(properyes[i].getPropertyType());

				writeMethod = properyes[i].getWriteMethod();
				if (writeMethod == null) {
					continue;
				}

				try {
					switch (type) {
						case INT_TYPE:
							invokeParams[0] = new Integer(result.getInt(propertyName));
							break;
						case STRING_TYPE:
							invokeParams[0] = result.getString(propertyName);
							break;
						case LONG_TYPE:
							invokeParams[0] = new Long(result.getLong(propertyName));
							break;
						case BOOLEAN_TYPE:
//							invokeParams[0] = GenericDAO.getBoolean(result.getString(propertyName)) ? Boolean.TRUE : Boolean.FALSE;
							break;
						case DATE_TYPE:
							break;
						case STRING_ARRAY_TYPE:
							//invokeParams[0] = request.getParameterValues(properyes[i].getName());
							break;
						case INT_ARRAY_TYPE:
							//invokeParams[0] = parseIntArray(request.getParameterValues(properyes[i].getName()));
							break;
						default:
							continue;
					}
				} catch (SQLException e) {
					System.err.println("can't set property name: " + propertyName + ", in bean " + this.getClass().getName() + ", reason: " + e.getMessage());
					continue;
				}
				writeMethod.invoke(this, invokeParams);
			}
		} catch (Exception e) {
			System.err.println("Crash in " + this.getClass() + ".setPropertiesFromResultSet()");
			e.printStackTrace(System.err);
			//			throw e;
		}
	}*/

	public final void setPropertiesFromBean (Object src) {
		Object[] invokeParams = new Object[1];
		if (this.getClass() == src.getClass()) {
			try {
				PropertyDescriptor[] thisProperyes = Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
				PropertyDescriptor[] srcProperyes = Introspector.getBeanInfo(src.getClass()).getPropertyDescriptors();

				Method readMethod;
				Method writeMethod;
				for (int i = thisProperyes.length; --i >= 0;) {
					readMethod = srcProperyes[i].getReadMethod();
					writeMethod = thisProperyes[i].getWriteMethod();
					if ((readMethod != null) && (writeMethod != null)) {
						invokeParams[0] = readMethod.invoke(src, null);
						writeMethod.invoke(this, invokeParams);
//						System.out.println("get->" + readMethod.getName() + "; set->" + writeMethod.getName());
					}
				}
			} catch (Exception e) {
				System.err.println("Crash in " + this.getClass() + ".setPropertiesFromBean() " + e);
			}
		} else {
			System.err.println("Invalid class in source " + src.getClass() + ", expected " + this.getClass());
		}
	}


	private static final int findType (Class type) {
		Class[] types = TYPES_TABLE;
		int len = types.length;
		for (int i = 0; i < len; i++) {
			if (types[i] == type) {
				return i;
			}
		}
		return -1;
	}

	private final static int[] parseIntArray (String[] params) {
		int[] ints = new int[params.length];
		for (int i = ints.length; --i >= 0;) {
//			ints[i] = NumberUtil.parseInt(params[i], -1);
		}
		return ints;
	}
//    public abstract int getFieldIndex(String fieldName);
//	public ErrorContainer validate (HttpServletRequest request) {
//		return null;
//	}

//	public int getStatus () {
//		return status;
//	}
//
//	public void setStatus (int status) {
//		this.status = status;
//	}

}
