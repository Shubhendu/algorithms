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
	public List<String> addOperators(String num, int target) {
		List<String> results = new ArrayList<String>();
		char[] digits = num.toCharArray();
		char[] resultArr = new char[2 * digits.length - 1];
		long n = 0L;

		for (int i = 0; i < digits.length; i++) {
			n = 10 * n + digits[i] - '0';
			resultArr[i] = digits[i];
			dfs(0, n, i + 1, i + 1, target, digits, resultArr, results);
			if (n == 0)
				break;
		}
		return results;
	}

	private void dfs(long left, long curr, int startIndex, int operandIndex, int target, char[] digits,
			char[] resultArr, List<String> results) {
		if (startIndex == digits.length) {
			if ((left + curr) == target)
				results.add(new String(resultArr));
			return;
		}

		long n = 0L;
		int j = operandIndex + 1;
		for (int i = startIndex; i < digits.length; i++) {
			n = 10 * n + digits[i] - '0';
			resultArr[j++] = digits[i];

			resultArr[operandIndex] = '+';
			dfs(left + curr, n, i + 1, j, target, digits, resultArr, results);

			resultArr[operandIndex] = '-';
			dfs(left + curr, -n, i + 1, j, target, digits, resultArr, results);

			resultArr[operandIndex] = '*';
			dfs(left, curr * n, i + 1, j, target, digits, resultArr, results);

			if (n == 0)
				break;
		}
	}

	public static void main(String[] args) {
		AdditionOperator a = new AdditionOperator();
		List<String> results = a.addOperators("123", 6);
		for (String str : results) {
			System.out.println(str);
		}
	}
}
