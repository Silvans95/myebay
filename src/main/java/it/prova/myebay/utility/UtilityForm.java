package it.prova.myebay.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Annuncio;

public class UtilityForm {

	public static Date parseDateArrivoFromString(String dataDiNascitaStringParam) {
		if (StringUtils.isBlank(dataDiNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataDiNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	//##########################################################################################
	
	public static Annuncio createAnnuncioFromParams(String testoAnnuncioParam, String prezzoParamInput) {

		
//		questo metodo crea un utente e automaticamente gli mette la data e lo stato aperto
		
		Date dataCreatedParam = new Date();
		Integer prezzoParam = Integer.parseInt(prezzoParamInput);
		Annuncio result = new Annuncio(testoAnnuncioParam, prezzoParam, dataCreatedParam);
		result.setAperto(true);
		
		return result;
	}

	public static boolean validateAnnuncioBean(Annuncio annuncioToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(annuncioToBeValidated.getTestoAnnuncio())
				|| StringUtils.isBlank(annuncioToBeValidated.getUtenteInserimento())
				|| annuncioToBeValidated.getPrezzo() == null
				|| annuncioToBeValidated.getDataAnnuncio() == null) {
			return false;
		}
		return true;
	}

	
}
