/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shubhendu.javaworld.datastructures.tries.TrieST;

/**
 * @author ssingh
 *
 */
public class TestTrieST {
	
	@Test
	public void testTrieST() {
		TrieST<Integer> trieSt = new TrieST<Integer>();
		trieSt.put("shell", 1);
		trieSt.put("shells", 2);
		trieSt.put("boy", 10);
		trieSt.put("abc", 11);
		trieSt.put("she", 1111);
		
		assertEquals(trieSt.get("she"), Integer.valueOf(1111));
		assertEquals(trieSt.get("abc"), Integer.valueOf(11));
		assertEquals(trieSt.get("abcd"), null);
		assertEquals(trieSt.get("shells"), Integer.valueOf(21));
		
	}
	
}
