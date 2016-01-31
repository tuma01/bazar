package com.amachi.fwk.dao;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.Category;


public interface CategoryDao extends IGenericDao<Category, Integer> {

	/**
	 * Method findByName
	 * @param name
	 * @return
	 * @return boolean
	 */
	boolean findByName(String name);

}
