/**
 * 
 */
package bits;

/**
 * @author ssingh
 *
 */
public class ReverseBits {

	public int reverseBits(int n) {
		int reversedNum = 0;
		int count = 0;
		while (count < 32) {
			reversedNum +=  (n & 1);
			n = n >>> 1;
			if (count < 31) {
				reversedNum = reversedNum << 1;
			}
			count++;
		}
		return reversedNum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(43261596));
		System.out.println(r.reverseBits(16));
		System.out.println(r.reverseBits(1));
		System.out.println(r.reverseBits(0));
		System.out.println(Integer.MAX_VALUE);

	}

}
