/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ssingh
 *
 */
public class RandomizedSet {

	private Map<Integer, Integer> indexMap;
	private List<Integer> numbers;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		indexMap = new HashMap<Integer, Integer>();
		numbers = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (indexMap.containsKey(val)) {
			return false;
		}
		numbers.add(val);
		indexMap.put(val, numbers.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!indexMap.containsKey(val)) {
			return false;
		}
		int index = indexMap.get(val);
		if (index < numbers.size() - 1) {
			numbers.set(index, numbers.get(numbers.size() - 1));
			indexMap.put(numbers.get(numbers.size() - 1), index);
		}
		numbers.remove(numbers.size() - 1);
		indexMap.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random random = new Random();
		return numbers.get(random.nextInt(numbers.size()));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomizedSet r = new RandomizedSet();
		r.insert(0);
		r.insert(1);
		r.remove(0);
		r.insert(2);
		r.remove(1);
		System.out.println(r.getRandom());

	}

}
