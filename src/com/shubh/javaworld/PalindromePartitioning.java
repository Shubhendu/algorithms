package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null) {
			return result;
		}
		List<String> currList = new ArrayList<String>();
		partition(s, currList, result);
		return result;
	}

	private void partition(String s, List<String> currList, List<List<String>> result) {
		if (s == null || s.length() == 0) {
			if (!currList.isEmpty()) {
				result.add(new ArrayList<String>(currList));
			}
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String s1 = s.substring(0, i + 1);
			String s2 = s.substring(i + 1);
			if (isPalindrome(s1)) {
				currList.add(s1);
				partition(s2, currList, result);
				currList.remove(currList.size() - 1);
			}
		}
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

		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("aab");
		System.out.println(result);

	}

}
