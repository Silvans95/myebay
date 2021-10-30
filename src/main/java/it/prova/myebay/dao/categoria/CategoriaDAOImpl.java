package it.prova.myebay.dao.categoria;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.myebay.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Categoria> list() throws Exception {
		// TODO Auto-generated method stubù
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Optional<Categoria> findOne(Long id) throws Exception {
		Categoria result = entityManager.find(Categoria.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(categoriaInstance);

	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria findByDescrizioneAndCodice(String descrizione, String codice) throws Exception {
		TypedQuery<Categoria> query = entityManager
				.createQuery("select r from Categoria r where r.descrizione=?1 and r.codice=?2", Categoria.class)
				.setParameter(1, descrizione).setParameter(2, codice);

		return query.getResultStream().findFirst().orElse(null);
	}

}