package com.amachi.fwk.model;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.amachi.fwk.common.model.Model;

/**
 * UserRole
 * @author tuma
 * @date Sep 28, 2015
 *
 */
@Entity
@Table(name ="USER_ROLE")
@AssociationOverrides({
	@AssociationOverride(name ="userRoleId.user", joinColumns = @JoinColumn(name ="USERNAME")),
	@AssociationOverride(name ="userRoleId.role", joinColumns = @JoinColumn(name ="ID_ROLE"))
})
public class UserRole implements Model {
    
    /**
	 * serialVersionUID
	 * Nov 27, 2015
	 */
	private static final long serialVersionUID = -3894483165441532537L;
	
	@EmbeddedId
	private UserRoleId userRoleId;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;
    
	/**
	 * Attribute getter userRoleId
	 * @return userRoleId
	 */
    
	public UserRoleId getUserRoleId() {
		return userRoleId;
	}
	/**
	 * Attribute setter userRoleId
	 * @param userRoleId userRoleId
	 */
	public void setUserRoleId(UserRoleId userRoleId) {
		this.userRoleId = userRoleId;
	}
    
    /**
     * Attribute getter createdDate
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    /**
     * Attribute setter createdDate
     * @param createdDate createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Transient
    public Role getRole() {
        return getUserRoleId().getRole();
    }
    
    @Transient
    public User getUser() {
        return getUserRoleId().getUser();
    }
    
}
