package com.icephoenix.utilcustomize.enu;

public enum TshirtGangColorEnum {
	BLACK ("Black"),
	WHITE ("White"),
	CHARCOAL_GREY ("Charcoal Grey"),
	DAISY ("Daisy"),
	DARK_CHOCO ("Dark Chocolate"),
	FOREST_GREEN ("Forest Green"),
	GOLD ("Gold"),
	IRISH_GREEN ("Irish Green"),
	LIGHT_BLUE ("Light Blue"),
	LIGHT_PINK ("Light Pink"),
	MILITARY_GREEN ("Military Green"),
	NAVY("Navy"),
	ORANGE ("Orange"),
	PURPLE ("Purple"),
	RED ("Red"),
	ROYAL_BLUE ("Royal Blue"),
	SPORT_GREY ("Sport Grey"),
	TAN ("Tan"),
	NAVY_RINGER ("Navy Ringer"),
	BLACK_RINGER ("Black Ringer"),
	RED_RINGER ("Red Ringer"),
	OTHER ("Other"),
	BURGUNDY ("Burgundy");
	
	private final String name;       

    private TshirtGangColorEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
