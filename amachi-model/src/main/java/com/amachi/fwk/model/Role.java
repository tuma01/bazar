package com.amachi.fwk.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import com.amachi.fwk.common.model.Model;

/**
 * Role
 * @author tuma
 * @date Dec 16, 2014
 *
 */
@Entity
@Table(name="ROLE", uniqueConstraints=@UniqueConstraint(name="UK_NAME_ROLE", columnNames={"NAME"}))
public class Role implements Model {
	
	/**
	 * serialVersionUID
	 * Nov 27, 2015
	 */
	private static final long serialVersionUID = 8105479069251158853L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ROLE", unique = true, nullable = false)
	private Integer idRole;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRoleId.role", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	/**
	 * Constructor
	 */
	public Role() {
	}
	
	/**
	 * Constructor
	 * @param idRole
	 * @param name
	 * @param users
	 */
	public Role(Integer idRole, String name) {
		super();
		this.idRole = idRole;
		this.name = name;
	}
	
	/**
	 * Attribute getter idRole
	 * @return idRole
	 */
	public Integer getIdRole() {
		return idRole;
	}
	/**
	 * Attribute setter idRole
	 * @param roleId idRole
	 */
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	/**
	 * Attribute getter name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Attribute setter name of role
	 * @param roleName name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Attribute getter userRoles
	 * @return userRoles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * Attribute setter userRoles
	 * @param userRoles userRoles
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	/**
	 * Method addUserRoles
	 * @param userRole
	 * @return void
	 */
	public void addUserRoles(UserRole userRole) {
		this.userRoles.add(userRole);
	}

}
