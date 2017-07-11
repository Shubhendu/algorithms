/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * https://leetcode.com/problems/reverse-integer/#/description
 *
 */
public class Reverse {
	public int reverse(int x) {
		long rev = 0L;
		StringBuilder sb = new StringBuilder();
		boolean isNegative = x < 0;
		if (isNegative) {
			x = -x;
		}
		while (x > 0) {
			rev = 10 * rev + (x % 10);
			sb.append(x % 10);
			x = x / 10;
			if (isNegative && rev > -(Integer.MIN_VALUE + 1)) {
				return 0;
			} else if (!isNegative && rev > Integer.MAX_VALUE) {
				return 0;
			}
		}
		int reverse = Integer.valueOf(sb.toString());
		return isNegative ? -reverse : reverse;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reverse r = new Reverse();
//		System.out.println(r.reverse(12321321));
		System.out.println(Integer.MAX_VALUE + " : " + Integer.MIN_VALUE );
		System.out.println(r.reverse(100));

	}

}
