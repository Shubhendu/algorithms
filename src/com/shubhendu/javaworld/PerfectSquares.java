package com.shubhendu.javaworld;

public class PerfectSquares {

	public int numSquares(int n) {
		if (n == 0)
			return 0;
		if (n < 0)
			n = Math.abs(n);
		return numSquares(n, 0);
	}

	private int numSquares(int n, int count) {
//		System.out.println(n + " : " + count);

		if (n % 2 == 0) {
			if (2 * (int) Math.sqrt(n / 2) == n) {
				return 2;
			}
		} else if (n % 3 == 0) {
			if (3 * ((int) Math.sqrt(n / 3) * (int) Math.sqrt(n / 3)) == n) {
				return 3;
			}
		}

		int squareRoot = (int) Math.sqrt(n);

		if (squareRoot * squareRoot == n) {
			return ++count;
		} else {
			return numSquares(n - (squareRoot * squareRoot), ++count);
		}
	}

	public static void main(String[] args) {
		PerfectSquares perfectSqrs = new PerfectSquares();

		System.out.println(perfectSqrs.numSquares(-25));

	}

}
