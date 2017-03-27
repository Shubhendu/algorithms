/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * @author ssingh
 *
 */
public class Celebrity {
	private boolean knows(int x, int y) {
		return false;
	}

	public int findCelebrity(int n) {
		int l = 0;
		int r = n - 1;
		boolean left;
		boolean right;
		while (r > l) {
			left = false;
			right = false;
			if (knows(l, r)) {
				left = true;
			}
			if (knows(r, l)) {
				right = true;
			}
			if (left && !right) {
				l++;
			} else if (!left && right) {
				r--;
			} else {
				l++;
				r--;
			}
		}
		if (r < l) {
		    return -1;
		}
		
		int celebrity = l;
		
		for (int i = 0; i < n; i++) {
			if (i == celebrity) {
				continue;
			}
			if (knows(celebrity, i) || !knows(i, celebrity)) {
				return -1;
			}
		}
		return celebrity;
	}
}
