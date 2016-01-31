/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.CriterioCategoryDao;
import com.amachi.fwk.model.CriterioCategory;
import com.amachi.fwk.model.CriterioCategoryId;

/**
 * CriterioCategoryDaoImpl
 * @author tuma
 * @date Nov 28, 2015
 *
 */
@Repository
public class CriterioCategoryDaoImpl extends GenericHibernateSpringDao<CriterioCategory, CriterioCategoryId> implements CriterioCategoryDao {

	
}
