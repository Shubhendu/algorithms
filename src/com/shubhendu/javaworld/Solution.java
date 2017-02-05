package com.shubhendu.javaworld;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
		String sortedFrequency = null;
		if (s != null) {
			Map<Character, Integer> charMap = new HashMap<Character, Integer>();
			for (char c : s.toCharArray()) {
				if (charMap.get(c) == null) {
					charMap.put(c, 1);
				} else {
					int count = charMap.get(c);
					charMap.put(c, ++count);
				}

			}
			Comparator<Item> itemComparator = new ItemComparator();
			PriorityQueue<Item> charFrequencyQueue = new PriorityQueue<Item>(itemComparator);

			for (Entry<Character, Integer> entry : charMap.entrySet()) {
				charFrequencyQueue.add(new Item(entry.getValue(), entry.getKey()));
			}
			sortedFrequency = "";
			while (charFrequencyQueue.peek() != null) {
				Item item = charFrequencyQueue.poll();
				int frequency = item.getFrequency();

				for (int i = 0; i < frequency; i++) {
					sortedFrequency += item.getCharacter();
				}
			}

		}
		return sortedFrequency;
	}

	class Item {
		Integer frequency;
		Character character;

		public Item() {

		}

		public Item(int frequency, char c) {
			this.frequency = frequency;
			this.character = c;
		}

		public Integer getFrequency() {
			return frequency;
		}

		public void setFrequency(Integer frequency) {
			this.frequency = frequency;
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

	}

	class ItemComparator implements Comparator<Item> {
		public int compare(Item i1, Item i2) {
			return i2.getFrequency().compareTo(i1.getFrequency());
		}
	}
}
