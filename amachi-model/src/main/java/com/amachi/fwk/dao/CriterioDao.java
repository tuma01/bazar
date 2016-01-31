package com.amachi.fwk.dao;

import java.util.List;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.Criterio;


/**
 * CriterioDao
 * @author tuma
 * @date Feb 20, 2015
 *
 */
public interface CriterioDao extends IGenericDao<Criterio, Integer> {

	/**
	 * Method getCriterioByName
	 * @param name
	 * @return
	 * @return boolean
	 */
	boolean getCriterioByName(String name);
	
	List<Criterio> getAllCriterioByIdCategory(Integer idCategory);

}
