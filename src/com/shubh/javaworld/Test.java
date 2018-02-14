package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class EntryComparator implements Comparator<Map.Entry<Integer, Integer>> {
	public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
		return e1.getValue() - e2.getValue();
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Integer> myMap = new HashMap<>();
		myMap.put(1, 100);
		myMap.put(2, 10);
		myMap.put(3, 50);
		myMap.put(4, 5);
		List<Map.Entry<Integer, Integer>> mapList = new LinkedList<>(myMap.entrySet());
		Collections.sort(mapList,
				(Comparator<Entry<Integer, Integer>>) (a, b) -> (a.getValue().compareTo(b.getValue())));

		for (Entry<Integer, Integer> entry : mapList) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		myMap.put(7, 15);
		System.out.println(myMap);
		
		
		List<Entry<Integer, Integer>> myList2 = new LinkedList<Entry<Integer, Integer>>(myMap.entrySet());
		Collections.sort(myList2, new EntryComparator());

		for (Entry<Integer, Integer> entry : myList2) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		List<String> myList = new ArrayList<String>();
		Set<List<String>> mySet = new HashSet<>();
		
		myList.add("A");
		myList.add("A");
		myList.add("A");
		mySet.add(new ArrayList<>(myList));
		
		myList = new ArrayList<String>();
		myList.add("A");
		myList.add("B");
		mySet.add(new ArrayList<>(myList));
		
		myList = new ArrayList<String>();
		myList.add("B");
		myList.add("A");
		mySet.add(new ArrayList<>(myList));
	}

}
