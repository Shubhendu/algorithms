package com.shubhendu.javaworld.recursion;

import java.util.ArrayList;
import java.util.List;

//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//Examples:
//"123", 6 -> ["1+2+3", "1*2*3"]
//"232", 8 -> ["2*3+2", "2+3*2"]
//"105", 5 -> ["1*0+5","10-5"]
//"00", 0 -> ["0+0", "0-0", "0*0"]
//"3456237490", 9191 -> []

public class AdditionOperator {
	// public List<String> addOperators(String num, int target) {
	// List<String> results = new ArrayList<String>();
	// char[] digits = num.toCharArray();
	// char[] resultArr = new char[2 * digits.length - 1];
	// long n = 0L;
	//
	// for (int i = 0; i < digits.length; i++) {
	// n = 10 * n + digits[i] - '0';
	// resultArr[i] = digits[i];
	// dfs(0, n, i + 1, i + 1, target, digits, resultArr, results);
	// if (n == 0)
	// break;
	// }
	// return results;
	// }
	//
	// private void dfs(long left, long curr, int startIndex, int operandIndex,
	// int target, char[] digits,
	// char[] resultArr, List<String> results) {
	// if (startIndex == digits.length) {
	// if ((left + curr) == target)
	// results.add(new String(resultArr));
	// return;
	// }
	//
	// long n = 0L;
	// int j = operandIndex + 1;
	// for (int i = startIndex; i < digits.length; i++) {
	// n = 10 * n + digits[i] - '0';
	// resultArr[j++] = digits[i];
	//
	// resultArr[operandIndex] = '+';
	// dfs(left + curr, n, i + 1, j, target, digits, resultArr, results);
	//
	// resultArr[operandIndex] = '-';
	// dfs(left + curr, -n, i + 1, j, target, digits, resultArr, results);
	//
	// resultArr[operandIndex] = '*';
	// dfs(left, curr * n, i + 1, j, target, digits, resultArr, results);
	//
	// if (n == 0)
	// break;
	// }
	// }
	
	private int count = 0;
	
	public List<String> addOperators(String num, int target) {
		
		List<String> result = new ArrayList<String>();
		if (num == null || num.length() == 0) {
			return result;
		}
		char[] expression = new char[2 * num.length() - 1];
		long curr = 0;
		for (int i = 0; i < num.length(); i++) {
			expression[num.length() - i - 1] = Character.MIN_VALUE;
			char c = num.charAt(i);
			int digit = c - '0';
			curr = (curr * 10) + digit;
			expression[i] = c;
			dfs(result, num, target, expression, 0, curr, i + 1, i + 1);
			if (curr == 0) {
				break;
			}
		}
		return result;
	}

	private void dfs(List<String> result, String num, int target, char[] expression, long left, long curr, int startPos,
			int charPos) {
	
		
		if (startPos == num.length()) {
			System.out.println("Total count: " +this.count);
			if (left + curr == target) {
				result.add(new String(expression, 0, charPos));
			}
			return;
		}
		
		count++;
		
		long n = 0L;
		int j = charPos + 1;
		for (int i = startPos; i < num.length(); i++) {
			char c = num.charAt(i);
			int digit = c - '0';
			n = n * 10 + digit;

			expression[j++] = c;

			expression[charPos] = '+';
			dfs(result, num, target, expression, left + curr, n, i + 1, j);

			expression[charPos] = '-';
			dfs(result, num, target, expression, left + curr, -n, i + 1, j);

			expression[charPos] = '*';
			dfs(result, num, target, expression, left, curr * n, i + 1, j);

			if (n == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		AdditionOperator a = new AdditionOperator();
		List<String> results = a.addOperators("1234", 15);
		System.out.println("Total count: " +a.count);
		for (String str : results) {
			System.out.println(str);
		}
	}
}
