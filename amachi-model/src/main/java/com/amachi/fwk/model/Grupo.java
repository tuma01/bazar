package com.amachi.fwk.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="GRUPO", uniqueConstraints=@UniqueConstraint(name="UK_NAME_GRUPO", columnNames={"NAME"}))
public class Grupo {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_GRUPO")
	private Long idGroup;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 250)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userGrupoId.grupo", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
	private Set<UserGrupo> userGrupos = new HashSet<UserGrupo>();
	
	/**
	 * Constructor
	 */
	public Grupo() {
	}
	
	/**
	 * Constructor
	 * @param name
	 */
	public Grupo(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter idGroup
	 * @return idGroup
	 */
	public Long getIdGroup() {
		return idGroup;
	}

	/**
	 * Attribute setter idGroup
	 * @param idGroup idGroup
	 */
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}

	/**
	 * Attribute getter userGrupos
	 * @return userGrupos
	 */
	public Set<UserGrupo> getUserGrupos() {
		return userGrupos;
	}

	/**
	 * Attribute setter userGrupos
	 * @param userGrupos userGrupos
	 */
	public void setUserGrupos(Set<UserGrupo> userGrupos) {
		this.userGrupos = userGrupos;
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

}