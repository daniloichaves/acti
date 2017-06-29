package br.com.jgle.acti.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

/**
 * 
 * Retorna pelo final da placa quando vai ser o pagamento do CRLV
 * 
 * http://www.detran.sp.gov.br/legis/portaria_2009_2405.asp
 * 
 * @author Danilo Ischiavolini Chaves
 * 
 */
@Service
public class CRLVService {

	public static int getMesCRLVVeiculoAutomotivo(int finalPlaca) {
		switch (finalPlaca) {
		case 1:
			return Calendar.APRIL;
		case 2:
			return Calendar.MAY;
		case 3:
			return Calendar.JUNE;
		case 4:
			return Calendar.JULY;
		case 5:
		case 6:
			return Calendar.AUGUST;
		case 7:
			return Calendar.SEPTEMBER;
		case 8:
			return Calendar.OCTOBER;
		case 9:
			return Calendar.NOVEMBER;
		case 0:
			return Calendar.DECEMBER;

		}
		// No pior das hipotese paga no começo
		return Calendar.SEPTEMBER;
	}

	public static int getMesCRLVCaminhao(int finalPlaca) {
		switch (finalPlaca) {
		case 1:
		case 2:
			return Calendar.SEPTEMBER;
		case 3:
		case 4:
		case 5:
			return Calendar.OCTOBER;
		case 6:
		case 7:
		case 8:
			return Calendar.NOVEMBER;
		case 9:
		case 0:
			return Calendar.DECEMBER;

		}
		// No pior das hipotese paga no começo
		return Calendar.SEPTEMBER;
	}
}
