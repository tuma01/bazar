/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.GroupDao;
import com.amachi.fwk.model.Grupo;




/**
 * @author tuma
 *
 */
@Repository
public class UserGroupDaoImpl extends GenericHibernateSpringDao<Grupo, Long> implements GroupDao {
	
}
