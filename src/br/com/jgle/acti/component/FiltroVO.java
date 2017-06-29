package br.com.jgle.acti.component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.util.DateUtil;
import br.com.jgle.acti.util.ReflectionUtil;

@SuppressWarnings("rawtypes")
public class FiltroVO {

	private String attributeLabel;
	private String attributeCampo;
	private AttributeComparator attributeComparator;
	private String attributeValue;
	private AttributeOperator attributeOperator;
	private Class clazz;
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static final DateFormat dateHoraFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	//public FiltroVO() {
	//}

	public FiltroVO(Class clazz) {
		this.clazz = clazz;
	}

	public FiltroVO(String campo, AttributeComparator comparator, String value) {
		this.attributeCampo = campo;
		this.attributeComparator = comparator;
		this.attributeValue = value;
	}

	public boolean isValido() {
		if (attributeCampo != null && !"".equals(attributeCampo)
				&& attributeValue != null && !"".equals(attributeValue)) {
			return true;
		}
		return false;
	}

	public static enum AttributeComparator {

		EQUALS("="), EQUALS_MORE("=>"), EQUAL_LESS("<="), MORE(">"), LESS("<"), NOT_LIKE(
				"Não Contém"), LIKE("Contém");

		private String attributeCompator;

		private AttributeComparator(String attributeCompator) {
			this.attributeCompator = attributeCompator;
		}

		public String getAttributeCompator() {
			return attributeCompator;
		}

		public void setAttributeCompator(String attributeCompator) {
			this.attributeCompator = attributeCompator;
		}
	};

	public static enum AttributeOperator {

		E("E"), OU("OU");

		private String attributeCompator;

		private AttributeOperator(String attributeCompator) {
			this.attributeCompator = attributeCompator;
		}

		public String getAttributeCompator() {
			return attributeCompator;
		}

		public void setAttributeCompator(String attributeCompator) {
			this.attributeCompator = attributeCompator;
		}

	};

	public void setConfigNecessario(String attributeCampo,
			AttributeComparator attributeComparator, String attributeValue,
			AttributeOperator attributeOperator) {
		this.attributeCampo = attributeCampo;
		this.attributeComparator = attributeComparator;
		this.attributeValue = attributeValue;
		this.attributeOperator = attributeOperator;

	}

	public String getAttributeLabel() {
		return attributeLabel;
	}

	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
	}

	public Object getAttributeValue() throws ParseException {
		if (attributeValue.matches("../../.*")
				|| attributeValue.matches("..-..-.*")) {
			if (attributeValue.contains("-"))
				attributeValue = attributeValue.replaceAll("-", "/");
			return dateFormat.parse(attributeValue);
		}
		return attributeValue;
	}

	@SuppressWarnings("unchecked")
	public <Y extends Object> Y getAttributeValueObject() throws ParseException {
		attributeValue = attributeValue.trim();

		if (attributeValue.matches("../../.*")
				|| attributeValue.matches("..-..-.*")) {
			if (attributeValue.contains("-"))
				attributeValue = attributeValue.replaceAll("-", "/");

			if (attributeValue.matches(".*.:.."))
				return (Y) dateHoraFormat.parse(attributeValue);
			return (Y) dateFormat.parse(attributeValue);

		} else if (attributeValue.matches("..:..")) {
			return (Y) DateUtil.parse(attributeValue, "HH:mm",
					Locale.getDefault());
		}

		Y value = (Y) attributeValue;
		if (clazz != null) {
			// Atualização do campo para fazer pesquisa por BigDecimal, Enum
			value = (Y) ReflectionUtil.getTipoCampo(clazz, attributeCampo,
					attributeValue);
		}

		return (Y) value;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public AttributeComparator getAttributeComparator() {
		return attributeComparator;
	}

	public void setAttributeComparator(AttributeComparator attributeComparator) {
		this.attributeComparator = attributeComparator;
	}

	public void setAttributeOperator(AttributeOperator attributeOperator) {
		this.attributeOperator = attributeOperator;
	}

	public AttributeOperator getAttributeOperator() {
		return attributeOperator;
	}

	public String getAttributeCampo() {
		return attributeCampo;
	}

	public void setAttributeCampo(String attributeCampo) {
		this.attributeCampo = attributeCampo;
	}

}
