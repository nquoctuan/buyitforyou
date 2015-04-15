package com.icephoenix.ulticustomize.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

public class HttpRequestTshirtGangHelper {

	static final Logger logger = Logger
			.getLogger(HttpRequestTshirtGangHelper.class);

	private final String USER_AGENT = "Mozilla/5.0";

	public static String sendPost(String uri, String params) throws Exception {

		URL obj = new URL(uri);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(params);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		logger.info("Sending 'POST' request to URL : " + uri);
		logger.info("Post parameters : " + params);
		logger.info("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		logger.info(response.toString());

		return response.toString();
	}
	
	public static void main(String[] args) {
		String xmlOrder = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <OrderForm> <Auth> <key>f7195d5cfb9fff0251b59c194b7d1b7c7bb689be</key> </Auth> <Order> <fullname>Tuan</fullname> <address1>address1</address1> <address2></address2> <city>HCM</city> <postal>123</postal> <state></state> <country>Vietnam</country> <sku>123</sku> <size>large</size> <color>red</color> <quantity>1</quantity> <priorityShipping>0</priorityShipping> <comments></comments> </Order> </OrderForm>";
		try {
			String response  = sendPost("https://www.tshirtgang.com/api/CreateOrder/", xmlOrder);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
