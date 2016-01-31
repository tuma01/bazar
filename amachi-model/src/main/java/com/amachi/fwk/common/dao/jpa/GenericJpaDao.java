package com.amachi.fwk.common.dao.jpa;

import java.io.Serializable;

import com.amachi.fwk.common.dao.IGenericDao;

public class GenericJpaDao <T, PK extends Serializable> extends AbstractJpaDao<T, PK> implements IGenericDao< T, PK>{

	

}
