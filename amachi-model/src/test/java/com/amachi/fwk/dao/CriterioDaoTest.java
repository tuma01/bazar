package com.amachi.fwk.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.CollectionUtils;

import com.amachi.fwk.model.Category;
import com.amachi.fwk.model.Criterio;
import com.amachi.fwk.util.TreeImpl;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional
public class CriterioDaoTest {

	@Autowired
	private CriterioDao dao;

	@Test
	public void getAllCriterioTest() {
		List<Criterio> criterioDto = dao.getAll(Criterio.class);
		List<String> items = new ArrayList<String>();
		for (Criterio criterio : criterioDto) {
			System.out.println(criterio.getName());
		}

	}
}
