package com.url.shortner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortner {
	private Map<String, URL> keyUrlMap;
	private Map<URL, String> urlKeyMap;
	
	private char charArray[];
	private String domain;
	private int keyLength;
	
	
	public URLShortner() {
		keyUrlMap = new HashMap<String, URL>();
		urlKeyMap = new HashMap<URL, String>();
		
		charArray = new char[62];
		for(int i = 0; i < 62; i++) {
			int temp = 0;
			if(i <= 9) {
				temp = i + 48;
			}else if(i > 9 && i <= 35){
				temp = i + 55;
			}else {
				temp = i + 61;
			}
			charArray[i] = (char) temp;
		}
		
		domain = "http://abc.com";
		keyLength = 8;
	}
	
	public URLShortner(int keyLength, String domain) {
		this();
		this.keyLength = keyLength;
		this.domain = domain; //check whether domain is valid or not
	}
	
	public String getShortenedURL(String longURL, String clientID) {
		if(longURL == null) {
			System.out.println("URL is empty");
		}
		
		URL url = new URL(longURL, clientID);
		
		String shortURL = "";
		if(isValidURL(url.getLongUrl())) {
			longURL = sanitizeURL(longURL);
			if(urlKeyMap.containsKey(url.getLongUrl())) {//url(long url+client id) -> key
				shortURL = domain + "/" + urlKeyMap.get(url.getLongUrl());
			}else {
				shortURL = domain + "/" + generateKey(longURL, clientID);
			}
		}
		return shortURL;
	}
	
	public String getOriginalURL(String shortUrl) {
		if(shortUrl == null) {
			System.out.println("URL is empty");
		}
		
		URL url = null;
		String key = shortUrl.substring(domain.length() + 1);
		url = keyUrlMap.get(key);
		return url.getLongUrl();
	}
	
	
	private String generateKey(String url, String clientId) {
		String key;
		URL urlObj = new URL(url, clientId);
		key = generateKeyUtil();
		keyUrlMap.put(key, urlObj);
		urlKeyMap.put(urlObj, key);
		return key;
	}
	
	
	private String generateKeyUtil() {
		String key = "";
		boolean present = true;
		for(int i = 0; i <= keyLength; i++) {
			key += charArray[new Random().nextInt(62)];
		}
		if(!keyUrlMap.containsKey(key)) {
			present = false;
		}
		return key;
	}
	
	
	boolean isValidURL(String url) {
		//regex
		return true;
	}
	
	private String sanitizeURL(String url) {
		if(url.substring(0, 7).equals("http://")) {
			url = url.substring(7);
		}
		
		if(url.substring(0, 7).equals("https://")) {
			url = url.substring(7);
		}
		
		if(url.charAt(url.length() - 1) == '/') {
			url = url.substring(0, url.length() - 1);
		}
		
		return url;
	}

}
