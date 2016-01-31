package com.amachi.fwk.dao;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.amachi.fwk.model.Pays;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional
public class PayDaoTest {
	
	//@Qualifier("paysDao")
	@Autowired
	private PaysDao paysDao;

	@Test
	public void paysDaoTest() {
		Pays pays = paysDao.findByPK(Pays.class, 1);
		assertNotNull(pays);
	}
}
