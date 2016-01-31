/**
 * 
 */
package com.amachi.fwk.common.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amachi.fwk.common.dao.IGenericDao;


//import java.util.logging.Logger;

/**
 * GenericHibernateDao class
 * 
 * @author jamachi
 * 
 * @param <T>
 * @param <PK>
 */
public abstract class GenericHibernateDao<T, PK extends Serializable> implements IGenericDao<T, PK> {
	// extends HibernateDaoSupport

	SessionFactory sessionFactory = null;
	Session session = HibernateUtil.getSession();

	/**
	 * the LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(GenericHibernateDao.class.getName());

	// private final Class<T> persistentClass;
	/**
	 * the persistentClass
	 */
	private final Class<T> persistentClass;

	
	 /**
	 * @param persistentClass
	 */
	 public GenericHibernateDao(final Class<T> persistentClass) {
		 this.persistentClass = persistentClass;
	 }

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		this.persistentClass = ((Class<T>) ((java.lang.reflect.ParameterizedType) super.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		T entity = (T) session.get(getPersistentClass(), id);
		return entity;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.fwk.dao.GenericDao#findByNamedQuery(java.lang.String,
	 * java.util.Map)
	 */
	public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		final Query query = (Query) session.getNamedQuery(queryName);
		session.getNamedQuery(queryName);

		final Iterator<String> i = queryParams.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			query.setParameter(key, queryParams.get(key));
		}

		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.fwk.dao.GenericDao#loadList(java.lang.String)
	 */
	public Collection<T> loadList(String query) {
		@SuppressWarnings("unchecked")
		List<T> list = session.createQuery(query).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.fwk.dao.GenericDao#loadAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		final Query query = session.createQuery("from " + persistentClass.getName());
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.m2m.fwk.dao.GenericDao#insert(java.lang.Object)
	 */
	public T insert(T entity) {
		LOGGER.log(Level.FINE, "persisting " + getPersistentClass().getName() + " instance");
		session.persist(entity);
		LOGGER.log(Level.FINE, "persist successful");
		return (entity);
	}

	public T update(T entity) {
		session.merge(entity);// update(entity);
		return entity;
	}

	public void deleteById(PK pk) {
		T entity = findById(pk);
		if (entity != null) {
			session.delete(entity);
		}
	}

	public void delete(T entity) {
		if (entity != null) {
			session.refresh(entity);
			session.delete(entity);
		}
	}

	public T create(T entity) {
		session.save(entity);
		return entity;
	}

	public T createOrUpdate(T entity) {
		session.saveOrUpdate(entity);

		return entity;
	}

	// public void saveOrUpdateList(Collection<T> beans) {
	// getHibernateTemplate().saveOrUpdateAll(beans);
	// }
	//
	// public void deleteList(Collection<T> beans) {
	// getHibernateTemplate().deleteAll(beans);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#merge(java.lang.Object)
	 */
	public T merge(T entity) {
		LOGGER.log(Level.FINE, "merging T instance");
		try {
			@SuppressWarnings("unchecked")
			T result = (T) session.merge(entity);
			LOGGER.log(Level.FINE, "merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}
	
	public void persist(T transientInstance) {
		LOGGER.log(Level.FINE, "persisting " + getPersistentClass().getName() + " instance");
		try {
			session.persist(transientInstance);
			LOGGER.log(Level.FINE, "persist successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#attachDirty(java.lang.Object)
	 */
	public void attachDirty(T instance) {
		LOGGER.log(Level.FINE, "attaching dirty T instance");
		try {
			session.saveOrUpdate(instance);
			LOGGER.log(Level.FINE, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amachi.fwk.v1.dao.GenericDao#attachClean(java.lang.Object)
	 */
	public void attachClean(T instance) {
		LOGGER.log(Level.FINE, "attaching clean T instance");
		try {
			session.buildLockRequest(LockOptions.NONE).lock(instance);
			LOGGER.log(Level.FINE, "attach successful");
		} catch (RuntimeException re) {
			LOGGER.log(Level.WARNING, "attach failed", re);
			throw re;
		}
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}
