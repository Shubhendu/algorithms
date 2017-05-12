/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author ssingh
 *
 */
public class ValidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> response = new ArrayList<String>();
		if (s == null || s.trim().length() == 0) {
			response.add("");
			return response;
		}
		Queue<String> q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();

		q.add(s);
		visited.add(s);

		int count = 1;
		while (!q.isEmpty()) {
			for (int qCount = 0; qCount < count; qCount++) {
				String str = q.poll();

				if (isValidParentheses(str)) {
					response.add(str);
					continue;
				}

				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) != '(' && str.charAt(i) != ')')
						continue;
					String newStr = str.substring(0, i) + str.substring(i + 1);

					if (!visited.contains(newStr)) {
						q.add(newStr);
						visited.add(newStr);
					}
				}
			}
			if (!response.isEmpty()) {
				return response;
			}
			count = q.size();
		}
		return response;
	}

	private boolean isValidParentheses(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} 
			if (s.charAt(i) == ')' && count-- == 0) {
				return false;
			}
		}
		return count == 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String s = "()())()";
//		ValidParentheses v = new ValidParentheses();
//		List<String> response = v.removeInvalidParentheses(s);
//		for (String str : response) {
//			System.out.println(str);
//		}
//
//		s = "(a)())()";
//		response = v.removeInvalidParentheses(s);
//		for (String str : response) {
//			System.out.println(str);
//		}
//
//		s = ")(";
//		response = v.removeInvalidParentheses(s);
//		for (String str : response) {
//			System.out.println(str);
//		}
//
//		s = "(())";
//		response = v.removeInvalidParentheses(s);
//		for (String str : response) {
//			System.out.println(str);
//		}
//
//		s = "((((())";
//		response = v.removeInvalidParentheses(s);
//		for (String str : response) {
//			System.out.println(str);
//		}
		
		int p = (int) Math.ceil(Math.log(6) / Math.log(2));
		int N = 2 * (int) Math.pow(2, p) - 1;
		
		System.out.println(N);

	}

}
