package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> taskMap = new HashMap<>();
		for (char c : tasks) {
			taskMap.put(c, taskMap.getOrDefault(c, 0) + 1);
		}

		List<Character> taskOrder = new ArrayList<>();

		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<Entry<Character, Integer>>(
				(Comparator<Entry<Character, Integer>>) (a, b) -> (a.getValue() != b.getValue()
						? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey())));

		pq.addAll(taskMap.entrySet());

		while (!pq.isEmpty()) {
			int k = n + 1;
			List<Entry<Character, Integer>> tempList = new ArrayList<>();
			while (k > 0 && !pq.isEmpty()) {
				Entry<Character, Integer> entry = pq.poll();
				int newVal = entry.getValue() - 1;
				if (newVal != 0) {
					entry.setValue(newVal);
					tempList.add(entry);
				}
				taskOrder.add(entry.getKey());
				k--;
			}
			for (Entry<Character, Integer> entry : tempList) {
				pq.add(entry);
			}
			if (pq.isEmpty()) {
				break;
			}
			while (k > 0) {
				taskOrder.add(null);
				k--;
			}
		}

		return taskOrder.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[] { 'A', 'A', 'A', 'B', 'C', 'B', 'B', 'A', 'C' };
		TaskScheduler t = new TaskScheduler();
		System.out.println(t.leastInterval(chars, 2));
		
		int c = 9;
		System.out.println((char)((char) c + '0'));
	}

}
