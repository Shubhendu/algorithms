package dynamicProgramming;

import java.util.Arrays;

/**
 * Problem statement -
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears
 * in the same relative order, but not necessarily contiguous. Examples: LCS for
 * input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. LCS for input
 * Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

	public int findLongesCommonSubsequence(String str1, String str2) {
		/**
		 * let lcs[i][j] = longest common subsequence between str1[1..i] and str2[1..j]
		 * if str1[i] == str2[j]:
		 * 	lcs[i][j] = lcs[i-1][j-1] + 1
		 * else:
		 * lcs[i][j] = max(lcs[i-1][j], lcs[i],[j-1])
		 */
		int str1Length = str1.length();
		int str2Length = str2.length();

		int[][] lcs = new int[str1Length][str2Length];
		int lcsLen = 0;
		
		for (int i = 0; i < str1Length; i++) {
			Arrays.fill(lcs[i], 0);
		}
		for (int i = 1; i < str1Length; i++) {
			for (int j = 1; j < str2Length; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1] : lcs[i - 1][j];
				}
				if (lcs[i][j] > lcsLen){
					lcsLen = lcs[i][j];
				}
				System.out.print(lcs[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("LCS: "+lcsLen);
		return -1;
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.findLongesCommonSubsequence("ABCBDAB", "BDCABC");

	}

}
