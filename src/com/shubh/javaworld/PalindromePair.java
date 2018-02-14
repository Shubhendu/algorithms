package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePair {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (words == null) {
			return results;
		}

		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			wordMap.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				List<Integer> indexes = null;
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String revWord = new StringBuilder(str2).reverse().toString();
					if (wordMap.getOrDefault(revWord, -1) >= 0 && wordMap.get(revWord) != i) {
						indexes = new ArrayList<Integer>();
						indexes.add(i);
						indexes.add(wordMap.get(revWord));
						results.add(indexes);
					}
				}

				if (isPalindrome(str2)) {
					String revWord = new StringBuilder(str1).reverse().toString();
					if (wordMap.getOrDefault(revWord, -1) >= 0 && revWord.length() != 0) {
						indexes = new ArrayList<Integer>();
						indexes.add(i);
						indexes.add(wordMap.get(revWord));
						results.add(indexes);
					}
				}
			}
		}

		return results;
	}

	private boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;

		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
