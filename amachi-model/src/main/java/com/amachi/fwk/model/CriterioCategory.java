package com.amachi.fwk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amachi.fwk.common.model.Model;

/**
 * CategoryCriterio
 * 
 * @author tuma
 * @date Sep 28, 2015
 */
@Entity
@Table(name = "CRITERIO_CATEGORY")
public class CriterioCategory implements Model {
	/**
	 * serialVersionUID Nov 27, 2015
	 */
	private static final long serialVersionUID = 880148774487578571L;

	@EmbeddedId
	private CriterioCategoryId criterioCategoryId = new CriterioCategoryId();

	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	private Date createdDate;

	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updateDate;
	
	

	/**
	 * Constructor
	 */
	public CriterioCategory() {
	}

	/**
	 * Attribute getter criterioCategoryId
	 * 
	 * @return criterioCategoryId
	 */
	public CriterioCategoryId getCriterioCategoryId() {
		return criterioCategoryId;
	}

	/**
	 * Attribute setter criterioCategoryId
	 * 
	 * @param criterioCategoryId
	 *            criterioCategoryId
	 */
	public void setCriterioCategoryId(CriterioCategoryId criterioCategoryId) {
		this.criterioCategoryId = criterioCategoryId;
	}

	/**
	 * Method getCategory
	 * 
	 * @return
	 * @return Category
	 */
	@Transient
	public Category getCategory() {
		return getCriterioCategoryId().getCategory();
	}

	/**
	 * Method setCategoy
	 * 
	 * @param category
	 * @return void
	 */
	public void setCategory(Category category) {
		getCriterioCategoryId().setCategory(category);
	}

	/**
	 * Method getCriterio
	 * 
	 * @return
	 * @return Criterio
	 */
	@Transient
	public Criterio getCriterio() {
		return getCriterioCategoryId().getCriterio();
	}

	/**
	 * Method setCriterio
	 * 
	 * @param criterio
	 * @return void
	 */
	public void setCriterio(Criterio criterio) {
		getCriterioCategoryId().setCriterio(criterio);
	}

	/**
	 * Method getAnuncio
	 * 
	 * @param anuncio
	 * @return void
	 */
	@Transient
	public void getAnuncio() {
		getCriterioCategoryId().getAnuncio();
	}

	/**
	 * Method setAnuncio
	 * 
	 * @param anuncio
	 * @return void
	 */
	public void setAnuncio(Anuncio anuncio) {
		getCriterioCategoryId().setAnuncio(anuncio);
	}

	/**
	 * Attribute getter description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Attribute setter description
	 * 
	 * @param description
	 *            description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Attribute getter createdDate
	 * 
	 * @return createdDate
	 */

	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Attribute setter createdDate
	 * 
	 * @param createdDate
	 *            createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Attribute getter updateDate
	 * 
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Attribute setter updateDate
	 * 
	 * @param updateDate
	 *            updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
