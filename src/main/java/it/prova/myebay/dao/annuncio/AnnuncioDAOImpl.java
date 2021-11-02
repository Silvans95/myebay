package it.prova.myebay.dao.annuncio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Annuncio;

public class AnnuncioDAOImpl implements AnnuncioDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Annuncio> list() throws Exception {
		// dopo la from bisogna specificare il testoAnnuncio dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Annuncio", Annuncio.class).getResultList();
	}

	@Override
	public Optional<Annuncio> findOne(Long id) throws Exception {
		Annuncio result = entityManager.find(Annuncio.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Annuncio annuncioInstance) throws Exception {
		if (annuncioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		annuncioInstance = entityManager.merge(annuncioInstance);
	}

	@Override
	public void insert(Annuncio annuncioInstance) throws Exception {
		if (annuncioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(annuncioInstance);
	}

	@Override
	public void delete(Annuncio annuncioInstance) throws Exception {
		if (annuncioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(annuncioInstance));
	}

//############################# FINE CRUD INIZIO METODI DI RICERCA ##########################################

	@Override
	public List<Annuncio> findByExample(Annuncio example) throws Exception {

		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select distinct r from Annuncio r join fetch r.utente u join r.categorie c  where r.id = r.id ");
		
		if (StringUtils.isNotEmpty(example.getTestoAnnuncio())) {
			whereClauses.add(" r.testoAnnuncio  like :testoAnnuncio ");
			paramaterMap.put("testoAnnuncio", "%" + example.getTestoAnnuncio() + "%");
		}

		if (example.getPrezzo() != null) {
			whereClauses.add(" r.prezzo > :prezzo ");
			paramaterMap.put("prezzo", example.getPrezzo());
		}
		if (example.getUtente() != null) {
			whereClauses.add(" r.utente.id =:utente ");
			paramaterMap.put("utente", example.getUtente().getId());
		}
		if(example.getCategorie() != null && !example.getCategorie().isEmpty()) {
			whereClauses.add("c in :listaCategorie ");
			paramaterMap.put("listaCategorie", example.getCategorie());
		}
		
		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Annuncio> typedQuery = entityManager.createQuery(queryBuilder.toString(), Annuncio.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();

	}

}
