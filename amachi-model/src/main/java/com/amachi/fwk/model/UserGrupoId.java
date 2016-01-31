package com.amachi.fwk.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserGrupoId implements Serializable {	
	/**
	 * serialVersionUID
	 * Nov 28, 2015
	 */
	private static final long serialVersionUID = 9127481203093124667L;
	
	@JoinColumn(name = "FK_USERNAME", referencedColumnName = "USERNAME", nullable = false, foreignKey=@ForeignKey(name="FK_USERGRUPO_USER"))
    @ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JoinColumn(name = "FK_ID_GRUPO", referencedColumnName = "ID_GRUPO", nullable = false, foreignKey=@ForeignKey(name="FK_USERGRUPO_GROUP"))
    @ManyToOne(cascade = CascadeType.REMOVE)
	private Grupo grupo;

	/**
	 * Constructor
	 */
	public UserGrupoId() {
	}
	/**
	 * Attribute getter user
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Attribute setter user
	 * @param user user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Attribute getter grupo
	 * @return grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * Attribute setter grupo
	 * @param grupo grupo
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserGrupoId other = (UserGrupoId) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
