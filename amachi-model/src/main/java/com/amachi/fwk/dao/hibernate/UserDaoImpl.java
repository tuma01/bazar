/**
 * 
 */
package com.amachi.fwk.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.amachi.fwk.common.dao.hibernate.GenericHibernateSpringDao;
import com.amachi.fwk.dao.UserDao;
import com.amachi.fwk.model.User;

 /**
 * UserDaoImpl
 * @author tuma
 * @date Dec 11, 2014
 *
 */
@Repository
public class UserDaoImpl extends GenericHibernateSpringDao<User, String> implements UserDao { /*
	 (non-Javadoc)
	 * @see com.amachi.bbb.dao.UserDao#findByName(java.lang.String)
	 */
	public User findByUserName(String userName) {
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", userName));
        return (User) criteria.uniqueResult();

	}
}
