/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.CriterioDao;
import com.amachi.fwk.model.Criterio;

/**
 * CriterioDaoImpl
 * @author tuma
 * @date Feb 20, 2015
 *
 */
@Repository
public class CriterioDaoImpl extends GenericHibernateSpringDao<Criterio, Integer> implements CriterioDao {

	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.CriterioDao#getCriterioByName(java.lang.String)
	 */
	@Override
	public boolean getCriterioByName(String name) {
		Criteria criteria = getSession().createCriteria(Criterio.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idCriterio"),"idCriterio"));
		return criteria.uniqueResult() != null;
	}

    /* (non-Javadoc)
     * @see com.amachi.fwk.dao.CriterioDao#getAllCriterioByIdCategory(java.lang.Integer)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Criterio> getAllCriterioByIdCategory(Integer idCategory) {
//        String queryString ="SELECT * FROM CRITERIO WHERE FK_ID_CATEGORY=:idCategory";
//        SQLQuery query = getSession().createSQLQuery(queryString);
//        query.addEntity(Criterio.class);
//        query.setInteger("idCategory", idCategory);
//        List<Criterio> criterios =  query.list();
        
        String hql = "FROM Criterio crit WHERE crit.category.idCategory = :idCategory ORDER BY crit.name ASC";
        Query query = getSession().createQuery(hql);
        query.setInteger("idCategory",idCategory);
        List<Criterio> results = query.list();
        return results;
    }
}
