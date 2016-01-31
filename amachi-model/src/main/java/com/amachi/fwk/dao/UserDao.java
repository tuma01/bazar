/**
 * 
 */
package com.amachi.fwk.dao;

import com.amachi.fwk.common.dao.IGenericDao;
import com.amachi.fwk.model.User;



/**
 * UserDao
 * @author tuma
 * @date 6 oct. 2011
 *
*/
public interface UserDao extends IGenericDao<User, String> {

	/**
	 * Method findByName
	 * @param userName
	 * @return
	 * @return User
	*/
	public User findByUserName(String userName);
}
