package com.icephoenix.utilcustomize.enu;

public enum TshirtGangPriShippingEnum {
	NO_EXPRESS (0),
	EXPRESS (1);
	
	private final int value;

	private TshirtGangPriShippingEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public String toString(){
        return String.valueOf(value);
     }
}
