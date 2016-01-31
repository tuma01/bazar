/**
 * 
 */
package com.amachi.fwk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.amachi.fwk.common.model.Model;

/**
 * UserConnexion
 * @author tuma
 * @date Dec 6, 2015
 *
 */
@Embeddable
public class UserConnexion implements Model {

	private static final long serialVersionUID = 3485134635895050068L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, length = 19)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", length = 19)
	private Date modifiedDate;
	
	@Column(name = "CREATED_BY", nullable = false, length = 50)
	private String createdBy;
	
	@Column(name = "MODIFIED_BY", length = 50)
	private String modifiedBy;

	/**
	 * Constructor
	 */
	public UserConnexion() {
	}
	
	/**
	 * Constructor
	 */
	public UserConnexion(String createdBy, Date createdDate) {
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	/**
	 * Attribute getter createdDate
	 * @return createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Attribute setter createdDate
	 * @param createdDate createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Attribute getter modifiedDate
	 * @return modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Attribute setter modifiedDate
	 * @param modifiedDate modifiedDate
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Attribute getter createdBy
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Attribute setter createdBy
	 * @param createdBy createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Attribute getter modifiedBy
	 * @return modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Attribute setter modifiedBy
	 * @param modifiedBy modifiedBy
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
