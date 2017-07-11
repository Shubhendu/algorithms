/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class LFUCache {

	private int maxCapacity;
	private Map<Integer, Integer> valuesMap;
	private Map<Integer, Integer> frequencyMap;
	private Map<Integer, LinkedHashSet<Integer>> frequencyKeys;
	int minFrequency;

	public LFUCache(int capacity) {
		maxCapacity = capacity;
		valuesMap = new HashMap<Integer, Integer>();
		frequencyMap = new HashMap<Integer, Integer>();
		frequencyKeys = new HashMap<Integer, LinkedHashSet<Integer>>();
		minFrequency = 0;
	}

	public int get(int key) {
		if (!valuesMap.containsKey(key)) {
			return -1;
		}
		int value = valuesMap.get(key);
		incrementFrequency(key);
		return value;
	}

	private void incrementFrequency(int key) {
		int frequency = frequencyMap.get(key);
		removeFromFrequencyKeys(frequency, key);
		frequencyMap.put(key, frequency + 1);
		if (!frequencyKeys.containsKey(frequency + 1)) {
			frequencyKeys.put(frequency + 1, new LinkedHashSet<Integer>());
		}
		frequencyKeys.get(frequency + 1).add(key);
	}

	private void removeFromFrequencyKeys(int frequency, int key) {
		frequencyKeys.get(frequency).remove(key);
		if (frequencyKeys.get(frequency).isEmpty()) {
			frequencyKeys.remove(frequency);
			if (frequency == minFrequency) {
				minFrequency = frequency + 1;
			}
		}
	}

	public void put(int key, int value) {
		if (maxCapacity <= 0) {
			return;
		}
		if (valuesMap.containsKey(key)) {
			valuesMap.put(key, value);
			incrementFrequency(key);
		} else {
			if (valuesMap.size() >= maxCapacity) {
				evictLFUKey();
				valuesMap.put(key, value);
				setFrequency(key);
			} else {
				valuesMap.put(key, value);
				setFrequency(key);
			}
			incrementFrequency(key);
			minFrequency = 1;
		}
	}

	private void setFrequency(int key) {
		frequencyMap.put(key, 0);
		if (!frequencyKeys.containsKey(0)) {
			frequencyKeys.put(0, new LinkedHashSet<Integer>());
		}
		frequencyKeys.get(0).add(key);

	}

	private void evictLFUKey() {
		int keyToEvict = frequencyKeys.get(minFrequency).iterator().next();
		frequencyKeys.get(minFrequency).remove(keyToEvict);
		valuesMap.remove(keyToEvict);
		frequencyMap.remove(keyToEvict);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LFUCache lfuCache = new LFUCache(4);
		// lfuCache.put(10, 1);
		// lfuCache.put(20, 2);
		// System.out.println(lfuCache.get(10));
		// lfuCache.put(20, 3);
		// lfuCache.put(30, 4);
		// lfuCache.put(40, 5);
		// System.out.println(lfuCache.get(20));
		// lfuCache.put(50, 6);
		// System.out.println(lfuCache.get(30));

		LFUCache cache = new LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

	}

}
