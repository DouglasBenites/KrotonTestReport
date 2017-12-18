package br.com.kroton.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericDAO<T> {
	private EntityManagerFactory emf;
	public EntityManager em;
	private final Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.emf = Persistence.createEntityManagerFactory("KrotonTestJPA");
		this.em = emf.createEntityManager();
	}

	public List<T> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
		Root<T> meta = cq.from(this.entityClass);
		meta.getFetches();
		CriteriaQuery<T> all = cq.select(meta);
		TypedQuery<T> allQuery = em.createQuery(all);
		
		List<T> resultList = allQuery.getResultList();
		return resultList;
	}
	
	public T getById(Integer id){
		return em.find(entityClass, id);
	}
	
	public T insert(T entity){
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}
	
	public T update(T entity){
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}
	
	public void remove(T entity){
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
	
	public void removeById(Integer id){
		em.getTransaction().begin();
		T entity = this.getById(id);
		em.remove(entity);
		em.getTransaction().commit();
	}
	
}
