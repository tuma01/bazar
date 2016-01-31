/**
 * 
 */
package com.amachi.fwk.common.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.IGenericDao;

/**
 * GenericHibernateDao class
 * 
 * @author jamachi
 * 
 * @param <T>
 * @param <PK>
 */
@Repository
public abstract class GenericHibernateSpringDao<T, PK extends Serializable> implements IGenericDao<T, PK> {
	// extends HibernateDaoSupport

	/**
	 * the LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericHibernateSpringDao.class);

	/**
	 * the persistentClass
	 */
	private Class<T> persistentClass;

	public GenericHibernateSpringDao(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public GenericHibernateSpringDao(final SessionFactory sessionFactory) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.sessionFactory = sessionFactory;
	}

//	@Resource(name = "sessionFactory")
	@Autowired
	private SessionFactory sessionFactory;

	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	protected Session getSession() {
//		return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public GenericHibernateSpringDao() {
		this.persistentClass = ((Class<T>) ((java.lang.reflect.ParameterizedType) super.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findByPK(Class<T> typeClass, PK id) {
		T entity = (T) getSession().get(typeClass, id);
		getSession().flush();
		return entity;
	}

	public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		final Query query = (Query) getSession().getNamedQuery(queryName);
		getSession().getNamedQuery(queryName);

		final Iterator<String> i = queryParams.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			query.setParameter(key, queryParams.get(key));
		}

		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	public List<T> loadList(String query) {
		@SuppressWarnings("unchecked")
		List<T> list = getSession().createQuery(query).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		final Query query = getSession().createQuery("from " + persistentClass.getName());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> typeClass) {
		final Query query = getSession().createQuery("from " + typeClass.getName());
		return query.list();
	}

	public T insert(T entity) {
		LOGGER.info("persisting " + getPersistentClass().getName() + " instance");
		getSession().persist(entity);
		LOGGER.info("persist successful");
		return (entity);
	}

	public T load(PK id) {
		LOGGER.info("persisting " + getPersistentClass().getName() + " instance");
		@SuppressWarnings("unchecked")
		T entity = (T) getSession().load(getPersistentClass(), id);
		return entity;
	}

	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}

	public T update(T entity) {
		getSession().merge(entity);
		getSession().flush();
		return entity;
	}

	public void delete(T entity) {
		if (entity != null) {
			getSession().refresh(entity);
			getSession().delete(entity);
		}
	}

	public void deleteByPK(Class<T> typeClass, PK id) {
		T entity = findByPK(typeClass, id);
		if (entity != null) {
			getSession().delete(entity);
		}
	}

	public T createOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#merge(java.lang.Object)
	 */
	public T merge(T entity) {
		LOGGER.info("merging " + getPersistentClass().getName() + " instance");
		try {
			@SuppressWarnings("unchecked")
			T result = (T) getSession().merge(entity);
			LOGGER.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#persist(java.lang.Object)
	 */
	public void persist(T transientInstance) {
		LOGGER.info("persisting " + getPersistentClass().getName() + " instance");
		try {
			getSession().persist(transientInstance);
			LOGGER.info("persist successful");
		} catch (RuntimeException re) {
			LOGGER.error("persist failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#attachDirty(java.lang.Object)
	 */
	public void attachDirty(T instance) {
		LOGGER.info("attaching dirty " + getPersistentClass().getName() + " instance");
		try {
			getSession().saveOrUpdate(instance);
			LOGGER.info("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#attachClean(java.lang.Object)
	 */
	public void attachClean(T instance) {
		LOGGER.info("attaching clean " + getPersistentClass().getName() + " instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance.getClass().getName(), LockMode.NONE);
			LOGGER.info("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}
}
