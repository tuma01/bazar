package com.amachi.fwk.util;

/**
 * HtmlFormElementsEnum
 * @author tuma
 * @date Oct 3, 2015
 *
 */
public enum HtmlTypesEnum {
    INPUT("Input"),
    SELECT("Select"),
    TEXTAREA("Textarea"),
    BUTTON("Button"),
    DATALIST("Datalist"),
    KEYGEN("Keygen"),
    OUTPUT("Output");
	
    private String label;

    private HtmlTypesEnum(String label) {
        this.label = label;
    }

    
    public String getLabel() {
        return label;
    }
}
