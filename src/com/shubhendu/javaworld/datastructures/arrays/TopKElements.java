/**
 * 
 */
package com.shubhendu.javaworld.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class TopKElements {
	// private class Item {
	// int num;
	// int count;
	// public Item(int num, int count) {
	// this.num = num;
	// this.count = count;
	// }
	// }
	// public List<Integer> topKFrequent(int[] nums, int k) {
	// if (nums == null) {
	// return null;
	// }
	//
	// List<Integer> result = new ArrayList<Integer>();
	// Map<Integer, Item> frequencyMap = new HashMap<Integer, Item>();
	// for (int n : nums) {
	// Item item = frequencyMap.getOrDefault(n, new Item(n, 0));
	// item.count = item.count + 1;
	// frequencyMap.put(n, item);
	// }
	//
	// PriorityQueue<Item> pq = new PriorityQueue<Item>((a,b) -> b.count -
	// a.count);
	//
	// for (Integer key: frequencyMap.keySet()) {
	// pq.add(frequencyMap.get(key));
	// }
	//
	// int count = 0;
	//
	// while(count < k) {
	// result.add(pq.poll().num);
	// count++;
	// }
	//
	// return result;
	// }

    public List<Integer> topKFrequent(int[] nums, int k) {		
        if (nums == null) {
			return null;
		}

		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(a, b) -> b.getValue() - a.getValue());

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			pq.add(entry);
		}

		int count = 0;

		while (count < k) {
			result.add(pq.poll().getKey());
			count++;
		}

		return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		TopKElements topK = new TopKElements();
		List<Integer> result = topK.topKFrequent(nums, k);
		for(int n : result) {
			System.out.println(n);
		}

	}

}
