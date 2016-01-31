package com.amachi.fwk.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amachi.fwk.common.model.Model;

/**
 * AnuncioCriterio
 * 
 * @author tuma
 * @date Feb 11, 2015
 */
@Entity
@Table(name = "CRITERIO_ANUNCIO")
public class CriterioAnuncio implements Model {

	/**
	 * serialVersionUID
	 * Nov 27, 2015
	 */
	private static final long serialVersionUID = -7933840529947599484L;
	
	@EmbeddedId
	private CriterioAnuncioId criterioAnuncioId = new CriterioAnuncioId();
	
	@Column(name = "VALUE_PRINCIPAL", nullable = false, length = 250)
	private String valuePrincipal;
	
	@Column(name = "VALUE_OPTIONAL", length = 250)
	private String valueOptional;

	/**
	 * Attribute getter criterioAnuncioId
	 * @return criterioAnuncioId
	 */
	public CriterioAnuncioId getCriterioAnuncioId() {
		return criterioAnuncioId;
	}

	/**
	 * Attribute setter criterioAnuncioId
	 * @param criterioAnuncioId criterioAnuncioId
	 */
	public void setCriterioAnuncioId(CriterioAnuncioId criterioAnuncioId) {
		this.criterioAnuncioId = criterioAnuncioId;
	}

	/**
	 * Method getAnuncio
	 * 
	 * @return
	 * @return Anuncio
	 */
	@Transient
	public Anuncio getAnuncio() {
		return getCriterioAnuncioId().getAnuncio();
	}

	/**
	 * Method setAnuncio
	 * 
	 * @param anuncio
	 * @return void
	 */
	public void setAnuncio(Anuncio anuncio) {
		getCriterioAnuncioId().setAnuncio(anuncio);
	}

	/**
	 * Method getCriterio
	 * 
	 * @return
	 * @return Criterio
	 */
	@Transient
	public Criterio getCriterio() {
		return getCriterioAnuncioId().getCriterio();
	}

	/**
	 * Method setCriterio
	 * 
	 * @param criterio
	 * @return void
	 */
	public void setCriterio(Criterio criterio) {
		getCriterioAnuncioId().setCriterio(criterio);
	}

	/**
	 * Attribute getter valuePrincipal
	 * 
	 * @return valuePrincipal
	 */
	public String getValuePrincipal() {
		return valuePrincipal;
	}

	/**
	 * Attribute setter value
	 * 
	 * @param value
	 *            value
	 */
	public void setValuePrincipal(String valuePrincipal) {
		this.valuePrincipal = valuePrincipal;
	}

	/**
	 * Attribute getter valueOptional
	 * 
	 * @return valueOptional
	 */
	public String getValueOptional() {
		return valueOptional;
	}

	/**
	 * Attribute setter valueOptional
	 * 
	 * @param valueOptional
	 *            valueOptional
	 */
	public void setValueOptional(String valueOptional) {
		this.valueOptional = valueOptional;
	}

}
