package com.amachi.fwk.util;

import java.util.HashMap;
import java.util.Set;

import com.amachi.fwk.model.Category;

/**
 * TreeImpl
 * 
 * @author tuma
 * @date Feb 17, 2015
 *
 */
public class TreeImpl extends HashMap<Integer, Category> {
	/**
	 * serialVersionUID
	 * Feb 17, 2015
	 */
	private static final long serialVersionUID = 1L;
	public static Integer ROOT_PARENT = null;// "-1";

	public boolean put(Category catBean) {
		boolean insertStatus = false;
		Integer parentID = null;
		if (catBean.getParentCategory() != null) {
			parentID = catBean.getParentCategory().getIdCategory();
		}
		if (this.containsKey(parentID)) {
			Category parent = (Category) this.get(parentID);
			Set<Category> children = parent.getSubCategories();
//			if (null == children) {
//				children = new HashSet<Category>();
//			}
			children.add(catBean);
			parent.setSubCategories(children);
//			this.put(parent.getCategoryId(), parent);
//			this.put(catBean.getCategoryId(), catBean);
			insertStatus = true;
		} else if (ROOT_PARENT==parentID) {
			System.out.println("Root Node added");
			this.put(catBean.getIdCategory(), catBean);
		} else {
			System.out.println("No such parent exist");
		}
		return insertStatus;
	}

	public Object get(String key) {
		return super.get(key);
	}
}