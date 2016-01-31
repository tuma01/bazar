/**
 * 
 */
package com.amachi.fwk.common.dao;

import java.io.Serializable;
import java.util.List;


/**
 * @author tuma
 * 
 */
public abstract interface GenericDao<T, ID extends Serializable> {
	
	/**
	 * @param paramT
	 * @return
	 */
	public abstract T create(T paramT);

	/**
	 * @param paramT
	 * @return
	 */
	public abstract T update(T paramT);

	/**
	 * @param paramT
	 * @return
	 */
	public abstract T createOrUpdate(T paramT);

	/**
	 * @param paramID
	 * @return
	 */
	public abstract T findById(ID paramID);

	/**
	 * @return
	 */
	public abstract List<T> loadAll();

	/**
	 * @param paramT
	 */
	public abstract void delete(T paramT);

	/**
	 * @param paramID
	 */
	public abstract void deleteById(ID paramID);

	/**
	 * @param entity
	 * @return
	 */
	public abstract T merge(T entity);

	/**
	 * @param transientInstance
	 */
	public abstract void persist(T transientInstance);

	/**
	 * @param instance
	 */
	public abstract void attachDirty(T instance);

	/**
	 * @param instance
	 */
	public abstract void attachClean(T instance);
	
	/**
	 * @param beans
	 */
	public abstract void deleteList(List<T> beans);

	/**
	 * @param beans
	 */
	public abstract void saveOrUpdateList(List<T> beans);
	

	/**
	 * @param id
	 * @return
	 */
	public abstract T load(ID id);
	
}
