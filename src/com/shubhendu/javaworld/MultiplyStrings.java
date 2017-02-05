/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * @author ssingh
 *
 */
public class MultiplyStrings {
	public static String multiply(String num1, String num2) {

		int sum = 0;
		int firstNumLength = num1.length() -1;
		int secondNumLength = num2.length() -1;
		for (int i = firstNumLength; i >= 0; i--) {
			int firstDigit = Integer.valueOf(String.valueOf(num1.charAt(i)));
			String rowSum = null;
			int leftOver = 0;
			for (int j = secondNumLength; j >= 0; j--) {
				int secondDigit = Integer.valueOf(String.valueOf(num2.charAt(j)));
				int digitMultiple = (firstDigit * secondDigit) + leftOver;
				leftOver = digitMultiple % 10;
				Integer multipleVal = digitMultiple / 10;
//				System.out.println(digitMultiple + " : "+ multipleVal);
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
		System.out.println(18%10);
		MultiplyStrings.multiply("245", "89");

	}

}
