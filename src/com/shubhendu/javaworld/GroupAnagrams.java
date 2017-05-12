/**
 *
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++) {
				char c = str.toLowerCase().charAt(i);
				arr[c - 'a']++;
				System.out.println(c + " : " + Integer.valueOf(arr[c - 'a']));
			}
			String ns = new String(arr);

			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}

		result.addAll(map.values());

		return result;
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();

		if (strs == null) {
			return result;
		}

		for (String str : strs) {
			char[] strChars = str.toLowerCase().toCharArray();
			Arrays.sort(strChars);
			String key = String.valueOf(strChars);
			List<String> wordList = wordMap.getOrDefault(key, new ArrayList<String>());
			wordList.add(str);
			wordMap.put(key, wordList);
		}

		for (String key : wordMap.keySet()) {
			result.add(wordMap.get(key));
		}

		return result;
	}

	public static List<List<String>> groupAnagrams3(String[] strs) {
		Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();

		if (strs == null) {
			return result;
		}

		char[] charArr = new char[26];
		for (String str : strs) {
			charArr = new char[26];
			for (char c : str.toCharArray()) {
				charArr[c - 'a']++;
			}
			String key = new String(charArr);
			List<String> wordList = null;
			if (wordMap.containsKey(key)) {
				wordList = wordMap.get(key);

			} else {
				wordList = new ArrayList<String>();
			}
			wordList.add(str);
			wordMap.put(key, wordList);
		}

		result.addAll(wordMap.values());

		return result;
	}

	public static void main(String[] args) {
		String[] arr = new String[] { "torchwood", "doctorwho", "abc", "bac", "bat" };
		List<List<String>> result3 = GroupAnagrams.groupAnagrams3(arr);
		// List<List<String>> result2 = GroupAnagrams.groupAnagrams2(arr);
		// List<List<String>> result = GroupAnagrams.groupAnagrams(arr);
		//
		for (List<String> strList : result3) {
			System.out.println(strList);
		}

		// for (List<String> strList : result) {
		// System.out.println(strList);
		// }

	}
}
