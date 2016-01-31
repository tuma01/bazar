/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.CriterioValueDao;
import com.amachi.fwk.model.CriterioValue;

/**
 * CriterioValueDaoImpl
 * @author tuma
 * @date Feb 20, 2015
 *
 */
@Repository
public class CriterioValueDaoImpl extends GenericHibernateSpringDao<CriterioValue, Long> implements CriterioValueDao {

	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.CriterioValueDao#isValueByNameAndCriterioExists(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean isValueByNameAndCriterioExists(String name, Integer criterioId) {
		Criteria criteria = getSession().createCriteria(CriterioValue.class);
		criteria.createAlias("criterio","criterio", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("criterio.idCriterio", criterioId));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idCriterioValue"),"idCriterioValue"));
		return criteria.uniqueResult() != null;
	}
	
}
