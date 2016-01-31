package com.amachi.fwk.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.amachi.fwk.common.model.Model;
import com.amachi.fwk.util.TypeFieldEnum;

/**
 * CriterioValue
 * 
 * @author tuma
 * @date Dec 6, 2015
 */
@Entity
@Table(name = "CRITERIO_VALUE", uniqueConstraints = @UniqueConstraint(name = "UK_NAME_CRITERIO_VALUE", columnNames = { "NAME" }))
public class CriterioValue implements Model {
	/**
	 * serialVersionUID Apr 19, 2015
	 */
	private static final long serialVersionUID = 6128310163659050706L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CRITERIO_VALUE", unique = true, nullable = false)
	private Long idCriterioValue;

	@Column(name = "NAME", nullable = false, length = 150)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_FIELD")
	private TypeFieldEnum typeField;

	// @ElementCollection
	// @CollectionTable(name="CRITERO_VALUE_CHILD",
	// joinColumns={@JoinColumn(name="FK_ID_CRITERIO_VALUE",
	// referencedColumnName="ID_CRITERIO_VALUE",
	// foreignKey=@ForeignKey(name="FK_CRITERIO_VALUE_CHILD"))})
	// @Column(name = "VALUE_CHILD")
	// private List<String> values;

	// @Column(name = "VALUE_CHILD")
	@ElementCollection
	@CollectionTable(name="CRITERO_VALUE_CHILD",
	 joinColumns={@JoinColumn(name="FK_ID_CRITERIO_VALUE",
	 referencedColumnName="ID_CRITERIO_VALUE",
	 foreignKey=@ForeignKey(name="FK_CRITERIO_VALUE_CHILD"))})
	private List<CriterioValueChild> values;

	@ManyToOne
	@JoinColumn(name = "FK_ID_CRITERIO", nullable = false, referencedColumnName = "ID_CRITERIO", foreignKey = @ForeignKey(name = "FK_CRITERIOVALUE_CRITERIO"))
	private Criterio criterio;

	/**
	 * Attribute getter idCriterioValue
	 * 
	 * @return criteriaValueId
	 */
	/**
	 * Constructor
	 */
	public CriterioValue() {
	}

	public Long getIdCriterioValue() {
		return idCriterioValue;
	}

	/**
	 * Method setIdCriterioValue
	 * 
	 * @param idCriterioValue
	 * @return void
	 */
	public void setIdCriterioValue(Long idCriterioValue) {
		this.idCriterioValue = idCriterioValue;
	}

	/**
	 * Attribute getter name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Attribute setter name
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Attribute getter criterio
	 * 
	 * @return criterio
	 */
	public Criterio getCriterio() {
		return criterio;
	}

	/**
	 * Attribute setter criterio
	 * 
	 * @param criterio
	 *            criterio
	 */
	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	/**
	 * Attribute getter typeField
	 * 
	 * @return typeField
	 */
	public TypeFieldEnum getTypeField() {
		return typeField;
	}

	/**
	 * Attribute setter typeField
	 * 
	 * @param typeField
	 *            typeField
	 */
	public void setTypeField(TypeFieldEnum typeField) {
		this.typeField = typeField;
	}

	/**
	 * Attribute setter values
	 * @param values values
	 */
	public void setValues(List<CriterioValueChild> values) {
		this.values = values;
	}

	/**
	 * Attribute getter values
	 * @return values
	 */
	public List<CriterioValueChild> getValues() {
		return values;
	}

}
