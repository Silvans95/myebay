package it.prova.myebay.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.StatoUtente;
import it.prova.myebay.model.Utente;

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

	// ##########################################################################################

	public static Annuncio createAnnuncioFromParams(String testoAnnuncioParam, String prezzoParamInput) {

//		questo metodo crea un utente e automaticamente gli mette la data e lo stato aperto

		Date dataCreatedParam = new Date();
		Annuncio result = new Annuncio(testoAnnuncioParam, dataCreatedParam);

		if (NumberUtils.isCreatable(prezzoParamInput)) {
			result.setPrezzo(Integer.parseInt(prezzoParamInput));
		}
		result.setAperto(true);

		return result;
	}

	public static boolean validateAnnuncioBean(Annuncio annuncioToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(annuncioToBeValidated.getTestoAnnuncio())
				|| StringUtils.isBlank(annuncioToBeValidated.getUtenteInserimento())
				|| annuncioToBeValidated.getPrezzo() == null || annuncioToBeValidated.getDataAnnuncio() == null) {
			return false;
		}
		return true;
	}
	
	
	public static Utente createUtenteFromParams(String nomeInputParam, String cognomeInputParam,
			String usernameInputParam, String passwordInputParam) {

		Date dataCreatedParam = new Date();
		
		Utente result = new Utente(usernameInputParam, passwordInputParam, nomeInputParam, cognomeInputParam, dataCreatedParam);
		result.setCreditoResiduo(0);
		result.setStato(StatoUtente.CREATO);
		return result;
	}

	public static boolean validateUtenteBean(Utente utenteToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(utenteToBeValidated.getNome())
				|| StringUtils.isBlank(utenteToBeValidated.getCognome())
				|| StringUtils.isBlank(utenteToBeValidated.getUsername()) 
				|| StringUtils.isBlank(utenteToBeValidated.getPassword()) 
				|| utenteToBeValidated.getStato() == null
				|| utenteToBeValidated.getDateCreated() == null) {
			return false;
		}
		return true;
	}

}
