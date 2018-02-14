package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<String>();

		int start = 0;
		while (start < words.length) {
			int currLineLen = words[start].length();
			int end = start + 1;
			while (end < words.length) {
				if (words[end].length() + currLineLen + 1 > maxWidth)
					break;
				currLineLen += words[end].length() + 1;
				end++;
			}

			StringBuilder sb = new StringBuilder();
			int numOfSpaceSlots = end - start - 1;

			if (end == words.length || numOfSpaceSlots == 0) {
				for (int i = start; i < end; i++) {
					sb.append(words[i] + " ");
				}
				sb.deleteCharAt(sb.length() - 1);
				for (int i = sb.length(); i < maxWidth; i++) {
					sb.append(" ");
				}
			} else {
				int additionalSpacesPerWord = (maxWidth - currLineLen) / numOfSpaceSlots;
				int extraSpaceForFirstWord = (maxWidth - currLineLen) % numOfSpaceSlots;
				for (int i = start; i < end; i++) {
					int totalExtraSpace = additionalSpacesPerWord;
					if (extraSpaceForFirstWord > 0) {
						totalExtraSpace += 1;
						extraSpaceForFirstWord--;
					}
					 
					sb.append(words[i]);
					if (i < end - 1) {
						sb.append(" ");
						for (int j = 0; j < totalExtraSpace; j++) {
							sb.append(" ");
						}
					}

				}
			}
			lines.add(sb.toString());
			start = end;
		}

		return lines;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] line = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
		int l = 16;
		TextJustification t = new TextJustification();
		List<String> justified = t.fullJustify(line, l);
		System.out.println(justified);

	}

}
