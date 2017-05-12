/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 */
public class FirstBadVersion {
	private boolean isBadVersion(int n) {
		if (n >= 1702766719) {
			return true;
		}
		return false;
	}

	public int firstBadVersion(int n) {

		int lo = 1;
		int hi = n;
		int badVersion = -1;

		while (hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			System.out.println(mid + "===");
			if (isBadVersion(mid)) {
				badVersion = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return badVersion;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstBadVersion fbd = new FirstBadVersion();
		System.out.println(fbd.firstBadVersion(2126753390));

	}

}
