package com.icephoenix.utilcustomize.enu;

public enum TshirtGangStyleEnum {
	STANDARD ("Standard"),
	MEN_FITTED ("Mens Fitted"),
	LADIES ("Ladies"),
	HOODED_PULLOVER ("Hooded Pullover"),
	APRON ("Apron"),
	BABY_ONE_PIECE ("Baby One Piece");

    private final String name;       

    private TshirtGangStyleEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
