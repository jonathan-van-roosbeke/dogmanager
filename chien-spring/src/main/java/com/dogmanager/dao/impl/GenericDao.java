package com.dogmanager.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class GenericDao<T, K extends Serializable> {
	private static final String PERSISTENCE_UNIT_NAME = "CDA_PU";
	private EntityManagerFactory emf;
	protected EntityManager em;
	protected Class<T> entity;

	public GenericDao(Class<T> entity) {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
		this.entity = entity;
	}

	public T save(T obj) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return obj;
	}

	public void update(T obj) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	public void delete(T obj) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public T findById(K id) {
		return em.find(entity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("from " + entity.getName()).getResultList();
	}
}
