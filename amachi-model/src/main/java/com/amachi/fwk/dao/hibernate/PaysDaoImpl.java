/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.PaysDao;
import com.amachi.fwk.model.Pays;




/**
 * @author tuma
 *
 */
@Repository
public class PaysDaoImpl extends GenericHibernateSpringDao<Pays, Integer> implements PaysDao {
	public Boolean getPaysByName(String paysName) {
		Criteria criteria = getSession().createCriteria(Pays.class);
		criteria.add(Restrictions.eq("name", paysName));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idPays"),"idPays"));
		return criteria.uniqueResult() != null;
	}
}
