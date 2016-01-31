package com.amachi.fwk.dao;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.CriterioValue;

/**
 * CriterioValueDao
 * @author tuma
 * @date Feb 20, 2015
 *
 */
public interface CriterioValueDao extends IGenericDao<CriterioValue, Long> {

	/**
	 * Method isValueByNameAndCriterioExists
	 * @param name
	 * @param criterioId
	 * @return
	 * @return boolean
	 */
	boolean isValueByNameAndCriterioExists(String name, Integer criterioId);
	
}
