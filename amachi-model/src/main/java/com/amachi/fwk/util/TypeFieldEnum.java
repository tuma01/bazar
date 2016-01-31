package com.amachi.fwk.util;

/**
 * TypeFieldEnumDto
 * @author tuma
 * @date Mar 15, 2015
 *
 */
public enum TypeFieldEnum {
	STRING("String"),
	INTEGER("Integer");
	
	private String label;

    private TypeFieldEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
