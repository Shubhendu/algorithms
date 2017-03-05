/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ssingh
 *
 */
public class NumberToWordLeetCode {

	private static final Map<Integer, String> WORD_MAP;
	static {
		Map<Integer, String> numMap = new HashMap<Integer, String>();
		numMap.put(0, "Zero ");
		numMap.put(1, "One ");
		numMap.put(2, "Two ");
		numMap.put(3, "Three ");
		numMap.put(4, "Four ");
		numMap.put(5, "Five ");
		numMap.put(6, "Six ");
		numMap.put(7, "Seven ");
		numMap.put(8, "Eight ");
		numMap.put(9, "Nine ");
		numMap.put(10, "Ten ");
		numMap.put(11, "Eleven ");
		numMap.put(12, "Twelve ");
		numMap.put(13, "Thirteen ");
		numMap.put(14, "Fourteen ");
		numMap.put(15, "Fifteen ");
		numMap.put(16, "Sixteen ");
		numMap.put(17, "Seventeen ");
		numMap.put(18, "Eighteen ");
		numMap.put(19, "Ninteen ");
		numMap.put(20, "Twenty ");
		numMap.put(30, "Thirty ");
		numMap.put(40, "Forty ");
		numMap.put(50, "Fifty ");
		numMap.put(60, "Sixty ");
		numMap.put(70, "Seventy ");
		numMap.put(80, "Eighty ");
		numMap.put(90, "Ninety ");
		WORD_MAP = Collections.unmodifiableMap(numMap);
	}

	private static final String BILLION_WORD = "Billion ";
	private static final String MILLION_WORD = "Million ";
	private static final String THOUSAND_WORD = "Thousand ";
	private static final String HUNDRED_WORD = "Hundred ";

	private static final int BILLION = 1000000000;
	private static final int MILLION = 1000000;
	private static final int THOUSAND = 1000;
	private static final int HUNDRED = 100;
	private static final int TWENTY = 20;

	private String getWord(int num, int divisor) {
		int mod = num % divisor;
		num = num / divisor;

		StringBuilder sb = new StringBuilder();
		switch (divisor) {
		case BILLION:
			sb.append(convertThousand(num));
			sb.append(BILLION_WORD);
			if (mod > 0)
				sb.append(convertMillion(mod));
			break;
		case MILLION:
			sb.append(convertHundred(num));
			sb.append(MILLION_WORD);
			if (mod > 0)
				sb.append(convertThousand(mod));
			break;
		case THOUSAND:
			sb.append(convertHundred(num));
			sb.append(THOUSAND_WORD);
			if (mod > 0)
				sb.append(convertHundred(mod));
			break;
		case HUNDRED:
			sb.append(convertTens(num));
			sb.append(HUNDRED_WORD);
			if (mod > 0)
				sb.append(convertTens(mod));
		default:
			convertTens(num);
		}

		return sb.toString();
	}

	private String convertBillion(int num) {
		if (num < BILLION)
			return convertMillion(num);

		return getWord(num, BILLION);
	}

	private String convertMillion(int num) {
		if (num < MILLION)
			return convertThousand(num);

		return getWord(num, MILLION);

	}

	private String convertThousand(int num) {
		if (num < THOUSAND)
			return convertHundred(num);

		return getWord(num, THOUSAND);
	}

	private String convertHundred(int num) {
		if (num < HUNDRED)
			return convertTens(num);

		return getWord(num, HUNDRED);
	}

	private String convertTens(int num) {
		if (num <= TWENTY)
			return WORD_MAP.get(num);

		int mod = num % 10;
		num = (num / 10) * 10;
		StringBuilder sb = new StringBuilder();
		sb.append(WORD_MAP.get(num));
		if (mod > 0)
			sb.append(WORD_MAP.get(mod));

		return sb.toString();
	}

	public String numberToWords(int num) {

		String str = convertBillion(num);
		System.out.println("num: " + num + " : " + str);
		return str.trim();
	}

	public static void main(String[] args) {
		NumberToWordLeetCode numConverter = new NumberToWordLeetCode();
		numConverter.numberToWords(199991);
		numConverter.numberToWords(87831);
		numConverter.numberToWords(99095);
		numConverter.numberToWords(2044010050);
		numConverter.numberToWords(990000);
		numConverter.numberToWords(10000000);
		numConverter.numberToWords(45);
		numConverter.numberToWords(19);
		numConverter.numberToWords(2147483647);
	}

}
