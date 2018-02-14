package com.shubh.javaworld;

import java.util.HashMap;
import java.util.Map;

public class Temparature {

	// Given a list of daily temperatures, produce a list that, for each day in
	// the input, tells you how many days you would have to wait until a warmer
	// temperature. If there is no future day for which this is possible, put 0
	// instead.
	//
	// For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76,
	// 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
	//
	// Note: The length of temperatures will be in the range [1, 30000]. Each
	// temperature will be an integer in the range [30, 100].

	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return temperatures;
		}

		int len = temperatures.length;
		int[] temps = new int[len];

		Map<Integer, Integer> tempIdxMap = new HashMap<Integer, Integer>();
		tempIdxMap.put(temperatures[len - 1], len - 1);

		for (int i = len - 2; i >= 0; i--) {
			tempIdxMap.put(temperatures[i], i);
			if (temperatures[i] < temperatures[i + 1]) {
				temps[i] = 1;
				continue;
			}

			int idx = findNextMax(temperatures[i], tempIdxMap);
			temps[i] = idx != Integer.MAX_VALUE ? (idx - i) : 0;
		}
		return temps;
	}

	private int findNextMax(int temp, Map<Integer, Integer> tempIdxMap) {
		int minIdx = Integer.MAX_VALUE;

		for (int i = temp + 1; i <= 100; i++) {
			if (tempIdxMap.containsKey(i)) {
				minIdx = Math.min(minIdx, tempIdxMap.get(i));
			}
		}
		return minIdx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [89,62,70,58,47,47,46,76,100,70]
		// Output:
		// [0,1,0,0,0,0,1,1,0,0]
		// Expected:
		// [8,1,5,4,3,2,1,1,0,0]
	}

}
