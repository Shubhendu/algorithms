package bits;

public class WordProduct {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}

		int len = words.length;
		int[] wordValues = new int[words.length];
		for (int i = 0; i < len; i++) {
			String s = words[i];
			for (char c : s.toCharArray()) {
				wordValues[i] |=  1 << (c - 'a') ;
			}
		}

		int maxLength = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((wordValues[i] & wordValues[j]) == 0) {
					maxLength = Math.max(maxLength, words[i].length() * words[j].length());
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		WordProduct wordProduct = new WordProduct();
		System.out.println(wordProduct.maxProduct(words));
	}

}
