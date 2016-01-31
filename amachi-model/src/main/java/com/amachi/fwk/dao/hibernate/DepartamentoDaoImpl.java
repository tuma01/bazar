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
import com.amachi.fwk.dao.DepartamentoDao;
import com.amachi.fwk.model.Departamento;

/**
 * DepartamentoDaoImpl
 * @author tuma
 * @date Jan 23, 2015
 *
 */
@Repository
public class DepartamentoDaoImpl extends GenericHibernateSpringDao<Departamento, Integer> implements DepartamentoDao {

	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.DepartamentoDao#findByNameAndPayId(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean findByNameAndPayId(String dtoName, Integer paysIdSelected) {
		Criteria criteria = getSession().createCriteria(Departamento.class);
		criteria.createAlias("pays","pays", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("name", dtoName));
		criteria.add(Restrictions.eq("pays.idPays", paysIdSelected));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idDepartamento"),"idDepartamento"));
		return criteria.uniqueResult() != null;
	}
}
