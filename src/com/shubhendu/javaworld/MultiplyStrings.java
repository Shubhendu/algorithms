/**
 * 
 */
package com.shubhendu.javaworld;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author ssingh
 *
 */
public class MultiplyStrings {
	public static String multiply2(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}
		char[] output = null;

		int n1Len = num1.length();
		int n2Len = num2.length();

		if (n1Len == 0 || n2Len == 0) {
			int len = Math.max(n1Len, n2Len);
			len = len > 0 ? len - 1 : 0;
			output = new char[len];
			Arrays.fill(output, '0');
			return String.valueOf(output);
		}

		int totalLen = n1Len + n2Len;
		output = new char[totalLen];
		Arrays.fill(output, '0');

		int prod = 0;
		int count = 0;
		int carryOver = 0;
		boolean allZeroes = false;

		for (int i = n1Len - 1; i >= 0; i--) {
			count = --totalLen;
			carryOver = 0;
			for (int j = n2Len - 1; j >= 0; j--) {
				prod = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + carryOver;
				allZeroes = prod == 0;
				prod = prod + output[count] - '0';
				output[count--] = (char) (prod % 10 + '0');
				carryOver = (prod / 10);
			}
			if (carryOver > 0) {
				output[count] = (char) ((output[count] - '0') + carryOver + '0');
			}
		}
		if (allZeroes) {
			return new String("0");
		}
		if (output[0] == '0') {
			return String.valueOf(output).substring(1);
		} else {
			return String.valueOf(output);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(18 % 10);
		MultiplyStrings.multiply2("99", "99");
		BigInteger n1 = new BigInteger("10314012120131231231");
		BigInteger n2 = new BigInteger("12231241253025");
		System.out.println(n1.multiply(n2));
		System.out.println(Long.MAX_VALUE);

	}

}
