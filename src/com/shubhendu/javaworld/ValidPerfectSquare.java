/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False. Note: Do not use any built-in library function
 * such as sqrt. Example 1: Input: 16 Returns: True
 * 
 * Example 2: Input: 14 Returns: False
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		return checkPerfectSquare(1, num / 2, num);
	}

	private boolean checkPerfectSquare(long lo, long hi, int num) {

		if (lo * lo == num || hi * hi == num)
			return true;

		if (hi - lo == 1)
			return false;

		long mid = (lo + hi) / 2;

		long midSqr = mid * mid;
		if (midSqr == num)
			return true;
		else if (midSqr > num)
			return checkPerfectSquare(lo, mid, num);
		else
			return checkPerfectSquare(mid, hi, num);
	}

	public static void main(String[] args) {
		ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
		System.out.println("25: " + validPerfectSquare.isPerfectSquare(25));
		System.out.println("14: " + validPerfectSquare.isPerfectSquare(14));
		System.out.println("16: " + validPerfectSquare.isPerfectSquare(16));
		System.out.println("289: " + validPerfectSquare.isPerfectSquare(289));
		System.out.println("290: " + validPerfectSquare.isPerfectSquare(290));
		System.out.println("90000000: " + validPerfectSquare.isPerfectSquare(9000000));
	}
}
