/**
 * 
 */
package com.shubhendu.javaworld.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class CloneGraph {
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		return cloneGraph(node, nodeMap);
	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap) {
		if (node == null) {
			return node;
		}
		if (nodeMap.containsKey(node.label)) {
			return nodeMap.get(node.label);
		}
		UndirectedGraphNode newGraphNode = new UndirectedGraphNode(node.label);
		nodeMap.put(newGraphNode.label, newGraphNode);

		for (UndirectedGraphNode n : node.neighbors) {
			newGraphNode.neighbors.add(cloneGraph(n, nodeMap));
		}
		return newGraphNode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node2.neighbors.add(node2);
		node1.neighbors.add(node2);
		node.neighbors.add(node1);
		node.neighbors.add(node2);

		CloneGraph c = new CloneGraph();
		UndirectedGraphNode result = c.cloneGraph(node);
		node.label = 21;
		System.out.println(result.label);

		node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);
		result = c.cloneGraph(node);
		node.label = 21;
		System.out.println(result.label);

	}

}
