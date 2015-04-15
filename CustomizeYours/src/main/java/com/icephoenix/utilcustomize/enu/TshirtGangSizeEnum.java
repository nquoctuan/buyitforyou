package com.icephoenix.utilcustomize.enu;

public enum TshirtGangSizeEnum {
	X_SMALL ("X-Small (Youth)"),
	SMALL_YOUTH ("Small (Youth)"),
	MEDIUM_YOUTH ("Medium (Youth)"),
	SMALL ("Small"),
	MEDIUM ("Medium"),
	LARGE ("Large"),
	X_LARGE ("X-Large"),
	_2_X_LARGE ("2 X-Large"),
	_3_X_LARGE ("3 X-Large"),
	_4_X_LARGE ("4 X-Large"),
	_5_X_LARGE ("5 X-Large"),
	_6_X_LARGE ("6 X-Large"),
	_6_MONTHS ("6 Months"),
	_12_MONTHS ("12 Months"),
	_18_MONTHS ("18 Months");
	
	private final String name;       

    private TshirtGangSizeEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
