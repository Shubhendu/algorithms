/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class CountOfPrimes {

	List<Integer> primeNumbers = null;

	public int countPrimes2(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
				
		}
		return count;
	}

	public int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		if (n <= 3) {
			return 1;
		}
		if (n <= 5) {
			return 2;
		}

		primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		primeNumbers.add(3);
		int left = 0;
		int right = 0;
		for (int i = 1; 6 * i <= n; i++) {
			left = 6 * i - 1;
			if (!isDivisibleByPrime(left)) {
				primeNumbers.add(left);
			}
			right = 6 * i + 1;
			if (right >= n) {
				break;
			}
			if (!isDivisibleByPrime(right)) {
				primeNumbers.add(right);
			}
		}
		return primeNumbers.size();
	}

	private boolean isDivisibleByPrime(int num) {
		System.out.println(num);
		for (int n : primeNumbers) {
			if ((num % n) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 499979;
		CountOfPrimes c = new CountOfPrimes();
		long curr = System.currentTimeMillis();
		System.out.println(c.countPrimes2(n));
		System.out.println(System.currentTimeMillis() - curr);
		
		System.out.println((char) (97 + 1));
	}

}
