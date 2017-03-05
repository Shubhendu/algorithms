package com.shubhendu.javaworld;

public class Pow {

	public double myPow(double x, int n) {
		return pow(x, n);
	}

	private double pow(double x, int n) {
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
		System.out.println(p.myPow(2, -1));
		System.out.println(p.myPow(2, 0));
		System.out.println(p.myPow(2, 1));
		System.out.println(p.myPow(2, 5));
		System.out.println(p.myPow(2, 4));
		System.out.println(p.myPow(2, -4));
		System.out.println(p.myPow(2, -5));

		System.out.println(p.myPow(-2, -1));
		System.out.println(p.myPow(-2, 0));
		System.out.println(p.myPow(-2, 1));
		System.out.println(p.myPow(-2, 5));
		System.out.println(p.myPow(-2, 4));
		System.out.println(p.myPow(-2, -4));
		System.out.println(p.myPow(-2, -5));

		System.out.println(p.myPow(2.00000, -2147483648));
		System.out.println(Math.pow(2.00000, -2147483648));
		

	}

}
