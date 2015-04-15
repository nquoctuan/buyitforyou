package com.icephoenix.ulticustomize.service;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SunfrogService {
	private static final Logger logger = LoggerFactory.getLogger(SunfrogService.class);
	
	Connection loginConnection;
	Connection logoutConnection;
	Map<String, String> cookies;
	
	protected static String SF_LOGIN = "https://manager.sunfrogshirts.com/Login.cfm";
	protected static String SF_LOGOUT = "https://manager.sunfrogshirts.com/index.cfm?logout=logout";
	protected static String SF_MYACCOUNT = "https://manager.sunfrogshirts.com/my-account.cfm";
	protected static String UA = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36";
	
	public boolean LoginToSunfrog(String username, String pwd) {
		if(loginConnection == null) {
			loginConnection = Jsoup.connect(SF_LOGIN)
					.userAgent(UA)
					.method(Method.GET);
		}
		
		try {
			Connection.Response loginForm = loginConnection.execute();
			cookies = loginForm.cookies();
			
			// Login to SF first
			Document loginResDoc = Jsoup.connect(SF_LOGIN)
					.userAgent(UA)
					.data("username", "newhope1508@gmail.com")
					.data("password", "Anhvu12#$")
					.data("login", "login")
					.cookies(cookies)
					.followRedirects(true)
					.post();
			Elements affIdHref = loginResDoc.select("#showAffiliateID");
			
			return affIdHref.size() > 0;
		} catch (IOException e) {
			logger.error("ERROR while login to sunfrog:" + e.getMessage());
			return false;
		}
	}
	
	public boolean LogoutSunfrog() {
		if (loginConnection != null) {
			logoutConnection = Jsoup.connect(SF_LOGOUT)
					.cookies(cookies).method(Method.GET);
			try {
				logoutConnection.execute();
				return true;
			} catch (IOException e) {
				logger.error("ERROR while logout:" + e.getMessage());
				return false;
			}			
		}
		
		return true;
	}
}
