package com.shubhendu.javaworld;

import org.junit.Assert;

public class Pow {

	public double myPow(double x, int n) {
		return pow(x, n);
	}

	private double pow(double x, long n) {
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			n = -n;
			x = 1 / x;
		}

		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);

	}

	public static void main(String[] args) {
		Pow p = new Pow();
		Assert.assertEquals(Math.pow(2, -1), p.myPow(2, -1), 0);
		Assert.assertEquals(Math.pow(2, 0), p.myPow(2, 0), 0.0);
		Assert.assertEquals(Math.pow(2, 5), p.myPow(2, 5), 0.0);
		Assert.assertEquals(Math.pow(2, -4), p.myPow(2, -4), 0.0);

		Assert.assertEquals(Math.pow(-2, -4), p.myPow(-2, -4), 0.0);
		Assert.assertEquals(Math.pow(-2, 0), p.myPow(-2, 0), 0.0);
		Assert.assertEquals(Math.pow(-2, 5), p.myPow(-2, 5), 0.0);
		Assert.assertEquals(Math.pow(-2, 4), p.myPow(-2, 4), 0.0);

		Assert.assertEquals(p.myPow(2.00000, 2147483645), Math.pow(2.00000, 2147483645), 0.0);

	}

}
