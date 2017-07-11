package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	private Map<String, List<String>> map = new HashMap<String, List<String>>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<String>(wordDict);
		return wordBreak(s, wordDictSet);
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}

		if (map.containsKey(s)) {
			return map.get(s);
		}

		if (wordDict.contains(s)) {
			res.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String suffix = s.substring(i);
			if (wordDict.contains(suffix)) {
				List<String> prefixes = wordBreak(s.substring(0, i), wordDict);
				if (!prefixes.isEmpty()) {
					for (int j = 0; j < prefixes.size(); j++) {
						res.add(prefixes.get(j) + " " + suffix);
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}
	// Old method
	// public List<String> wordBreakOld(String s, List<String> wordDict) {
	// List<String> result = new ArrayList<String>();
	// if (s == null || s.length() == 0) {
	// result.add(new String(""));
	// return result;
	// }
	// this.dp = new boolean[s.length()][s.length()];
	// this.s = s;
	// Set<String> wordSet = new HashSet<String>(wordDict);
	// int lastRow = -1;
	// for (int i = 0; i < dp.length; i++) {
	// for (int j = i; j < dp.length; j++) {
	// if (wordSet.contains(s.substring(i, j + 1))) {
	// dp[i][j] = true;
	// if (j == dp.length - 1) {
	// lastRow = i;
	// }
	// }
	// }
	// }
	//
	// backTrack(lastRow, dp.length - 1, new StringBuilder(), result);
	// return result;
	// }
	//
	// private void backTrack(int r, int c, StringBuilder sb, List<String>
	// result) {
	// if (r < 0 || c < 0 || c < r) {
	// return;
	// }
	// if (dp[r][c]) {
	// sb.insert(0, " ").insert(0, s.substring(r, c + 1));
	// if (r == 0) {
	// result.add(sb.toString().trim());
	// sb.delete(r, c + 2);
	// return;
	// }
	// backTrack(r - 1, r - 1, sb, result);
	// sb.delete(0, c - r + 2);
	// }
	// backTrack(r - 1, c, sb, result);
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String[] strArr = new String[] { "a", "aa", "aaa", "aaaa", "aaaaa",
		// "aaaaaa", "aaaaaaa", "aaaaaaaa",
		// "aaaaaaaaa", "aaaaaaaaaa" };
		String[] strArr = new String[] { "cat", "cats", "and", "sand", "dog", "catsand", "catsa", "ca", "ts", "an", "d",
				"dog" };
		// String[] strArr = new String[] { "cat", "cats", "and", "sand", "dog",
		// "ndog"};
		List<String> wordDict = new ArrayList<String>();
		wordDict = Arrays.asList(strArr);
		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s = "catsanddog";
		WordBreak2 wb = new WordBreak2();
		List<String> result = wb.wordBreak(s, wordDict);

		for (String str : result) {
			System.out.println(str);
		}

	}

}
