/**
 * 
 */
package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ssingh
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		// dp[i] represents if s.substring(0, i) is wordbreakable.
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String[] words = new String[] { "lee", "leetco", "leet", "tco",
		// "des", "code" };
		// List<String> wordDict = Arrays.asList(words);
		//
		// WordBreak wb = new WordBreak();
		// System.out.println(wb.wordBreak("leetcode", wordDict));
		// System.out.println(wb.wordBreak("tcodes", wordDict));
		// System.out.println(wb.wordBreak("tcodess", wordDict));
		// System.out.println(wb.wordBreak("deslee", wordDict));
		// System.out.println(wb.wordBreak("codelee", wordDict));
		// System.out.println(wb.wordBreak("cdelee", wordDict));
		// System.out.println(wb.wordBreak("leecodetco", wordDict));
		// System.out.println(wb.wordBreak("leecodetcodess", wordDict));
		// System.out.println(wb.wordBreak("leecodetcolee", wordDict));

		String[] words = new String[] { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };
		List<String> wordDict = Arrays.asList(words);
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				wordDict));
	}

}
