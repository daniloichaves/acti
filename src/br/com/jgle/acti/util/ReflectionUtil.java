package br.com.jgle.acti.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;

/**
 * 
 * Class Util para reflection
 * 
 * @author Danilo Ischiavolini Chaves
 * @since Etapa 1
 * 
 */
public class ReflectionUtil {
	protected static org.apache.log4j.Logger logger = Logger.getLogger(ReflectionUtil.class);

	/**
	 * Metodo responsavel por retornar uma instancia do campo referenciado no
	 * entityClass para poder fazer pesquisa no Criteria
	 * 
	 * Solução Problema busca por campo BigDecimal, Integer, Long, Enumeration,
	 * etc...
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param campoName
	 * @param object
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Object getTipoCampo(Class<T> entityClass, String campoName, Object object) {

		try {
			Class clas = Class.forName(entityClass.getName());
			Field field = null;

			if (campoName.contains(".")) {
				// TODO tratar encadeamento de objecto
				return object;
			} else {
				field = clas.getDeclaredField(campoName);
			}

			Class<?> type = field.getType();

			logger.info("Type: " + type);

			if (Enum.class.isAssignableFrom(type)) {
				Class<? extends Enum> enumType = type.asSubclass(Enum.class);
				Enum val = Enum.valueOf(enumType, object.toString());
				return val;
			} else {
				Class c = Class.forName(field.getType().getName());
				Constructor cons = c.getConstructor(new Class[] { String.class });
				return (Object) cons.newInstance(new Object[] { object.toString() });
			}

			// return type.getClass().newInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return object;
	}

	public static void main(String[] args) throws Exception {
		// TslhHistAlteConf tslhHistAlteConf = new TslhHistAlteConf();
		//
		// // Teste BigDecimal
		// Object tipoCampo = getTipoCampo(tslhHistAlteConf.getClass(),
		// "dsForm", "10");
		//
		// if (tipoCampo instanceof BigDecimal) {
		// System.out.println("BigDecimal");
		// }
	}

	public static Object getInstance(String clazzName) {
		Object object = null;
		try {
			Class<?> classDefinition = Class.forName(clazzName);
			object = classDefinition.newInstance();
		} catch (Throwable e) {
			logger.error(e);
		}
		return object;
	}

}
