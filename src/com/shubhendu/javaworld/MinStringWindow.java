/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class MinStringWindow {

	public String minWindow(String s, String t) {
		Map<Character, Integer> strMap = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			strMap.put(c, 0);
		}

		for (char c : t.toCharArray()) {
			if (!strMap.containsKey(c)) {
				return "";
			}
			strMap.put(c, strMap.get(c) + 1);
		}

		int tCount = t.length();
		int start = 0;
		int end = start;
		int minStart = 0;
		int minEnd = Integer.MAX_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end);
			if (strMap.get(c) > 0) {
				tCount--;
			}
			strMap.put(c, strMap.get(c) - 1);
			end++;

			while (tCount == 0) {
				if ((minEnd - minStart) > (end - start)) {
					minEnd = end;
					minStart = start;
				}

				c = s.charAt(start);
				strMap.put(c, strMap.get(c) + 1);

				if (strMap.get(c) > 0) {
					tCount++;
				}
				start++;

			}

		}

		return (minEnd - minStart == Integer.MAX_VALUE) ? "" : s.substring(minStart, minEnd);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ADOBECODEBANC";
		String t = "ABC";
		
//		s = "cabwefgewcwaefgcf";
//		t = "cae";
		
		MinStringWindow m = new MinStringWindow();
		System.out.println(m.minWindow(s, t));

	}

}
