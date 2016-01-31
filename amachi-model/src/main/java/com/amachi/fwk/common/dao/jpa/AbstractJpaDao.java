/**
 * 
 */
package com.amachi.fwk.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.transaction.annotation.Transactional;

/**
 * @author tuma
 * 
 */
public class AbstractJpaDao<T, PK extends Serializable> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	//@Transactional
	public T insert(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	//@Transactional
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	//@Transactional(readOnly = true)
	public T findByPK(Class<T> typeClass, PK paramID) {
		return entityManager.find(typeClass, paramID);
	}

	@SuppressWarnings("unchecked")
	//@Transactional(readOnly = true)
	public List<T> getAll(Class<T> typeClass) {
		return entityManager.createQuery( "from " + clazz.getName()).getResultList();
	}

	//@Transactional
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	//@Transactional
	public void deleteByPK(Class<T> typeClass, PK paramID) {
		T paramT = findByPK(typeClass, paramID);
		if (paramT != null)
			delete(paramT);

	}

	//@Transactional
	public T merge(T entity) {
		entity = entityManager.merge(entity);
		return entity;
	}

	//@Transactional
	public void persist(T entity) {
		entityManager.persist(entity);
	}

	
	public void deleteList(List<T> beans) {
		// TODO Auto-generated method stub

	}

	
	public void saveOrUpdateList(List<T> beans) {
		// TODO Auto-generated method stub

	}
	
	/* (non-Javadoc)
	 * @see com.amachi.fwk.common.dao.IGenericDao#createOrUpdate(java.lang.Object)
	 */
	public T createOrUpdate(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
