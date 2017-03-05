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
public class WordDistance {

	private Map<String, Integer> wordDistanceMap = null;
	private String[] words = null;

	public WordDistance(String[] words) {
		this.words = words;
		this.wordDistanceMap = new HashMap<String, Integer>();
	}

	private int getDistanceFromMap(String word1, String word2) {
		StringBuilder sb = new StringBuilder();
		sb.append(word1);
		sb.append(word2);

		if (wordDistanceMap.get(sb.toString()) != null) {
			System.out.println("Returing from map");
			return wordDistanceMap.get(sb.toString());
		}

		return -1;
	}

	private void putDistanceMap(String word1, String word2, int distance) {
		StringBuilder sb = new StringBuilder();
		sb.append(word1);
		sb.append(word2);

		this.wordDistanceMap.put(sb.toString(), distance);

		sb = new StringBuilder();
		sb.append(word2);
		sb.append(word1);

		this.wordDistanceMap.put(sb.toString(), distance);
	}

	public int shortest(String word1, String word2) {
		int storedDistance = getDistanceFromMap(word1, word2);

		if (storedDistance != -1) {
			return storedDistance;
		}

		int firstWordIndex = -1;
		int secondWordIndex = -1;
		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < this.words.length; i++) {
			if (this.words[i].equals(word1))
				firstWordIndex = i;
			else if (this.words[i].equals(word2))
				secondWordIndex = i;
			System.out.println(firstWordIndex + " : " + secondWordIndex + " : " + words[i]);
			if (firstWordIndex != -1 && secondWordIndex != -1) {
				if (Math.abs(firstWordIndex - secondWordIndex) < minDistance)
					minDistance = Math.abs(firstWordIndex - secondWordIndex);
			}

		}

		putDistanceMap(word1, word2, minDistance);
		return minDistance;

	}

	public static void main(String[] args) {
		String[] arr = new String[] { "practice", "makes", "perfect", "coding", "makes", "perfect", "perfect",
				"coding" };
		WordDistance wordDistance = new WordDistance(arr);
		// System.out.println("minDistance: " +
		// wordDistance.shortest("practice", "perfect"));
		// System.out.println("minDistance: " +
		// wordDistance.shortest("practice", "perfect"));
		// System.out.println("minDistance: " + wordDistance.shortest("perfect",
		// "practice"));
		// System.out.println("minDistance: " +
		// wordDistance.shortest("practice", "coding"));
		// System.out.println("minDistance: " + wordDistance.shortest("coding",
		// "perfect"));
		// System.out.println("minDistance: " + wordDistance.shortest("perfect",
		// "coding"));
		System.out.println("minDistance: " + wordDistance.shortest("perfect", "perfect"));

		arr = new String[] {};
		wordDistance = new WordDistance(arr);
		System.out.println("minDistance: " + wordDistance.shortest("practice", "perfect"));
	}
}