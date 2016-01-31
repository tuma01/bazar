package com.amachi.fwk.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * CategoryCriterioId
 * @author tuma
 * @date Sep 28, 2015
 *
 */
@Embeddable
public class CriterioCategoryId implements Serializable {

    /**
     * serialVersionUID
     * Sep 28, 2015
     */
    private static final long serialVersionUID = -5354215986988074728L;
    
    //@JoinColumn(name = "FK_ID_CRITERIO", referencedColumnName = "ID_CRITERIO", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIO_ID"))
    @JoinColumn(name = "FK_ID_CRITERIO", referencedColumnName = "ID_CRITERIO", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIOCATEGORY_CRITERIO"))
    @ManyToOne
    private Criterio criterio;
    
    //@JoinColumn(name = "FK_ID_CATEGORY", referencedColumnName = "ID_CATEGORY", nullable = false, foreignKey=@ForeignKey(name="FK_CATEGORY_ID"))
    @JoinColumn(name = "FK_ID_CATEGORY", referencedColumnName = "ID_CATEGORY", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIOCATEGORY_CATEGORY"))
    @ManyToOne
    private Category category;
    
    @JoinColumn(name = "FK_ID_ANUNCIO", referencedColumnName = "ID_ANUNCIO", nullable = false, foreignKey=@ForeignKey(name="FK_CRITERIOCATEGORY_ANUNCIO"))
    @ManyToOne
    private Anuncio anuncio;
    
    /**
	 * Constructor
	 */
	public CriterioCategoryId() {

	}
	/**
     * Attribute getter category
     * @return category
     */
    public Category getCategory() {
        return category;
    }
    /**
     * Attribute setter category
     * @param category category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * Attribute getter criterio
     * @return criterio
     */

    public Criterio getCriterio() {
        return criterio;
    }
    /**
     * Attribute setter criterio
     * @param criterio criterio
     */
    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
   
	/**
	 * Attribute getter anuncio
	 * @return anuncio
	 */
	public Anuncio getAnuncio() {
		return anuncio;
	}
	/**
	 * Attribute setter anuncio
	 * @param anuncio anuncio
	 */
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anuncio == null) ? 0 : anuncio.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		CriterioCategoryId other = (CriterioCategoryId) obj;
		if (anuncio == null) {
			if (other.anuncio != null)
				return false;
		} else if (!anuncio.equals(other.anuncio))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (criterio == null) {
			if (other.criterio != null)
				return false;
		} else if (!criterio.equals(other.criterio))
			return false;
		return true;
	}
	
}
