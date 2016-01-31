/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.UserGroupDao;
import com.amachi.fwk.model.UserGrupo;
import com.amachi.fwk.model.UserGrupoId;




/**
 * @author tuma
 *
 */
@Repository
public class GroupDaoImpl extends GenericHibernateSpringDao<UserGrupo, UserGrupoId> implements UserGroupDao {
	
}
