/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * @author ssingh
 *
 */
public class HammingWeight {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		long x = n & 0xffffffffl;
		while (x > 0) {
			if ((x & 1) == 1) {
				count++;
			}
			x = x >> 1;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingWeight hm = new HammingWeight();
		
		System.out.println(hm.hammingWeight(Integer.parseUnsignedInt("2147483648")));
		System.out.println(hm.hammingWeight(Integer.parseUnsignedInt("2147483647")));
		System.out.println(hm.hammingWeight(Integer.parseUnsignedInt("21474")));
		
	}

}
