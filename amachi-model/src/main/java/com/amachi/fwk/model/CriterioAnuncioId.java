package com.amachi.fwk.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * AdvertisementCriteriaId
 * 
 * @author admin
 * @date 2014-04-15
 */
@Embeddable
public class CriterioAnuncioId implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3337740376246972017L;
	
	@JoinColumn(name = "FK_ID_CRITERIO", referencedColumnName = "ID_CRITERIO", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIOANUNCIO_CRITERIO"))
    @ManyToOne(cascade = CascadeType.REMOVE)
	private Criterio criterio;
	
    @JoinColumn(name = "FK_ID_ANUNCIO", referencedColumnName = "ID_ANUNCIO", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIOANUNCIO_ANUNCIO"))
    @ManyToOne(cascade = CascadeType.REMOVE)
	private Anuncio anuncio;
	
	/**
	 * Constructor
	 */
	public CriterioAnuncioId() {
		
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	/**
	 * Method setAnuncio
	 * 
	 * @param anuncio
	 * @return void
	 */
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	/**
	 * Method getCriterio
	 * 
	 * @return
	 * @return Criterio
	 */
	public Criterio getCriterio() {
		return criterio;
	}

	/**
	 * Method setCriterio
	 * 
	 * @param criterio
	 * @return void
	 */
	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anuncio == null) ? 0 : anuncio.hashCode());
		result = prime * result + ((criterio == null) ? 0 : criterio.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriterioAnuncioId other = (CriterioAnuncioId) obj;
		if (anuncio == null) {
			if (other.anuncio != null)
				return false;
		} else if (!anuncio.equals(other.anuncio))
			return false;
		if (criterio == null) {
			if (other.criterio != null)
				return false;
		} else if (!criterio.equals(other.criterio))
			return false;
		return true;
	}

}
