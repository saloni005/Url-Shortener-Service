package com.url.shortner;

public class USSDriver {

	public static void main(String[] args) {
		
		URLShortner uss = new URLShortner(5, "www.observe.com/"); //initialize......
		String url[] = {"www.google.com/", "www.abc.in", "www.abd.in"};
		String clientId[] = {"id1", "id2", "id3"};
		
//		for(int i = 0; i < url.length; i++) {
//			for(int j = 0; j < clientId.length; j++) {
//				System.out.println("Long URL: " + url[i] + " Short URL: "+ uss.getShortenedURL(url[i], clientId[j]));
//				System.out.println();
//				System.out.println("Converting to original url: " + uss.getOriginalURL(uss.getShortenedURL(url[i], "id")));
//			}
//		}

		System.out.println(uss.getShortenedURL("www.google.com/", "id1"));
		System.out.println(uss.getShortenedURL("www.google.com/", "id1"));
	}

}
