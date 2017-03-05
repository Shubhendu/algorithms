/**
 * 
 */
package dynamicProgramming;

/**
 * @author ssingh
 *
 */
public class WildCardMatch {

	public String compressString(String pattern) {
		if (pattern == null)
			return null;

		String compressedPattern = null;
		int i = 0;
		int stringLength = pattern.length();
		StringBuilder sb = new StringBuilder();
		while (i < stringLength) {
			char currentChar = pattern.charAt(i);
			sb.append(currentChar);
			if (currentChar == '*') {
				while (i < stringLength && pattern.charAt(i) == '*')
					i++;
			} else {
				i++;
			}
		}
		compressedPattern = sb.toString();
		System.out.println("Original: " + pattern + " compressed: " + compressedPattern);
		return compressedPattern;

	}

	public boolean isMatch(String s, String p) {
		String compressedPattern = compressString(p);
		int row = s.length();
		int col = compressedPattern.length();
		boolean[][] matchedDP = new boolean[row + 1][col + 1];

		matchedDP[0][0] = true; // null pattern matches with null string

		for (int r = 1; r < row; r++) {
			matchedDP[r][0] = false; // null pattern does not match with any valid string character
		}

		// This will take care of base condition where we have '*' prefix in the pattern
		int pIndex = 1;
		while(pIndex <= col && compressedPattern.charAt(pIndex - 1) == '*'){
			matchedDP[0][pIndex] = true;
			pIndex++;
		}

		for (int c = pIndex; c < col; c++) {
			matchedDP[0][c] = false; // null pattern does not match with any valid string character
		}

		for (int r = 1; r <= row; r++) {
			char strChar = s.charAt(r-1);
			for(int c = 1; c <= col; c++) {
				char patChar = compressedPattern.charAt(c-1);
				if(strChar == patChar || patChar == '?') {
					matchedDP[r][c] = matchedDP[r - 1][c - 1];
				} else if (patChar == '*'){
					matchedDP[r][c] = matchedDP[r][c - 1] || matchedDP[r - 1][c];
				} else if (strChar != patChar) {
					matchedDP[r][c] = false;
				}
				System.out.println(strChar + " : " + patChar + " : " + matchedDP[r][c]);
			}
		}


		return matchedDP[row][col];
	}

	public int[] searchRange(int[] nums, int target) {
		int[] range = new int[] {-1, -1};
		if (nums == null || nums.length == 0)
			return range;
		int searchIndex = binarySearch(nums, target);
		if (searchIndex == -1)
			return range;
		int startIndex = searchIndex;
		int endIndex = searchIndex;

		while(startIndex >= 0 && nums[startIndex] == target){
			startIndex--;
		}

		while(endIndex < nums.length && nums[endIndex] == target){
			endIndex++;
		}

		range[0] = startIndex>= 0 && nums[startIndex] == target ? startIndex   : startIndex + 1;
		range[1] = endIndex < nums.length && nums[endIndex] == target ? endIndex   : endIndex - 1;
		System.out.println(range[0] + " : "+ range[1]);
		return range;
	}



	private int binarySearch(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (target < nums[mid])
				hi = mid - 1;
			else if (target > nums[mid])
				lo = mid + 1;
			else
				return mid;
		}

		return -1;

	}

	public static void main(String[] args) {
		WildCardMatch wildCardMatch = new WildCardMatch();
		//		wildCardMatch.compressString("abcde");
		//		wildCardMatch.compressString("**abc");
		//		wildCardMatch.compressString("a*****b**c******?");
		//		wildCardMatch.compressString("a*b*c*de");
		//		wildCardMatch.compressString("********");
		//		wildCardMatch.compressString("******?a");
		//		Assert.assertEquals(wildCardMatch.compressString("a*****b**c******?"), "a*b*c*?");
		//		System.out.println(wildCardMatch.isMatch("abc", "ab?"));
		//		System.out.println(wildCardMatch.isMatch("abc", "ab*"));
		//		System.out.println(wildCardMatch.isMatch("abc", "a*c"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "a**c"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "***?"));
		//		System.out.println(wildCardMatch.isMatch("aaabbbabc", "*abc"));
		//		System.out.println(wildCardMatch.isMatch("aaabbbabc", "a**bc"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "a******d"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "????"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "????e"));
		//		System.out.println(wildCardMatch.isMatch("abcd", "***"));

		int[] nums = new int[] {7, 7, 7, 7,7, 11};
		System.out.println(wildCardMatch.searchRange(nums, 10));
		System.out.println(wildCardMatch.searchRange(nums, 7));
	}





}
