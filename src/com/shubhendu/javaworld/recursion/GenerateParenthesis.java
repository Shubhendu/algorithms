/**
 * 
 */
package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n < 1) {
			return list;
		}
		char[] charArr = new char[2 * n];
		backTrack(list, charArr, 0, 0);
		return list;
	}

	private void backTrack(List<String> result, char[] charArr, int openCount, int closeCount) {
		if (openCount + closeCount == charArr.length) {
			result.add(new String(charArr));
			return;
		}
		if (openCount < charArr.length / 2) {
			charArr[openCount + closeCount] = '(';
			backTrack(result, charArr, openCount + 1, closeCount);
		}
		if (closeCount < openCount) {
			charArr[openCount + closeCount] = ')';
			backTrack(result, charArr, openCount, closeCount + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> result = gp.generateParenthesis(3);
		for (String r : result) {
			System.out.println(r);
		}
		
		System.out.println("---2--");
		result = gp.generateParenthesis(1);
		for (String r : result) {
			System.out.println(r);
		}
		
		System.out.println("---3--");
		result = gp.generateParenthesis(2);
		for (String r : result) {
			System.out.println(r);
		}

	}

}
