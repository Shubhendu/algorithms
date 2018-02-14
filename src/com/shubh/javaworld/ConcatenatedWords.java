package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Set<String> wordSet = buildSet(words);
		Set<String> notPresent = new HashSet<String>();
		List<String> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (isPresent(words[i], wordSet, notPresent)) {
				result.add(words[i]);
			}
		}
		return result;
	}

	private boolean isPresent(String word, Set<String> wordSet, Set<String> notPresent) {
		if (notPresent.contains(word)) {
			return false;
		}
		
		for (int j = 0; j < word.length() - 1; j++) {
			String left = word.substring(0, j + 1);
			if (wordSet.contains(left)) {
				String right = word.substring(j + 1);
				if (wordSet.contains(right)) {
					return true;
				}
				boolean exists = isPresent(right, wordSet, notPresent);
				if (exists) {
					return true;
				}
			}
		}
		notPresent.add(word);
		return false;
	}

	private Set<String> buildSet(String[] words) {
		Set<String> wordSet = new HashSet<>();
		for (String w : words) {
			wordSet.add(w);
		}
		return wordSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "dogcats", "dogcatss", "hippopotamuses", "rat",
				"ratcatdogcat" };
		ConcatenatedWords c = new ConcatenatedWords();
		System.out.println(c.findAllConcatenatedWordsInADict(words));

	}

}
