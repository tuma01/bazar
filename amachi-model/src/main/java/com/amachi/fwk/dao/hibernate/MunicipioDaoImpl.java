/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.MunicipioDao;
import com.amachi.fwk.model.Municipio;

/**
 * MunicipioDaoImpl
 * @author tuma
 * @date Feb 1, 2015
 *
 */
@Repository
public class MunicipioDaoImpl extends GenericHibernateSpringDao<Municipio, Integer> implements MunicipioDao {

	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.MunicipioDao#findByNameAndPayId(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean findByNameAndPayId(String munName, Integer departamentoIdSelected) {
		Criteria criteria = getSession().createCriteria(Municipio.class);
		criteria.createAlias("departamento","departamento", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("name", munName));
		criteria.add(Restrictions.eq("departamento.idDepartamento", departamentoIdSelected));
		criteria.setProjection(Projections.projectionList().add(Projections.property("idMunicipio"),"idMunicipio"));
		return criteria.uniqueResult() != null;
	}


	/* (non-Javadoc)
	 * @see com.amachi.fwk.dao.MunicipioDao#getMunicipiosByIdDepartamento(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> getMunicipiosByIdDepartamento(Integer idDepartamento) {
		Criteria criteria = getSession().createCriteria(Municipio.class);
		criteria.add(Restrictions.eq("departamento.idDepartamento", idDepartamento));
		//criteria.setProjection(Projections.projectionList().add(Projections.property("idCategory"),"idCategory"));
		return criteria.list();
	}
}
