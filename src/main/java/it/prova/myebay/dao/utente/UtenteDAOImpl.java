package it.prova.myebay.dao.utente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.myebay.model.Ruolo;
import it.prova.myebay.model.StatoUtente;
import it.prova.myebay.model.Utente;

public class UtenteDAOImpl implements UtenteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Utente> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Utente", Utente.class).getResultList();
	}

	@Override
	public Optional<Utente> findOne(Long id) throws Exception {
		Utente result = entityManager.find(Utente.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		utenteInstance = entityManager.merge(utenteInstance);
	}

	@Override
	public void insert(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(utenteInstance);
	}

	@Override
	public void delete(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(utenteInstance));
	}

//############################# FINE CRUD INIZIO METODI DI RICERCA ##########################################

	// questo metodo ci torna utile per capire se possiamo rimuovere un ruolo non
	// essendo collegato ad un utente
	public List<Utente> findAllByRuolo(Ruolo ruoloInput) {
		TypedQuery<Utente> query = entityManager.createQuery("select u FROM Utente u join u.ruoli r where r = :ruolo",
				Utente.class);
		query.setParameter("ruolo", ruoloInput);
		return query.getResultList();
	}

	@Override
	public Optional<Utente> findByUsernameAndPassword(String username, String password) {
		TypedQuery<Utente> query = entityManager.createQuery(
				"select u FROM Utente u  " + "where u.username = :username and u.password=:password ", Utente.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return query.getResultStream().findFirst();
	}

	@Override
	public List<Utente> findByExample(Utente example) throws Exception {

		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select r from Utente r where r.id = r.id ");

		if (StringUtils.isNotEmpty(example.getNome())) {
			whereClauses.add(" r.nome  like :nome ");
			paramaterMap.put("nome", "%" + example.getNome() + "%");
		}
		if (StringUtils.isNotEmpty(example.getCognome())) {
			whereClauses.add(" r.cognome like :cognome ");
			paramaterMap.put("cognome", "%" + example.getCognome() + "%");
		}
		if (StringUtils.isNotEmpty(example.getUsername())) {
			whereClauses.add(" r.username like :username ");
			paramaterMap.put("username", "%" + example.getUsername() + "%");
		}

		if (example.getCreditoResiduo() != null) {
			whereClauses.add(" r.creditoResiduo like :creditoResiduo ");
			paramaterMap.put("creditoResiduo", "%" + example.getCreditoResiduo() + "%");
		}

		if (example.getDateCreated() != null) {
			whereClauses.add("r.dateCreated >= :dateCreated ");
			paramaterMap.put("dateCreated", example.getDateCreated());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Utente> typedQuery = entityManager.createQuery(queryBuilder.toString(), Utente.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();

	}

//#######################################################################

	@Override
	public Optional<Utente> login(String username, String password) {
		TypedQuery<Utente> query = entityManager.createQuery(
				"select u FROM Utente u join fetch u.ruoli r "
						+ "where u.username = :username and u.password=:password and u.stato=:statoUtente",
				Utente.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("statoUtente", StatoUtente.ATTIVO);
		return query.getResultStream().findFirst();
	}

}