/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class NestedWeightListSumII {

	public int nestedWeightSum1(List<NestedInteger> nestedIntegers) {
		int sum = 0;
		for (NestedInteger ni : nestedIntegers) {
			sum = sum + nestedWeightSum1(ni, 1);
		}
		return sum;
	}

	private int nestedWeightSum1(NestedInteger nestedInteger, int depth) {
		if (nestedInteger.isInteger()) {
			return nestedInteger.getInteger() * depth;
		}
		int sum = 0;
		for (NestedInteger ni : nestedInteger.getList()) {
			sum = sum + nestedWeightSum1(ni, depth + 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		NestedInteger ni1 = new NestedInteger(1);
		NestedInteger ni2 = new NestedInteger();
		ni2.add(new NestedInteger(1));
		ni2.add(new NestedInteger(2));
		NestedInteger ni3 = new NestedInteger(2);
		ni3.add(ni2);

		NestedInteger ni4 = new NestedInteger();
		ni4.add(new NestedInteger(1));
		List<NestedInteger> nestedIntegers = new ArrayList<NestedInteger>();
		nestedIntegers.add(ni1);
		nestedIntegers.add(ni3);
		nestedIntegers.add(ni4);

		NestedWeightListSumII nSum = new NestedWeightListSumII();
		System.out.println(nSum.nestedWeightSum1(nestedIntegers));
	}
}
