/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.AnuncioDao;
import com.amachi.fwk.model.Anuncio;

/**
 * CategoryDaoImpl
 * @author tuma
 * @date Feb 1, 2015
 *
 */
@Repository
public class AnuncioDaoImpl extends GenericHibernateSpringDao<Anuncio, Long> implements AnuncioDao {
	
}
