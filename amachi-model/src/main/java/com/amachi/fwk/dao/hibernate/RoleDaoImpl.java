package com.amachi.fwk.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.RoleDao;
import com.amachi.fwk.model.Role;

/**
 * RoleDaoImpl
 * @author tuma
 * @date Jan 15, 2015
 *
 */
@Repository
public class RoleDaoImpl extends GenericHibernateSpringDao<Role, Integer> implements RoleDao {


}
