package com.amachi.fwk.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.amachi.fwk.model.Grupo;
import com.amachi.fwk.model.User;
import com.amachi.fwk.model.UserGrupo;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "txManager")
@Transactional
public class UserGroupDaoTest {
	
	@Autowired
	private UserGroupDao userGroupDao;
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private UserDao userDao;

	@Test
	public void userGroupDaoTest() {
		User user = new User("sam", "mas", "sam@gmail.com");
		 
		Grupo group = new Grupo("Designer");
		groupDao.createOrUpdate(group);
		 
		UserGrupo userGroup = new UserGrupo();
		userGroup.setGrupo(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		 
		user.addUserGroup(userGroup);
		 
		userDao.createOrUpdate(user);
		
		assertNotNull(user);
	}
}
