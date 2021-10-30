package it.prova.myebay.service.utente;

import java.util.List;

import it.prova.myebay.dao.ruolo.RuoloDAO;
import it.prova.myebay.dao.utente.UtenteDAO;
import it.prova.myebay.model.Ruolo;
import it.prova.myebay.model.Utente;


public interface UtenteService  {
	
	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;
	
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;
	
	public Utente findByUsernameAndPassword(String username, String password) throws Exception;
	
	public Utente accedi(String username, String password) throws Exception;

	//per injection
	public void setUtenteDAO(UtenteDAO utenteDAO);

	List<Utente> findByExample(Utente example) throws Exception;

	void setRuoloDAO(RuoloDAO ruoloDAO);

	void inserisciNuovoConRuoli(Utente utenteInstance, String[] ruoliInstance) throws Exception;

}