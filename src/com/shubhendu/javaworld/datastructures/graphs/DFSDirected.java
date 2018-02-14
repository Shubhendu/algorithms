package com.shubhendu.javaworld.datastructures.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DFSDirected {

	private static boolean detectCyclicDependency(HashMap<String, Set<String>> dependencyMap, String vertex,
			Set<String> visited, Set<String> inCallStack) {

		if (dependencyMap.get(vertex) == null) {
			return false;
		}

		visited.add(vertex);
		inCallStack.add(vertex);

		for (String child : dependencyMap.get(vertex)) {
			if (inCallStack.contains(child)) {
				return true;
			}
			if (!visited.contains(child) && detectCyclicDependency(dependencyMap, child, visited, inCallStack)) {
				return true;
			}
		}

		inCallStack.remove(vertex);
		return false;

	}

	public static boolean isCyclic(HashMap<String, Set<String>> dependencyMap) {

		Set<String> visited = new HashSet<String>();
		for (String vertex : dependencyMap.keySet()) {
			if (!visited.contains(vertex)
					&& detectCyclicDependency(dependencyMap, vertex, visited, new HashSet<String>())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		HashMap<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", new HashSet<>(Arrays.asList("C")));
		dependencyMap.put("B", new HashSet<>(Arrays.asList("A")));
		dependencyMap.put("C", new HashSet<>());
		dependencyMap.put("D", new HashSet<>(Arrays.asList("E")));
		dependencyMap.put("E", new HashSet<>(Arrays.asList("D")));

		System.out.print(isCyclic(dependencyMap));
	}

}
