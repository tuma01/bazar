package com.amachi.fwk.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.amachi.fwk.model.Role;
import com.amachi.fwk.model.User;
import com.amachi.fwk.util.StatusEnum;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
// @ContextConfiguration (locations =
// {"file:src/test/resources/fwkContextModel-test.xml"})
@TransactionConfiguration(defaultRollback = false, transactionManager = "txManager")
@Transactional
public class UserDaoTest {
	@Autowired
	private UserDao dao;

	@Test
	public void getUserByPk() {
		User user = dao.findByPK(User.class, "tuma");
		assertNotNull(user);
	}
	
	@Test
	public void addUser() throws Exception {
		User user = new User();
		user.setEmail("tuma@msn.com");
		user.setPassword("tuma");
		user.setFirstname("Jose");
		user.setLastname("Larico");
		user.setUsername("pachamama");
		user.setStatus(StatusEnum.ACTIVE);
		Role role = new Role();
		role.setIdRole(1);
		role.setName("Admin");
		List<Role> roles = new ArrayList<Role>();
		//user.setRoles(roles);
		user = dao.createOrUpdate(user);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void updateUser() {
		User user = dao.findByPK(User.class,"test");
		user.setFirstname("LEA");
		
		user = dao.update(user);
		System.out.println(user.getFirstname());
	}
}
