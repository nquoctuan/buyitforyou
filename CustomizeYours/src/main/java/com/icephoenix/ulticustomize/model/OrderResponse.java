package com.icephoenix.ulticustomize.model;

public class OrderResponse {

	public int errorCode;
	public String orderId;
	public String price;
	public String priceShipping;
	public String tax;
	public String message;

	public boolean IsSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getErrorMessage() {
		switch (errorCode) {
		case 1:
			return "Unable to validate XML";
		case 2:
			return "Empty Authorization key";
		case 3:
			return "Invalid Authorization key";
		case 4:
			return "Empty fullname field";
		case 5:
			return "Empty address1 field";
		case 6:
			return "Empty city field";
		case 7:
			return "Empty postal field";
		case 8:
			return "Empty country field";
		case 9:
			return "Empty sku field";
		case 10:
			return "Empty size field";
		case 11:
			return "Empty quantity field";
		case 12:
			return "SKU not found in Tshirtgang database";
		case 13:
			return "Incorrect size passed";
		case 14:
			return "Incorrect color passed";
		case 15:
			return "Incorrect style passed";
		case 16:
			return "Item not available in this size, color, and style";
		case 30:
			return "Unable to calculate price";
		case 31:
			return "Unable to calculate shipping price";
		case 40:
			return "Unable to retrieve current store version";
		case 41:
			return "Reply was blank";
		case 50:
			return "Empty username field";
		case 51:
			return "Empty password field";
		case 52:
			return "This username does not exist";
		case 53:
			return "Incorrect password";
		case 59:
			return "Password attempts have been reached - unable to login";
		case 60:
			return "The username can not contain non-alphanumerical characters or spaces.";
		case 61:
			return "The username is already taken.";
		case 62:
			return "The seller name is already taken.";
		case 90:
			return "Title field is blank or invalid";
		case 91:
			return "Empty category field";
		case 92:
			return "Image field is missing or incomplete";
		case 93:
			return "Not a valid PNG file";
		case 94:
			return "Unable to copy image file";
		case 95:
			return "Duplicate product title. Product may already exist";
		case 96:
			return "Product not available in this style and color";
		case 200:
			return "Empty Affiliate key";
		case 201:
			return "Invalid Affiliate key";
		case 202:
			return "Empty seller name field";
		case 203:
			return "Empty username field";
		case 204:
			return "Invalid email address";
		case 205:
			return "Invalid PayPal email address";
		case 206:
			return "Your username can not contain non-alphanumerical characters or spaces";
		case 301:
			return "This username is already taken";
		case 302:
			return "This email is already in use by another user";
		case 303:
			return "This display name is already taken";
		case 400:
			return "Can not create parent category through the API. You must create it manually";
		case 401:
			return "Can not create categories at this time.";
		case 402:
			return "Parent category does not exist";
		case 403:
			return "Category field blank";
		case 500:
			return "Invalid Application key";
		case 909:
			return "No results found";
		case 998:
			return "Invalid XML";
		case 999:
			return "Could not complete the request";
		default:
			return "No error";
		}
	}

}
