package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.List;

public class AddOperator {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
//		long sum = 0;
		add(num, target, 0, 0, 0, result, sb);
	
		return result;
	}

	private void add(String num, int target, long sum, int start, int m, List<String> result, StringBuilder sb) {
		if (start >= num.length()) {
			if (sum == target) {
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
			}
			return;
		}
		int count = 0;
		int n = 0;
		for (int idx = start; idx < num.length(); idx++) {
			count++;
			int digit = num.charAt(idx) - '0';
			n = 10 * n + digit;
			
			sb.append(n);
			sb.append("+");
			add(num, target, sum + n, idx + 1, n, result, sb);
			updateString(sb, count);
			
			sb.append(n);
			sb.append("-");
			add(num, target, sum - n, idx + 1, -n, result, sb);
			updateString(sb, count);
			
			sb.append(n);
			sb.append("*");
			add(num, target, sum - m + m * n, idx + 1, n * m, result, sb);
			updateString(sb, count);

			if (n == 0) {
				break;
			}
		}
	}

	private void updateString(StringBuilder sb, int count) {
		int j = 0;
		while (sb.length() > 0 && j <= count) {
			sb.deleteCharAt(sb.length() - 1);
			j++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOperator a = new AddOperator();
		System.out.println(a.addOperators("123", 24));
		// "1000000009"
		// 9
	}

}
