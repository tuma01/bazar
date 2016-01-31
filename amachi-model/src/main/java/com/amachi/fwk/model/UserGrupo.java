package com.amachi.fwk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.amachi.fwk.common.model.Model;

@Entity
@Table(name = "USER_GRUPO")
//@AssociationOverrides({
//	@AssociationOverride(name = "primaryKey.user", joinColumns = @JoinColumn(name = "FK_USERNAME", referencedColumnName = "USERNAME", nullable = false, foreignKey=@ForeignKey(name="FK_USERGROUP_USER"))),
//	@AssociationOverride(name = "primaryKey.group", joinColumns = @JoinColumn(name = "FK_ID_GROUP", referencedColumnName = "ID_GROUP", nullable = false, foreignKey=@ForeignKey(name="FK_USERGROUP_GROUP")))
//})
public class UserGrupo implements Model {
	
	/**
	 * serialVersionUID
	 * Dec 6, 2015
	 */
	private static final long serialVersionUID = -255481281817026844L;

	@EmbeddedId
	private UserGrupoId userGrupoId = new UserGrupoId();
	
	@Column(name = "ACTIVATED")
	private boolean activated;
	
	@Column(name = "REGISTERED_DATE")
	@Temporal(TemporalType.DATE)
	private Date registeredDate;

	

	@Transient
	public User getUser() {
		return getUserGrupoId().getUser();
	}

	public void setUser(User user) {
		getUserGrupoId().setUser(user);
	}

	@Transient
	public Grupo getGrupo() {
		return getUserGrupoId().getGrupo();
	}

	public void setGrupo(Grupo grupo) {
		getUserGrupoId().setGrupo(grupo);
	}

	/**
	 * Attribute getter userGrupoId
	 * @return userGrupoId
	 */
	public UserGrupoId getUserGrupoId() {
		return userGrupoId;
	}

	/**
	 * Attribute setter userGrupoId
	 * @param userGrupoId userGrupoId
	 */
	public void setUserGrupoId(UserGrupoId userGrupoId) {
		this.userGrupoId = userGrupoId;
	}

	/**
	 * Attribute getter activated
	 * @return activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Attribute setter activated
	 * @param activated activated
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * Attribute getter registeredDate
	 * @return registeredDate
	 */
	public Date getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * Attribute setter registeredDate
	 * @param registeredDate registeredDate
	 */
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
}
