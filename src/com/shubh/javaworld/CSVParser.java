package com.shubh.javaworld;

public class CSVParser {
	// Input
	// aa, bb, "aa","aa,aa,bb,cc", "aa"aa""
	// Output
	// aa|bb|aa|aa,bb,cc|aa"aa"

	public static String stringToCSV(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0, j = 0, quotes = 0;
		while (j < str.length()) {
			if (str.charAt(j) == '"') {
				quotes++;
			}
			if (str.charAt(j) == ',' && quotes % 2 == 0) {
				sb.append(buildString(str, i, j));
				sb.append("|");
				i = j + 1;
				quotes = 0;
			}
			j++;
		}
		return sb.toString();
	}

	private static String buildString(String str, int start, int end) {
		String sub = str.substring(start, end).trim();
		sub.replace("\"\"", "\"");
		return sub;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
