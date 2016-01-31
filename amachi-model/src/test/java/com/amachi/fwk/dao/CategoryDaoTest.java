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
import com.amachi.fwk.util.TreeImpl;

/**
 * @author tuma
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fwkContextModel-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional
public class CategoryDaoTest {

	// @Qualifier("paysDao")
	@Autowired
	private CategoryDao dao;

	@Test
	public void getAllCategoryTest() {
		List<Category> categoriesDto = dao.getAll(Category.class);
		List<String> items = new ArrayList<String>();
		for (Category category : categoriesDto) {
			System.out.println(getCat(category, null));
		}

	}

	@Test
	public void allCategoryTest() {
		List<Category> categories = dao.getAll(Category.class);
		
		TreeImpl t = new TreeImpl();  
		for (Category cat : categories) {
 
			  populateTree(t, cat);    
			  //parseTree(t, cat.getCategoryId()); 
		

		}
		System.out.println(t.toString());
		for(Entry<Integer, Category> entry : t.entrySet()) {
		    Integer key = entry.getKey();
		    Category value = entry.getValue();
		    System.out.println("FOR " + value.getIdCategory() + " : " + value.getName());
		    parseTree(t, key);
		    // do what you have to do here
		    // In your case, an other loop.
		}

	}
	
	private static void parseTree(TreeImpl t, Integer location) {
		Category cat = (Category) t.get(location);
		if (null != cat) {
			System.out.println(cat.getName() + "=>");
			//List<Category> categoryList = cat.getSubCategories();
			loop(cat.getSubCategories(),0);
		}
	}
	private static void loop(Set<Category> categoryList, int nb) {
		if (!CollectionUtils.isEmpty(categoryList)) {
			//int nb = 0;
			String text = "";
			for(int x=0 ; x<nb; x++){
				text +="-";
			}
			for(Category category : categoryList) {
				System.out.println("\t" +text + category.getIdCategory() + " : " + category.getName());
				if(!CollectionUtils.isEmpty(category.getSubCategories())) {
					loop(category.getSubCategories(), nb+1);	
				}
				//parseTree(t, category.getCategoryId());
			}
			System.out.println();
		} else {
			//System.out.println(cat.getCategoryId() + " : " + cat.getName());
		}
	}

	

	private void displayCategories(Set<Category> categories) {
		System.out.println("<ul>");
		for (Category category : categories) {
			System.out.println("<li>");
			System.out.println(category.getName());
			System.out.println("</li>");
			if (category.getSubCategories().size() > 0) {
				displayCategories(category.getSubCategories());
			}
		}
		System.out.println("</ul>");
	}

	private String getCat(Category category, Integer id) {
		if (category.getParentCategory() != null) {
			// for (Category dto : category.getSubCategories()) {
			System.out.println(category.getIdCategory() + "_" + category.getName());
			// items.add(category.getCategoryId() + "_" + category.getName());
			// }
			// return category;
		}
		return category.getIdCategory() + "_" + category.getName();

	}
	

	private static void populateTree(TreeImpl t, Category category) {
		//Category category = new Category();
		// root.setParentCategory(TreeImpl.ROOT_PARENT);
		t.put(category);
//		if (category.getParentCategory() == null) {
//			category.setParentCategory(null);
//			category.setCategoryId(-1);
//			category.setName("ROOT");
//			t.put(category);
//		} else {
//			t.put(category);
//		}
	}

}
