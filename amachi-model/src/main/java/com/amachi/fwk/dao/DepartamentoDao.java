package com.amachi.fwk.dao;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.Departamento;


public interface DepartamentoDao extends IGenericDao<Departamento, Integer> {

	/**
	 * Method findByNameAndPayId
	 * @param dtoName
	 * @param paysIdSelected
	 * @return
	 * @return boolean
	 */
	boolean findByNameAndPayId(String dtoName, Integer paysIdSelected);

}
