/**
 * 
 */
package dynamicProgramming;

/**
 * @author ssingh
 *
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		String compressedPattern = compressPattern(p);
		boolean[][] result = new boolean[s.length() + 1][compressedPattern.length() + 1];

		result[0][0] = true;
		for (int i = 1; i < s.length(); i++) {
			result[i][0] = false;
		}

		for (int i = 1; i <= compressedPattern.length(); i++) {
			if (compressedPattern.charAt(i - 1) != '*') {
				result[0][i] = false;
			} else if ((i - 2) >= 0) {
				result[0][i] = result[0][i - 2];
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= compressedPattern.length(); j++) {
				if (s.charAt(i - 1) == compressedPattern.charAt(j - 1) || compressedPattern.charAt(j - 1) == '.') {
					result[i][j] = result[i - 1][j - 1];
				} else if (((j - 2) >= 0) && compressedPattern.charAt(j - 1) == '*') {
					result[i][j] = result[i][j - 2];
					if (!result[i][j] && (compressedPattern.charAt(j - 2) == s.charAt(i - 1)
							|| compressedPattern.charAt(j - 2) == '.')) {
						result[i][j] = result[i - 1][j] || result[i][j - 1];
					}
				}
			}
		}
		return result[s.length()][compressedPattern.length()];
	}

	private String compressPattern(String p) {
		StringBuilder sb = new StringBuilder();
		// int j = 0;
		// if (p.charAt(j) == '*') {
		// while (j < p.length() && p.charAt(j) == '*') {
		// j++;
		// }
		// }
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				sb.append(p.charAt(i));
				while (i < p.length() - 1 && p.charAt(i + 1) == '*') {
					i++;
				}
			} else {
				sb.append(p.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "fas";
		String p = "f.*as";
		RegularExpressionMatching re = new RegularExpressionMatching();
		System.out.println(re.isMatch(s, p));
		
		s = "aab";
//		p = "ca*b";
//		System.out.println(re.isMatch(s, p));
//		p = "cab";
//		System.out.println(re.isMatch(s, p));
		p = "a*b*";
		System.out.println(re.isMatch(s, p));
		p = ".*.";
		System.out.println(re.isMatch(s, p));
		p = "..";
		System.out.println(re.isMatch(s, p));
//
//		p = "*****c*****a*b**";
//		System.out.println(re.isMatch(s, p));

	}

}
