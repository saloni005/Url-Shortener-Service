package com.url.shortner;

public class URL {
	
	private String longUrl;
	private String clientId;
	
	public URL(String longUrl, String clientId) {
		super();
		this.longUrl = longUrl;
		this.clientId = clientId;
	}
	
	public String getLongUrl() {
		return longUrl;
	}
	
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}	
	
}