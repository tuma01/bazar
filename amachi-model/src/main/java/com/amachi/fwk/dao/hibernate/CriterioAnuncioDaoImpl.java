/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.CriterioAnuncioDao;
import com.amachi.fwk.model.CriterioAnuncio;
import com.amachi.fwk.model.CriterioAnuncioId;

/**
 * CriterioDaoImpl
 * @author tuma
 * @date Feb 20, 2015
 *
 */
@Repository
public class CriterioAnuncioDaoImpl extends GenericHibernateSpringDao<CriterioAnuncio, CriterioAnuncioId> implements CriterioAnuncioDao {

	
}
