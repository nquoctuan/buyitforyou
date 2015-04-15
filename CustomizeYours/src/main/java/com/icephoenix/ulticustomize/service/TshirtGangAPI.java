package com.icephoenix.ulticustomize.service;

import org.apache.log4j.Logger;

import com.icephoenix.ulticustomize.helper.HttpRequestTshirtGangHelper;
import com.icephoenix.ulticustomize.helper.TshirtGangProduct;
import com.icephoenix.ulticustomize.helper.XMLTshirtGangHelper;
import com.icephoenix.ulticustomize.model.OrderResponse;
import com.icephoenix.ulticustomize.model.ProductResponse;
import com.icephoenix.ulticustomize.model.TshirtGangOrder;
import com.icephoenix.utilcustomize.enu.TshirtGangColorEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangPriShippingEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangSizeEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangStyleEnum;

public class TshirtGangAPI {

	static final Logger logger = Logger
			.getLogger(TshirtGangAPI.class);
	
	private final static String URL_REQUEST_ORDER = "https://www.tshirtgang.com/api/CreateOrder/";
	private final static String URL_REQUEST_PRODUCT = "https://www.tshirtgang.com/api/CreateProduct/";
	private final static String URL_REQUEST_MULTIORDER = "https://www.tshirtgang.com/api/CreateMultipleOrder/";
	
	public boolean CreateOrder(String key, TshirtGangOrder order) {
		String xmlOrder = XMLTshirtGangHelper.createOrder(key, order);
		String response;
		try {
			response = HttpRequestTshirtGangHelper.sendPost(URL_REQUEST_ORDER, xmlOrder);
			
			OrderResponse orderResponse = XMLTshirtGangHelper
					.parseResponse(response);
			if (orderResponse.IsSuccess()) {
				return true;
			} 
			
			logger.error(orderResponse.getErrorMessage());
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return false;
	}

	public boolean CreateProduct(String key, TshirtGangProduct product, String appID) {
		String xmlProduct = XMLTshirtGangHelper.createProduct(key, product, appID);
		String response;
		try {
			response = HttpRequestTshirtGangHelper.sendPost(URL_REQUEST_PRODUCT, xmlProduct);
			
			ProductResponse productResponse = XMLTshirtGangHelper.parseProductResponse(response);
			if (productResponse.IsSuccess()) {
				return true;
			}
			
			logger.error(productResponse.getErrorMessage());
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return false;
	}
	
	public boolean CreateMultiOrder(String key, TshirtGangOrder[] orders) {
		String xmlMultiOrder = XMLTshirtGangHelper.createMultiOrder(key, orders);
		String response;
		
		try {
			response = HttpRequestTshirtGangHelper.sendPost(URL_REQUEST_MULTIORDER, xmlMultiOrder);
			
			OrderResponse orderResponse = XMLTshirtGangHelper.parseResponse(response);
			if (orderResponse.IsSuccess()) {
				return true;
			}
			
			logger.error(orderResponse.getErrorMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return false;
	}
}
