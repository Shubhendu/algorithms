/**
 * 
 */
package maths;

import java.util.PriorityQueue;

import org.junit.Assert;

/**
 * https://leetcode.com/problems/add-digits/#/description Given a non-negative
 * integer num, repeatedly add all its digits until the result has only one
 * digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 *
 */
public class AddDigits {
	static class Interval {
		int start;
		int end;
	}

	public int addDigitsLoop(int num) {
		int sum = num;
		while (num > 9) {
			sum = numSum(num);
			num = sum;
		}
		return sum;
	}

	private int numSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

	// https://en.wikipedia.org/wiki/Digital_root
	public int addDigits(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddDigits addDigits = new AddDigits();
		Assert.assertSame(addDigits.addDigitsLoop(21312), addDigits.numSum(21312));
		System.out.println("Success");
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)-> (b - a));
		

	}

}
