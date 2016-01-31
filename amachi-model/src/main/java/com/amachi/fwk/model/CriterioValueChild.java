package com.amachi.fwk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CriterioValueChild
 * @author tuma
 * @date Dec 27, 2015
 *
 */
@Embeddable
public class CriterioValueChild {

	@Column(name = "NAME_CRITERIO_VALUE", nullable = false, length = 50)
	private String nameCriterioValue;
	
	@Column(name = "VALUE_CHILD", nullable = false, length = 100)
	private String valueChild;
	
	/**
	 * Constructor
	 * @param nameCriterioValue
	 * @param valueChild
	 */
	public CriterioValueChild(String nameCriterioValue, String valueChild) {
		super();
		this.nameCriterioValue = nameCriterioValue;
		this.valueChild = valueChild;
	}
	
	/**
	 * Constructor
	 */
	public CriterioValueChild() {
	}

	/**
	 * Attribute getter nameCriterioValue
	 * @return nameCriterioValue
	 */
	public String getNameCriterioValue() {
		return nameCriterioValue;
	}
	/**
	 * Attribute setter nameCriterioValue
	 * @param nameCriterioValue nameCriterioValue
	 */
	public void setNameCriterioValue(String nameCriterioValue) {
		this.nameCriterioValue = nameCriterioValue;
	}
	/**
	 * Attribute getter valueChild
	 * @return valueChild
	 */
	public String getValueChild() {
		return valueChild;
	}
	/**
	 * Attribute setter valueChild
	 * @param valueChild valueChild
	 */
	public void setValueChild(String valueChild) {
		this.valueChild = valueChild;
	}
}
