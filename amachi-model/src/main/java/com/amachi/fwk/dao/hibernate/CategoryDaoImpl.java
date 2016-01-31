/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.CategoryDao;
import com.amachi.fwk.model.Category;

/**
 * CategoryDaoImpl
 * @author tuma
 * @date Feb 1, 2015
 *
 */
@Repository
public class CategoryDaoImpl extends GenericHibernateSpringDao<Category, Integer> implements CategoryDao {

	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.CategoryDao#findByName(java.lang.String)
	 */
	@Override
	public boolean findByName(String name) {
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idCategory"),"idCategory"));
		return criteria.uniqueResult() != null;
	}
	
}
