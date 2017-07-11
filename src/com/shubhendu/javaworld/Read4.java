/**
 * 
 */
package com.shubhendu.javaworld;

/**
 * @author ssingh
 *
 */
public class Read4 {
	/*
	 * The read4 API is defined in the parent class Reader4. int read4(char[]
	 * buf);
	 */

	public class Solution extends Reader4 {
		/**
		 * @param buf
		 *            Destination buffer
		 * @param n
		 *            Maximum number of characters to read
		 * @return The number of characters read
		 */
		public int read(char[] buf, int n) {

			if (buf.length < n) {
				return buf.length;
			}
			int i = 0;
			char[] temp = null;
			int count = 0;
			boolean eof = false;
			while (!eof || n > 0) {
				temp = new char[4];
				while (i < buf.length && i % 4 != 0) {
					temp[i] = buf[i];
				}

				count += read4(temp);
				n -= 4;

			}
			return count;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
