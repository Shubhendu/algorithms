package dynamicProgramming;

public class LongestPalindromicSubseq {
	public int longestPalindromeSubseq(String s) {
		int[][] longest = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			longest[i][i] = 1;
			if ((i + 1) < s.length()) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					longest[i][i + 1] = longest[i][i] + 1;
				} else {
					longest[i][i + 1] = 1;
				}
			}
		}

		for (int j = 2; j < s.length(); j++) {
			for (int i = 0; i + j < s.length(); i++) {
				int currPos = i + j;
				if (s.charAt(i) == s.charAt(currPos)) {
					longest[i][currPos] = longest[i+1][currPos - 1] + 2;
				} else {
					longest[i][currPos] = Math.max(longest[i][currPos - 1], longest[i + 1][currPos]);
				}
			}
		}
		return longest[0][s.length() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubseq lps = new LongestPalindromicSubseq();
		System.out.println(lps.longestPalindromeSubseq("aacacdba"));

	}

}
