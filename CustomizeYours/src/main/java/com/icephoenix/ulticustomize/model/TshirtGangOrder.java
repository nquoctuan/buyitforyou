package com.icephoenix.ulticustomize.model;

import com.icephoenix.utilcustomize.enu.TshirtGangColorEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangPriShippingEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangSizeEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangStyleEnum;

public class TshirtGangOrder {
	public String fullname;
	public String address1;
	public String address2;
	public String city;
	public String postal;
	public String state;
	public String country;
	public String sku;
	public TshirtGangSizeEnum size;
	public TshirtGangStyleEnum style;
	public TshirtGangColorEnum color;
	public String quantity; //1<..<99
	public TshirtGangPriShippingEnum priorityShipping; //0 = no express shipping, 1 = express shipping

	public TshirtGangOrder(String fullname, String address1, String address2,
			String city, String postal, String state, String country,
			String sku, TshirtGangSizeEnum size, TshirtGangStyleEnum style, TshirtGangColorEnum color, String quantity,
			TshirtGangPriShippingEnum priorityShipping) {
		this.fullname = fullname;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postal = postal;
		this.state = state;
		this.country = country;
		this.sku = sku;
		this.size = size;
		this.style = style;
		this.color = color;
		this.quantity = quantity;
		this.priorityShipping = priorityShipping;
	}
}
