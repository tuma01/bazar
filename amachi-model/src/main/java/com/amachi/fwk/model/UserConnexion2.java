package com.amachi.fwk.model;


/**
 * UserConnexion2
 * @author tuma
 * @date Jan 18, 2016
 *
 */
public class UserConnexion2 {
	private String createdDate;
	
	/**
	 * Constructor
	 */
	public UserConnexion2() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructor
	 * @param createdDate
	 */
	public UserConnexion2(String createdDate) {
		super();
		this.createdDate = createdDate;
	}


	/**
	 * Attribute getter createdDate
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Attribute setter createdDate
	 * @param createdDate createdDate
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
