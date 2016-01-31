package com.amachi.fwk.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.amachi.fwk.common.model.Model;
import com.amachi.fwk.util.StatusEnum;

/**
 * User
 * @author tuma
 * @date Dec 11, 2014
 *
 */
@Entity
@Table(name = "USER", uniqueConstraints=@UniqueConstraint(name="UK_USERNAME", columnNames = {"USERNAME"}))
public class User implements Model {

	/**
	 * serialVersionUID
	 * Dec 11, 2014
	 */
	private static final long serialVersionUID = -5215320291734234595L;
	
	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false, length = 50)
	private String password;
	
	@Column(name = "LASTNAME", length = 50)
	private String lastname;
	
	@Column(name = "FIRSTNAME", length = 50)
	private String firstname;
	
	@Column(name = "EMAIL", nullable = false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status = StatusEnum.ACTIVE;
	
	@OneToMany(mappedBy = "userRoleId.user", cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userGrupoId.user", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<UserGrupo> userGroups = new HashSet<UserGrupo>();

	public User() {
	}
	
	public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

	public User(String username, String password, String email, StatusEnum status) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
	}

	public User(String username, String password, String lastname, String firstname, String email, StatusEnum status) {
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.status = status;
	}
	
	/**
	 * Attribute getter username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Attribute setter username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Attribute getter password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Attribute setter password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Attribute getter lastname
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Attribute setter lastname
	 * @param lastname lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Attribute getter firstname
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Attribute setter firstname
	 * @param firstname firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Attribute getter email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Attribute setter email
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Attribute getter userGroups
	 * @return userGroups
	 */
	public Set<UserGrupo> getUserGroups() {
		return userGroups;
	}

	/**
	 * Attribute setter userGroups
	 * @param userGroups userGroups
	 */
	public void setUserGroups(Set<UserGrupo> userGroups) {
		this.userGroups = userGroups;
	}
	
	/**
	 * Method addUserGroup
	 * @param userGroup
	 * @return void
	 */
	public void addUserGroup(UserGrupo userGroup) {
		this.userGroups.add(userGroup);
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
