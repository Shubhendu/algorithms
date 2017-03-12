/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
 * "cd", "ce", "cf"].
 */
public class PhoneNumberCombinations {
	private static Map<Integer, List<Character>> DIGITS_MAP = new HashMap<Integer, List<Character>>();

	static {
		Map<Integer, List<Character>> initDigitMap = new HashMap<Integer, List<Character>>();
		initDigitMap.put(2, Arrays.asList(new Character[] { 'a', 'b', 'c' }));
		initDigitMap.put(3, Arrays.asList(new Character[] { 'd', 'e', 'f' }));
		initDigitMap.put(4, Arrays.asList(new Character[] { 'g', 'h', 'i' }));
		initDigitMap.put(5, Arrays.asList(new Character[] { 'j', 'k', 'l' }));
		initDigitMap.put(6, Arrays.asList(new Character[] { 'm', 'n', 'o' }));
		initDigitMap.put(7, Arrays.asList(new Character[] { 'p', 'q', 'r', 's' }));
		initDigitMap.put(8, Arrays.asList(new Character[] { 't', 'u', 'v' }));
		initDigitMap.put(9, Arrays.asList(new Character[] { 'w', 'x', 'y', 'z' }));
		initDigitMap.put(1, Arrays.asList(new Character[] {}));
		initDigitMap.put(0, Arrays.asList(new Character[] {}));
		DIGITS_MAP = Collections.unmodifiableMap(initDigitMap);
	}

	public List<String> letterCombinations(String digits) {
		StringBuilder sb = new StringBuilder();
		List<String> results = new ArrayList<String>();
		letterCombinationsRec(digits, sb, results);
		return results;
	}

	private void letterCombinationsRec(String digits, StringBuilder sb, List<String> results) {
		if (digits == null || digits.length() == 0) {
			return;
		}
		int digit = digits.charAt(0) - '0';
		if (digits.length() == 1) {
			for (char c : DIGITS_MAP.get(digit)) {
				sb.append(c);
				results.add(sb.toString());
				sb.deleteCharAt(sb.length() - 1);
			}
		}

		for (char c : DIGITS_MAP.get(digit)) {
			sb.append(c);
			letterCombinationsRec(digits.substring(1, digits.length() - 1), sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
