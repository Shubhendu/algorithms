package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisCombination {
	public List<String> generateParenthesis(int n) {
		List<String> combos = new ArrayList<String>();
		if (n < 1) {
			return combos;
		}
		StringBuilder sb = new StringBuilder();
		
		generateParenthesis(n, sb, 0, 0, combos);
		return combos;
	}

	private void generateParenthesis(int n, StringBuilder sb, int startCount, int endCount, List<String> combos) {

		if (startCount == endCount && startCount == n) {
			combos.add(sb.toString());
			return;
		}
		if (startCount < n) {
			sb.append("(");
			startCount++;
			generateParenthesis(n, sb, startCount, endCount, combos);
			startCount--;
			sb.deleteCharAt(sb.length() - 1);
		}
		if (endCount < startCount) {
			sb.append(")");
			endCount++;
			generateParenthesis(n, sb, startCount, endCount, combos);
			endCount--;
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ParenthesisCombination p = new ParenthesisCombination();
//		List<String> strs = p.generateParenthesis(2);
//		for (String s : strs) {
//			System.out.println(s);
//		}
		
			for (int i=0; i < 10; i++) {
				double r = Math.random();
				System.out.println(r);
			}
			
		
	}

}
