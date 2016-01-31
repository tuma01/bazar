package com.amachi.fwk.model;

import java.util.HashSet;
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
import com.amachi.fwk.util.StatusEnum;

@Entity
@Table(name = "CATEGORY", uniqueConstraints = @UniqueConstraint(name = "UK_NAME_CATEGORY", columnNames = { "NAME" }))
public class Category implements Model {

	/**
	 * serialVersionUID Nov 27, 2015
	 */
	private static final long serialVersionUID = 2512247828334403815L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_CATEGORY", unique = true, nullable = false)
	private Integer idCategory;
	
	@Embedded
	private UserConnexion userConnexion;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 150)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "FK_PARENT_CATEGORY", referencedColumnName = "ID_CATEGORY", foreignKey = @ForeignKey(name = "FK_CATEGORY_PARENT"))
	private Category parentCategory;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status;
	
	@Column(name = "FULLNAME", nullable = false, length = 250)
	private String fullName;
	
	@Column(name = "DIFFICULTY")
	private int difficulty;
	
	@OneToMany(targetEntity = Category.class, mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Category> subCategories;

//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
//	private Set<Criterio> criterios = new HashSet<Criterio>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "criterioCategoryId.category", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CriterioCategory> criterioCategories = new HashSet<CriterioCategory>(0);

	public Category() {
	}
	
	/**
	 * Constructor
	 * @param idCategory
	 */
	public Category(Integer idCategory) {
		super();
		this.idCategory = idCategory;
	}



	/**
	 * Constructor
	 * @param idCategory
	 * @param name
	 * @param subCategories
	 */
	public Category(Integer idCategory, String name, Set<Category> subCategories) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.subCategories = subCategories;
	}

	/**
	 * Constructor
	 * @param parentCategory
	 * @param name
	 * @param status
	 */
	public Category(Category parentCategory, String name, StatusEnum status) {
		this.parentCategory = parentCategory;
		this.name = name;
		this.fullName = name;
		this.status = status;
		if (parentCategory != null) {
			this.fullName = parentCategory.fullName + "/" + this.fullName;
		}
	}

	/**
	 * Attribute getter idCategory
	 * @return idCategory
	 */
	public Integer getIdCategory() {
		return idCategory;
	}

	/**
	 * Attribute setter idCategory
	 * @param idCategory idCategory
	 */
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * Attribute getter userConnexion
	 * @return userConnexion
	 */
	public UserConnexion getUserConnexion() {
		return userConnexion;
	}

	/**
	 * Attribute setter userConnexion
	 * @param userConnexion userConnexion
	 */
	public void setUserConnexion(UserConnexion userConnexion) {
		this.userConnexion = userConnexion;
	}

	/**
	 * Attribute getter name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Attribute setter name
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter parentCategory
	 * @return parentCategory
	 */
	public Category getParentCategory() {
		return parentCategory;
	}

	/**
	 * Attribute setter parentCategory
	 * @param parentCategory parentCategory
	 */
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * Attribute getter status
	 * @return status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Attribute setter status
	 * @param status status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Attribute getter fullName
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Attribute setter fullName
	 * @param fullName fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Attribute getter difficulty
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Attribute setter difficulty
	 * @param difficulty difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Attribute getter subCategories
	 * @return subCategories
	 */
	public Set<Category> getSubCategories() {
		return subCategories;
	}

	/**
	 * Attribute setter subCategories
	 * @param subCategories subCategories
	 */
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

//	/**
//	 * Attribute getter criterios
//	 * @return criterios
//	 */
//	public Set<Criterio> getCriterios() {
//		return criterios;
//	}
//
//	/**
//	 * Attribute setter criterios
//	 * @param criterios criterios
//	 */
//	public void setCriterios(Set<Criterio> criterios) {
//		this.criterios = criterios;
//	}

	/**
	 * Attribute getter criterioCategories
	 * @return criterioCategories
	 */
	public Set<CriterioCategory> getCriterioCategories() {
		return criterioCategories;
	}

	/**
	 * Attribute setter criterioCategories
	 * @param criterioCategories criterioCategories
	 */
	public void setCriterioCategories(Set<CriterioCategory> criterioCategories) {
		this.criterioCategories = criterioCategories;
	}

}
