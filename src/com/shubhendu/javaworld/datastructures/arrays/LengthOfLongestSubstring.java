/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * #/description
 *
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> seenChars = new HashSet<Character>();
		int start = 0;
		int end = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (seenChars.contains(c)) {
				while (s.charAt(start) != c) {
					seenChars.remove(s.charAt(start++));
				}
				seenChars.remove(s.charAt(start++));
			} else {
				end++;
				seenChars.add(c);
				if ((end - start) > maxLength) {
					maxLength = end - start;
				}
			}
		}
		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "crabdaqkef";
		LengthOfLongestSubstring l = new LengthOfLongestSubstring();
		int len = l.lengthOfLongestSubstring(s);
		System.out.println(len);

	}

}
