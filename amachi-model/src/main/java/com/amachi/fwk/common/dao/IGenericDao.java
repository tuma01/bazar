/**
 * 
 */
package com.amachi.fwk.common.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;


/**
 * @author tuma
 *
 */
@Repository
public interface IGenericDao<T, PK extends Serializable> {
	

	/**
	 * @param entity
	 * @return
	 */
	public T insert(T entity);
	
	/**
	 * Method update
	 * @param entity
	 * @return
	 * @return T
	 */
	public T update(T entity); 

	/**
	 * @param id
	 * @return
	 */
	public T findByPK(Class<T> typeClass, PK paramID);
	
	/**
	 * @param typeClass
	 * @return
	 */
	public List<T> getAll(Class<T> typeClass); 

	/**
	 * @param paramT
	 */
	public void delete(T entity);

	/**
	 * @param typeClass
	 * @param paramID
	 */
	public void deleteByPK(Class<T> typeClass, PK paramID);

	/**
	 * @param entity
	 * @return
	 */
	public T merge(T entity);

	/**
	 * @param transientInstance
	 */
	public void persist(T entity);
	
	
	/**
	 * Method createOrUpdate
	 * @param entity
	 * @return
	 * @return T
	 */
	public T createOrUpdate(T entity);

	
//	/**
//	 * @param beans
//	 */
//	public void deleteList(List<T> beans);

	
}
