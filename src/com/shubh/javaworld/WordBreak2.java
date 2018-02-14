package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<>(wordDict);
		List<String> result = new ArrayList<String>();
		dfs(s, wordSet, new StringBuilder(), result);
		return result;
	}

	private void dfs(String s, Set<String> wordSet, StringBuilder sb, List<String> result) {

		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i + 1);
			if (wordSet.contains(prefix)) {
				int prevStartIdx = sb.length();
				sb.append(prefix).append(" ");
				int startIdx = sb.length();
				String suffix = s.substring(i + 1);
				if (wordSet.contains(suffix)) {
					sb.append(suffix);
					result.add(sb.toString().trim());
					sb.delete(startIdx, sb.length());
				} else if (suffix.length() == 0) {
					result.add(sb.toString().trim());
				} else {
					dfs(suffix, wordSet, sb, result);
					sb.delete(prevStartIdx, sb.length());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] { "cat", "cats", "and", "sand", "dog" };
		List<String> wordDict = Arrays.asList(words);
		WordBreak2 w = new WordBreak2();
		String s = "catsanddog";
		System.out.println(w.wordBreak(s, wordDict));
	}

}
