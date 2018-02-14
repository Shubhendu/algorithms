package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RoundSum {

	public List<Integer> roundSum(List<Double> nums) {
		List<Integer> roundedNum = new ArrayList<Integer>();
		Map<Integer, Double> numMap = new HashMap<>();
		int i = 0;
		int sum = 0;
		double sumDouble = 0;
		for (double num : nums) {
			int x = (int) Math.floor(num);
			double diff = num - x;
			sum += x;
			sumDouble += num;
			numMap.put(i, diff);
			roundedNum.add(x);
			i++;
		}

		int diff = (int) Math.round(sumDouble) - sum;
		if (diff == 0) {
			return roundedNum;
		}
		List<Entry<Integer, Double>> mapList = new ArrayList<Entry<Integer, Double>>(numMap.entrySet());
		Collections.sort(mapList, (Comparator<Entry<Integer, Double>>) (a, b) -> b.getValue().compareTo(a.getValue()));

		for (int j = 0; j < mapList.size() && diff > 0; j++) {
			Entry<Integer, Double> e = mapList.get(j);
			roundedNum.set(e.getKey(), roundedNum.get(e.getKey()) + 1);
			diff--;
		}
		System.out.println("Rounded sum: " + Math.round(sumDouble));
		return roundedNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Double> nums = new ArrayList<Double>();
		nums.add(10.45);
		nums.add(5.49);
		nums.add(2.89);
		nums.add(1.119);
		RoundSum r = new RoundSum();
		System.out.println(r.roundSum(nums));
	}

}
