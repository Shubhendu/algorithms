/**
 * 
 */
package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class EncodeDecodeTinyUrl {

	private Map<String, String> longToShortMap;
	private Map<String, String> shortToLongMap;
	private static final String CHAR_SET = "ABCDEDFGHIJKLMNOPQRSTUVWXYZabcdedfghijklmnopqrstuvwxyz0123456789";
	private static final String BASE_HOST = "http://tinyurl.com/";

	public EncodeDecodeTinyUrl() {
		this.longToShortMap = new HashMap<String, String>();
		this.shortToLongMap = new HashMap<String, String>();
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (longToShortMap.containsKey(longUrl)) {
			return longToShortMap.get(longUrl);
		}
		StringBuilder sb = new StringBuilder();
		do {
			for (int i = 0; i < 6; i++) {
				int index = (int) (Math.random() * CHAR_SET.length());
				sb.append(CHAR_SET.charAt(index));
			}
		} while (longToShortMap.containsKey(sb.toString()));
		String encodedUrl = BASE_HOST + sb.toString();
		longToShortMap.put(longUrl, encodedUrl);
		shortToLongMap.put(encodedUrl, longUrl);
		return encodedUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLongMap.getOrDefault(shortUrl, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://leetcode.com/problems/design-tinyurl";
		EncodeDecodeTinyUrl encoded = new EncodeDecodeTinyUrl();
		for (int i = 0; i < 10; i++) {
			System.out.println(encoded.encode(url));
		}
	}

}
