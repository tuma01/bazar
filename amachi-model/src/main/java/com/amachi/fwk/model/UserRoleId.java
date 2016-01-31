package com.amachi.fwk.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * UserRoleId
 * @author tuma
 * @date Sep 28, 2015
 *
 */
@Embeddable
public class UserRoleId implements Serializable {

    /**
     * serialVersionUID
     * Sep 28, 2015
     */
    private static final long serialVersionUID = 8718787682729936747L;
    
    @ManyToOne(optional=false)
    @JoinColumn(referencedColumnName="ID_ROLE", foreignKey=@ForeignKey(name="FK_ROLE"))
    private Role role;
    
    @ManyToOne(optional=false)
    @JoinColumn(referencedColumnName="USERNAME", foreignKey=@ForeignKey(name="FK_USERNAME"))
    private User user;
    /**
     * Attribute getter role
     * @return role
     */
    public Role getRole() {
        return role;
    }
    /**
     * Attribute setter role
     * @param role role
     */
    public void setRole(Role role) {
        this.role = role;
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
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
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
        UserRoleId other = (UserRoleId) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}
