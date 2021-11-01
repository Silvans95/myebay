package it.prova.myebay.service.annuncio;

import java.util.List;

import it.prova.myebay.dao.annuncio.AnnuncioDAO;
import it.prova.myebay.dao.categoria.CategoriaDAO;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Categoria;


public interface AnnuncioService  {
	
	public List<Annuncio> listAll() throws Exception;

	public Annuncio caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Annuncio annuncioInstance) throws Exception;

	public void inserisciNuovo(Annuncio annuncioInstance) throws Exception;

	public void rimuovi(Annuncio annuncioInstance) throws Exception;
	
	void aggiungiCategoria(Annuncio annuncioEsistente, Categoria categoriaInstance) throws Exception;
	
	//per injection
	public void setAnnuncioDAO(AnnuncioDAO annuncioDAO);

	List<Annuncio> findByExample(Annuncio example) throws Exception;

	void setCategoriaDAO(CategoriaDAO categoriaDAO);

	void inserisciNuovoConCategorie(Annuncio annuncioInstance, String[] categoriaInstance) throws Exception;

	void rimuovi(Long idAnnuncioToRemove) throws Exception;



}
