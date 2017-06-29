package br.com.jgle.acti.util;

import java.lang.reflect.Method;
import java.util.HashSet;

public class BeanUtil {

	// public static Object getValue(Object object, String attribute) throws
	// InvocationTargetException, NoSuchMethodException, IllegalAccessException
	// {
	//
	// Object value = object;
	// StringTokenizer st = new StringTokenizer(attribute, ".");
	// while (st.hasMoreElements()) {
	// String att = st.nextToken();
	// Method m1 = null;
	// try {
	// m1 = value.getClass().getMethod("get" +
	// StringUtil.firstLetterUpperCase(att), null);
	// } catch (Exception e) {
	// m1 = value.getClass().getMethod("is" +
	// StringUtil.firstLetterUpperCase(att), null);
	// }
	// value = m1.invoke(value, null);
	// }
	// return value;
	// }

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public static Object[] convertValues(Class[] clazz, String[] values)
	// throws IllegalArgumentException, InstantiationException,
	// IllegalAccessException, InvocationTargetException, SecurityException,
	// NoSuchMethodException {
	// Object[] converted = new Object[clazz.length];
	// for (int i = 0; i < clazz.length; i++) {
	// Constructor constructor = clazz[i].getConstructor(new Class[] {
	// String.class });
	// converted[i] = constructor.newInstance(new String[] { values[i] });
	// }
	// return converted;
	// }

	public static String getAttribute(Method method) {
		String methodName = method.getName();
		if (methodName.startsWith("get") || methodName.startsWith("set")) {
			return StringUtil.firstLetterLowerCase(methodName.substring(3, methodName.length()));
		} else if (methodName.startsWith("is")) {
			return StringUtil.firstLetterLowerCase(methodName.substring(2, methodName.length()));
		}
		return null;
	}

	public static HashSet<String> getAttributeNames(Object object) {
		HashSet<String> attributes = new HashSet<String>();
		Method[] methods = object.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			String methodName = methods[i].getName();
			if ((methodName.startsWith("get") && methods[i].getParameterTypes().length == 0) || methodName.startsWith("set")) {
				attributes.add(StringUtil.firstLetterLowerCase(methodName.substring(3, methodName.length())));
			} else if (methodName.startsWith("is")) {
				attributes.add(StringUtil.firstLetterLowerCase(methodName.substring(2, methodName.length())));
			}
		}

		// Remover atributos indiferentes
		attributes.remove("class");

		return attributes;
	}

	// public static String toString(Object object) {
	// StringBuffer saida = new StringBuffer();
	// if (object != null) {
	// Set<String> attributes = getAttributeNames(object);
	// for (String att : attributes) {
	// try {
	// saida.append(att + " : " + getValue(object, att) + " - ");
	// } catch (Exception e) {
	// }
	// }
	// }
	// return saida.toString();
	// }

	/**
	 * Copiar todos os valores das propriedades de um objeto para outro. Somente
	 * copiar os com mesmo nome.
	 * 
	 * @param source
	 * @param destination
	 */
	/*public static void copyProperties(Object source, Object destination) {

		Method[] methods = source.getClass().getMethods();
		for (Method getMethod : methods) {
			String attributeName = null;
			try {
				if (getMethod.getName().startsWith("get") && !getMethod.getName().equals("getClass")) {
					attributeName = getMethod.getName().substring(3, getMethod.getName().length());
					if (source.getClass().getMethod("set" + attributeName, new Class[] { getMethod.getReturnType() }) != null) {
						Method setMethod = destination.getClass().getMethod("set" + attributeName, new Class[] { getMethod.getReturnType() });
						Object value = getMethod.invoke(source, null);
						setMethod.invoke(destination, new Object[] { value });
					}
				}
			} catch (NoSuchMethodException e) {
				System.out.println("atributo nao encontrado : " + attributeName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
}
