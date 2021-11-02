package it.prova.myebay.dao.annuncio;

import java.util.List;

import it.prova.myebay.dao.IBaseDAO;
import it.prova.myebay.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
	
	List<Annuncio> findByExample(Annuncio example) throws Exception;

	
}
