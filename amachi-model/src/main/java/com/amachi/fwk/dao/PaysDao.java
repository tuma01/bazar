package com.amachi.fwk.dao;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.Pays;


public interface PaysDao extends IGenericDao<Pays, Integer> {
	public Boolean getPaysByName(String paysName);
}
