package com.amachi.fwk.util;

/**
 * UserStatus
 * @author tuma
 * @date Dec 16, 2014
 *
 */
public enum StatusEnum {
    ACTIVE("Active"),
    INACTIVE("Inactive");
	
    private String label;

    private StatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
