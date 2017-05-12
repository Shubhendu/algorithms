/**
 * 
 */
package com.shubhendu.javaworld;

import java.math.BigInteger;

/**
 * @author ssingh
 *
 */
public class MultiplyStrings {
	public static String multiply2(String num1, String num2) {

		
		char[] totalProd = new char[num1.length() + num2.length()];

		int n1Len = num1.length() - 1;
		int n2Len = num2.length() - 1;

		long rowProd = 0L;
		long sum = 0L;
		int carryOver = 0;

		for (int i = n1Len; i >= 0; i--) {
			int d1 = num1.charAt(i) - '0';
			carryOver = 0;
			for (int j = n2Len; j>= 0; j--) {
				int d2 = num2.charAt(j) - '0';
				
			}
		}

		return String.valueOf(totalProd);

	}

	public static String multiply(String num1, String num2) {

		int sum = 0;
		int firstNumLength = num1.length() - 1;
		int secondNumLength = num2.length() - 1;
		for (int i = firstNumLength; i >= 0; i--) {
			int firstDigit = Integer.valueOf(String.valueOf(num1.charAt(i)));
			String rowSum = null;
			int leftOver = 0;
			for (int j = secondNumLength; j >= 0; j--) {
				int secondDigit = Integer.valueOf(String.valueOf(num2.charAt(j)));
				int digitMultiple = (firstDigit * secondDigit) + leftOver;
				leftOver = digitMultiple % 10;
				Integer multipleVal = digitMultiple / 10;
				// System.out.println(digitMultiple + " : "+ multipleVal);
				if (rowSum != null) {
					rowSum = multipleVal.toString() + rowSum;
				} else {
					rowSum = multipleVal.toString();
				}
				System.out.println(rowSum);
			}
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(18 % 10);
		MultiplyStrings.multiply2("12231241253025", "10314012120131231231");
		BigInteger n1 = new BigInteger("10314012120131231231");
		BigInteger n2 = new BigInteger("12231241253025");
		System.out.println(n1.multiply(n2));
		System.out.println(Long.MAX_VALUE);
		

	}

}
