/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ssingh
 *
 */
public class NumberToEnglish {

	private static final Map<Integer, String> NUMBER_STRING_MAP = Collections.unmodifiableMap(Stream
			.of(new SimpleEntry<>(0, "zero"), new SimpleEntry<>(1, "one"), new SimpleEntry<>(2, "two"),
					new SimpleEntry<>(3, "three"), new SimpleEntry<>(4, "four"), new SimpleEntry<>(5, "five"),
					new SimpleEntry<>(6, "six"), new SimpleEntry<>(7, "seven"), new SimpleEntry<>(8, "eight"),
					new SimpleEntry<>(9, "nine"), new SimpleEntry<>(10, "ten"), new SimpleEntry<>(11, "eleven"),
					new SimpleEntry<>(12, "twelve"), new SimpleEntry<>(13, "thirteen"),
					new SimpleEntry<>(14, "fourteen"), new SimpleEntry<>(15, "fifteen"),
					new SimpleEntry<>(16, "sixteen"), new SimpleEntry<>(17, "seventeen"),
					new SimpleEntry<>(18, "eighteen"), new SimpleEntry<>(19, "ninteen"),
					new SimpleEntry<>(20, "twenty"), new SimpleEntry<>(30, "thirty"), new SimpleEntry<>(40, "forty"),
					new SimpleEntry<>(50, "fifty"), new SimpleEntry<>(60, "sixty"), new SimpleEntry<>(70, "seventy"),
					new SimpleEntry<>(80, "eighty"), new SimpleEntry<>(90, "ninety"))
			.collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

	private final String SPACE = " ";
	private final int BILLION = 1000000000;
	private final int MILLION = 1000000;
	private final int THOUSAND = 1000;
	private final int HUNDRED = 100;
	private final int TWENTY = 20;
	private final int TEN = 10;
	

//	private String convertNumberToWord(long n, int limit, String prefix) {
//		long quotient = n / limit;
//		long remainder = n % limit;
//		StringBuilder sb = new StringBuilder();
//		
//		String quotientWord = null;
//		String remainderWord = null;
//		switch(limit){
//			case BILLION:
//				quotientWord = strigifyMillions(quotient);
//				remainderWord = strigifyMillions(remainder);
//				break;
//			case MILLION:
//				quotientWord = strigifyThousands(quotient);
//				remainderWord = strigifyThousands(remainder);
//				break;
//			case THOUSAND:
//				quotientWord = stringifyHundreds(quotient);
//				remainderWord = stringifyHundreds(remainder);
//				break;
//			case HUNDRED:
//				quotientWord = NUMBER_STRING_MAP.get((int)quotient);
//				sb.append(" hundred ");
//				remainderWord = strigifyTwoDigits(remainder);
//			default:
//				
//		}
//		
//		sb.append(quotientWord);
//		sb.append(prefix);
//		sb.append(remainderWord);
//		return sb.toString();
//	}
	
	private String strigifyBillions(long n) {
		if (n < BILLION)
			return strigifyMillions(n);

		long quotient = n / BILLION;
		long remainder = n % BILLION;
		StringBuilder sb = new StringBuilder();
		sb.append(strigifyThousands(quotient));
		sb.append(" billion ");
		sb.append(strigifyThousands(remainder));
		return sb.toString();

	}

	private String strigifyMillions(long n) {
		if (n < MILLION)
			return strigifyThousands(n);

		long quotient = n / MILLION;
		long remainder = n % MILLION;
		StringBuilder sb = new StringBuilder();
		sb.append(strigifyThousands(quotient));
		sb.append(" million ");
		sb.append(strigifyThousands(remainder));
		return sb.toString();
	}

	private String strigifyThousands(long n) {
		if (n < THOUSAND)
			return stringifyHundreds(n);

		long quotient = n / THOUSAND;
		long remainder = n % THOUSAND;
		StringBuilder sb = new StringBuilder();
		sb.append(stringifyHundreds(quotient));
		sb.append(" thousand ");
		sb.append(stringifyHundreds(remainder));
		return sb.toString();
	}

	private String stringifyHundreds(long n) {
		if (n < HUNDRED)
			return strigifyTwoDigits(n);

		long quotient = n / HUNDRED;
		long remainder = n % HUNDRED;
		StringBuilder sb = new StringBuilder();
		sb.append(NUMBER_STRING_MAP.get((int) quotient));
		sb.append(" hundred ");
		sb.append(strigifyTwoDigits(remainder));
		return sb.toString();
	}

	private String strigifyTwoDigits(long n) {
		if (n <= TWENTY)
			return NUMBER_STRING_MAP.get((int) n);

		long remainder = n % TEN;
		long quotient = (n / 10) * TEN;

		StringBuilder sb = new StringBuilder();
		sb.append(NUMBER_STRING_MAP.get((int) quotient));
		sb.append(SPACE);
		sb.append(NUMBER_STRING_MAP.get((int) remainder));
		return sb.toString();
	}

	public String convertNumber(long n) {
		String words = strigifyBillions(n);
		System.out.println(words);
		return words;
	}

	public static void main(String[] args) {
		NumberToEnglish converter = new NumberToEnglish();
		converter.convertNumber(99);
		converter.convertNumber(999);
		converter.convertNumber(1001);
		converter.convertNumber(2147483648L);
	}
}
