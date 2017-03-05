/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Character c1;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++) {
				char c = str.toLowerCase().charAt(i);
				arr[c-'a']++;
				System.out.println(c + " : "+Integer.valueOf(arr[c-'a']));
			}
			String ns = new String(arr);

			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}

		result.addAll(map.values());

		return result;
	}
	
	public static void main(String[] args) {
		String[] arr = new String[] {"Torchwood", "DoctorWho", "abc", "bac", "bat"};
		List<List<String>> result = GroupAnagrams.groupAnagrams(arr);
	}
}
