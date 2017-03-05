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
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		Map<Character, Character> charMap = new HashMap<Character, Character>();

		for (int i = 0; i < t.length(); i++) {
			char targetChar = t.charAt(i);
			char sourceChar = s.charAt(i);

			if (charMap.get(targetChar) != null) {
				targetChar = charMap.get(targetChar);
				if (targetChar != sourceChar)
					return false;
			} else {
				if (charMap.containsValue(sourceChar))
					return false;
				charMap.put(targetChar, sourceChar);
			}

		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsomorphicStrings iso = new IsomorphicStrings();
		System.out.println(iso.isIsomorphic("ab", "aa"));
		System.out.println(iso.isIsomorphic("abc", "cba"));
		System.out.println(iso.isIsomorphic("aabadcb", "eeezwhz"));
		System.out.println(iso.isIsomorphic("aaabdcb", "eeezwhz"));
		System.out.println(iso.isIsomorphic("baa", "cfa"));

	}

}
