package it.prova.myebay.dao.acquisto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Acquisto;

public class AcquistoDAOImpl implements AcquistoDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Acquisto> list() throws Exception {
		// dopo la from bisogna specificare il descrizione dell'oggetto (lettera
		// maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Acquisto ", Acquisto.class).getResultList();
	}

	@Override
	public Optional<Acquisto> findOne(Long id) throws Exception {
		Acquisto result = entityManager.find(Acquisto.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Acquisto acquistoInstance) throws Exception {
		if (acquistoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		acquistoInstance = entityManager.merge(acquistoInstance);
	}

	@Override
	public void insert(Acquisto acquistoInstance) throws Exception {
		if (acquistoInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(acquistoInstance);
	}

	@Override
	public void delete(Acquisto acquistoInstance) throws Exception {
		if (acquistoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(acquistoInstance));
	}

//############################# FINE CRUD INIZIO METODI DI RICERCA ##########################################

	@Override
	public List<Acquisto> findByExample(Acquisto example) throws Exception {

		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select r from Acquisto  r where r.id = r.id ");

		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" r.descrizione   like :descrizione  ");
			paramaterMap.put("descrizione ", "%" + example.getDescrizione() + "%");
		}

		if (StringUtils.isNotEmpty(example.getUtenteAcquirente())) {
			whereClauses.add(" r.utenteAcquirente like :utenteAcquirente ");
			paramaterMap.put("utenteAcquirente", "%" + example.getUtenteAcquirente() + "%");
		}

		if (example.getPrezzo() != null) {
			whereClauses.add(" r.prezzo like :prezzo ");
			paramaterMap.put("prezzo", "%" + example.getPrezzo() + "%");
		}

		if (example.getDataAcquisto() != null) {
			whereClauses.add("r.dataAcquisto  >= :dataAcquisto  ");
			paramaterMap.put("dataAcquisto ", example.getDataAcquisto());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Acquisto> typedQuery = entityManager.createQuery(queryBuilder.toString(), Acquisto.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();

	}

}
