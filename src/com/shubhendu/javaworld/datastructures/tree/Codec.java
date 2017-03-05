package com.shubhendu.javaworld.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);

    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		if (node != null) {
    			sb.append(node.val);
    			sb.append(",");
    			queue.add(node.left);
    			queue.add(node.right);
    		} else {
    			sb.append("null,");
    		}

    	}
    	System.out.println("Serialized "+ sb.substring(0, sb.length() - 1));
    	return sb.substring(0, sb.length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null) {
    		return null;
    	}
    	String[] nodeArr = data.split(",");
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	
    	int i = 0;
    	TreeNode root = new TreeNode(Integer.valueOf(nodeArr[0]));
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode x = queue.poll();
    		String s = nodeArr[++i];
    		
    		if (!"null".equals(s)) {
    			x.left = new TreeNode(Integer.valueOf(s));
    			queue.add(x.left);
    		} else {
    			 x.left = null;
    		}

    		s = nodeArr[++i];

    		if (!"null".equals(s)) {
    			x.right = new TreeNode(Integer.valueOf(s));
    			queue.add(x.right);
    		} else {
    			 x.right = null;
    		}
    	}
   		return root;
    }
}