package com.amachi.fwk.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.amachi.fwk.common.model.Model;
import com.amachi.fwk.util.HtmlTypesEnum;
import com.amachi.fwk.util.TypeCriterioEnum;

/**
 * Criterio
 * 
 * @author tuma
 * @date Feb 11, 2015
 */
@Entity
@Table(name = "CRITERIO", uniqueConstraints = @UniqueConstraint(name = "UK_NAME_CRITERIO", columnNames = { "NAME" }))
public class Criterio implements Model {

	/**
	 * serialVersionUID Nov 27, 2015
	 */
	private static final long serialVersionUID = -5605313429636958306L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CRITERIO", nullable = false)
	private Integer idCriterio;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "DESCRIPTION", length = 150)
	private String description;
	
	@Column(name = "NAME_CRITERIO_VALUES", length = 150)
	private String nameCriterioValues;

	@Enumerated(EnumType.STRING)
	@Column(name = "HTML_TYPES")
	private HtmlTypesEnum htmlTypes;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_CRITERIO")
	private TypeCriterioEnum typeCriterio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "criterioAnuncioId.criterio", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CriterioAnuncio> criterioAnuncios = new HashSet<CriterioAnuncio>(0);

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ID_CATEGORY", nullable = false, referencedColumnName = "ID_CATEGORY", foreignKey = @ForeignKey(name = "FK_CRITERIO_CATEGORY"))
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "criterioCategoryId.criterio", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CriterioCategory> criterioCategories = new HashSet<CriterioCategory>(0);

	@Embedded
	private UserConnexion userConnexion;

	// @ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable(name = "CRITERIO_CATEGORY", joinColumns = @JoinColumn(name =
	// "FK_ID_CRITERIO", referencedColumnName = "ID_CRITERIO", nullable = false,
	// foreignKey = @ForeignKey(name = "FK_CRITERIOCATEGORY_CRITERIO")),
	// inverseJoinColumns = @JoinColumn(name = "FK_ID_CATEGORY",
	// referencedColumnName = "ID_CATEGORY", nullable = false, foreignKey =
	// @ForeignKey(name = "FK_CRITERIOCATEGORY_CATEGORY")))
	// private Set<Category> categories = new HashSet<Category>(0);

	@OneToMany(targetEntity = CriterioValue.class, mappedBy = "criterio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CriterioValue> criterioValues = new ArrayList<CriterioValue>();

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param htmlTypes
	 * @param typeCriterio
	 */
	public Criterio(String name, HtmlTypesEnum htmlTypes, TypeCriterioEnum typeCriterio) {
		super();
		this.name = name;
		this.htmlTypes = htmlTypes;
		this.typeCriterio = typeCriterio;
	}

	
	/**
	 * Constructor
	 * @param idCriterio
	 */
	public Criterio(Integer idCriterio) {
		super();
		this.idCriterio = idCriterio;
	}


	/**
	 * Constructor
	 */
	public Criterio() {
	}

	/**
	 * Attribute getter idCriterio
	 * 
	 * @return idCriterio
	 */
	public Integer getIdCriterio() {
		return this.idCriterio;
	}

	/**
	 * Method setCriterioId
	 * 
	 * @param criterioId
	 * @return void
	 */
	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
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
	 * Method getUserConnexion
	 * 
	 * @return
	 * @return UserConnexion
	 */
	public UserConnexion getUserConnexion() {
		return userConnexion;
	}

	/**
	 * Method setUserConnexion
	 * 
	 * @param userConnexion
	 * @return void
	 */
	public void setUserConnexion(UserConnexion userConnexion) {
		this.userConnexion = userConnexion;
	}

	/**
	 * Attribute getter htmlTypes
	 * 
	 * @return htmlTypes
	 */
	public HtmlTypesEnum getHtmlTypes() {
		return htmlTypes;
	}

	/**
	 * Attribute setter htmlTypes
	 * 
	 * @param htmlTypes
	 *            htmlTypes
	 */
	public void setHtmlTypes(HtmlTypesEnum htmlTypes) {
		this.htmlTypes = htmlTypes;
	}

	/**
	 * Attribute getter criterioAnuncios
	 * 
	 * @return criterioAnuncios
	 */
	public Set<CriterioAnuncio> getCriterioAnuncios() {
		return criterioAnuncios;
	}

	/**
	 * Attribute setter criterioAnuncios
	 * 
	 * @param criterioAnuncios
	 *            criterioAnuncios
	 */
	public void setCriterioAnuncios(Set<CriterioAnuncio> criterioAnuncios) {
		this.criterioAnuncios = criterioAnuncios;
	}

	/**
	 * Method addCriterioAnuncios
	 * 
	 * @param criterioAnuncio
	 * @return void
	 */
	public void addCriterioAnuncios(CriterioAnuncio criterioAnuncio) {
		this.criterioAnuncios.add(criterioAnuncio);
	}

	// /**
	// * Attribute getter categories
	// *
	// * @return categories
	// */
	// public Set<Category> getCategories() {
	// return categories;
	// }
	//
	// /**
	// * Attribute setter categories
	// *
	// * @param categories
	// * categories
	// */
	// public void setCategories(Set<Category> categories) {
	// this.categories = categories;
	// }

	/**
	 * Attribute getter criterioValues
	 * 
	 * @return criterioValues
	 */
	public List<CriterioValue> getCriterioValues() {
		return criterioValues;
	}

	/**
	 * Attribute setter criterioValues
	 * 
	 * @param criterioValues
	 *            criterioValues
	 */
	public void setCriterioValues(List<CriterioValue> criterioValues) {
		this.criterioValues = criterioValues;
	}

	/**
	 * Attribute getter category
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Attribute setter category
	 * 
	 * @param category
	 *            category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Attribute getter criterioCategories
	 * 
	 * @return criterioCategories
	 */
	public Set<CriterioCategory> getCriterioCategories() {
		return criterioCategories;
	}

	/**
	 * Attribute setter criterioCategories
	 * 
	 * @param criterioCategories
	 *            criterioCategories
	 */
	public void setCriterioCategories(Set<CriterioCategory> criterioCategories) {
		this.criterioCategories = criterioCategories;
	}

	/**
	 * Attribute getter typeCriterio
	 * @return typeCriterio
	 */
	public TypeCriterioEnum getTypeCriterio() {
		return typeCriterio;
	}

	/**
	 * Attribute setter typeCriterio
	 * @param typeCriterio typeCriterio
	 */
	public void setTypeCriterio(TypeCriterioEnum typeCriterio) {
		this.typeCriterio = typeCriterio;
	}

	/**
	 * Attribute getter nameCriterioValues
	 * @return nameCriterioValues
	 */
	public String getNameCriterioValues() {
		return nameCriterioValues;
	}

	/**
	 * Attribute setter nameCriterioValues
	 * @param nameCriterioValues nameCriterioValues
	 */
	public void setNameCriterioValues(String nameCriterioValues) {
		this.nameCriterioValues = nameCriterioValues;
	}

}
