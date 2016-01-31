package com.amachi.fwk.dao;

import java.util.List;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.Municipio;


/**
 * MunicipioDao
 * @author tuma
 * @date Feb 1, 2015
 *
 */
public interface MunicipioDao extends IGenericDao<Municipio, Integer> {

	/**
	 * Method findByNameAndPayId
	 * @param munName
	 * @param departamentoIdSelected
	 * @return
	 * @return boolean
	 */
	boolean findByNameAndPayId(String munName, Integer departamentoIdSelected);

	/**
	 * Method getMunicipiosByIdDepartamento
	 * @param idDepartamento
	 * @return
	 * @return List<Municipio>
	 */
	List<Municipio> getMunicipiosByIdDepartamento(Integer idDepartamento);


}
