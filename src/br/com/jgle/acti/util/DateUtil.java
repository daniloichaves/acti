package br.com.jgle.acti.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static final Date date = new Date();

	public static Timestamp getTimestamp(Calendar data) {

		return new Timestamp(data.getTimeInMillis());
	}

	/**
	 * Retorna o valor do horário minimo para a data de referencia passada. <BR>
	 * <BR>
	 * Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
	 * retornada por este metodo será "30/01/2009 as 00h:00m:00s e 000ms".
	 * 
	 * @param date
	 *            de referencia.
	 * @return {@link Date} que representa o horário minimo para dia informado.
	 */
	public static Date lowDateTime(Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);
		toOnlyDate(aux); // zera os parametros de hour,min,sec,milisec
		return aux.getTime();
	}

	/**
	 * Retorna o valor do horário maximo para a data de referencia passada. <BR>
	 * <BR>
	 * Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
	 * retornada por este metodo será "30/01/2009 as 23h:59m:59s e 999ms".
	 * 
	 * @param date
	 *            de referencia.
	 * @return {@link Date} que representa o horário maximo para dia informado.
	 */
	public static Date highDateTime(Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);
		toOnlyDate(aux); // zera os parametros de hour,min,sec,milisec
		aux.roll(Calendar.DATE, true); // vai para o dia seguinte
		aux.roll(Calendar.MILLISECOND, false); // reduz 1 milisegundo
		return aux.getTime();
	}

	/**
	 * Zera todas as referencias de hora, minuto, segundo e milesegundo do
	 * {@link Calendar}.
	 * 
	 * @param date
	 *            a ser modificado.
	 */
	public static void toOnlyDate(Calendar date) {
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Adicona 1 minuto para data de referencia passada. <BR>
	 * <BR>
	 * Por exemplo se a data for "30/01/2009 as 17h:32m:0s e 000ms" a data
	 * retornada por este metodo será "30/01/2009 as 17h:32m:59s e 999ms".
	 * 
	 * @param date
	 *            de referencia.
	 * @return {@link Date} que representa o horário maximo para dia informado.
	 */
	public static Date addMinuteDateTime(Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);
		aux.roll(Calendar.MINUTE, true); // vai para o minutoseguinte
		aux.roll(Calendar.MILLISECOND, false); // reduz 1 milisegundo
		return aux.getTime();
	}

	public static Calendar getCalendar(Timestamp timestamp) {
		Calendar data = Calendar.getInstance();
		data.setTimeInMillis(timestamp.getTime());
		return data;
	}

	public static Calendar getCalendar(Date date) {
		Calendar data = Calendar.getInstance();
		data.setTimeInMillis(date.getTime());
		return data;
	}

	public static String format(Calendar date, String pattern, Locale locale) {
		SimpleDateFormat sdf = null;
		if (locale == null) {
			sdf = new SimpleDateFormat(pattern);
		} else {
			sdf = new SimpleDateFormat(pattern, locale);
		}
		return sdf.format(date.getTime());
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	public static Date parse(String date, String pattern, Locale locale) throws ParseException {
		SimpleDateFormat sdf = null;
		if (pattern == null) {
			pattern = "dd/MM/yyyy";
		}
		if (locale == null) {
			sdf = new SimpleDateFormat(pattern);
		} else {
			sdf = new SimpleDateFormat(pattern, locale);
		}
		return sdf.parse(date);
	}

	public static Date parse(int dia, Integer mes, Integer ano, boolean zeroHora) throws ParseException {
		mes--;
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, dia);
		data.set(Calendar.MONTH, mes);
		data.set(Calendar.YEAR, ano);
		if (zeroHora) {
			data.set(Calendar.MILLISECOND, 0);
			data.set(Calendar.SECOND, 0);
			data.set(Calendar.MINUTE, 0);
			data.set(Calendar.HOUR, 0);
		}
		return data.getTime();
	}

	public static String format(Calendar date, String pattern) {
		return format(date, pattern, null);
	}

	public static Date parse(String date, String pattern) throws ParseException {
		return parse(date, pattern, null);
	}

	public static Date parse(String date) throws ParseException {
		return parse(date, null, null);
	}

	public static String getActualFormatedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
		return sdf.format(new Date());
	}

	public static Date adicionarDias(Date data, Integer dias) {

		Calendar dataInicial = Calendar.getInstance();
		dataInicial.setTime(data);
		dataInicial.add(Calendar.DAY_OF_MONTH, dias);

		return dataInicial.getTime();
	}

	public static Integer diasDeDiferenca(Date dataInicio, Date dataFim) {

		int contadorDias = 0;
		Calendar dataInicial = Calendar.getInstance();
		dataInicial.setTime(dataInicio);

		Calendar dataFinal = Calendar.getInstance();
		dataFinal.setTime(dataFim);

		while (dataInicial.before(dataFinal)) {
			contadorDias++;
			dataInicial.add(Calendar.DAY_OF_MONTH, 1);
		}

		return contadorDias;
	}

	public static Date adicionarDiasUteis(Date data, Integer diasUteis) {

		Calendar dataInicial = Calendar.getInstance();
		dataInicial.setTime(data);

		int adicionarDias = 0;
		int diaDaSemana = dataInicial.get(Calendar.DAY_OF_WEEK);
		if (diaDaSemana == Calendar.SATURDAY) { // Sabado
			adicionarDias += 2;
		} else if (diaDaSemana == Calendar.SUNDAY) { // Domingo
			adicionarDias += 1;
		}

		adicionarDias += diasUteis;

		dataInicial.add(Calendar.DAY_OF_MONTH, adicionarDias);

		return dataInicial.getTime();
	}

	public static Integer compareDate(Date date1, Date date2) {
		Calendar calendar1 = getCalendar(date1);
		Calendar calendar2 = getCalendar(date2);

		return calendar1.compareTo(calendar2);

	}

	public static Date getDate() {
		return date;
	}

}
