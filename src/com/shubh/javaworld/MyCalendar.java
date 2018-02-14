package com.shubh.javaworld;

import java.util.LinkedList;
import java.util.List;

public class MyCalendar {

	class Interval {
		int start;
		int end;

		public Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	List<Interval> bookings;

	public MyCalendar() {
		this.bookings = new LinkedList<Interval>();
	}

	public boolean book(int start, int end) {
		if (end <= start) {
			return false;
		}
		Interval newInterval = new Interval(start, end);
		int lo = 0;
		int hi = bookings.size() - 1;

		while (hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			Interval i = bookings.get(mid);
			if ((newInterval.start >= i.start && newInterval.start < i.end)
					|| (newInterval.end > i.start && newInterval.end < i.end)
					|| (newInterval.start < i.start && newInterval.end >= i.end)) {
				return false;
			} else if (newInterval.start >= i.end) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		bookings.add(lo, newInterval);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalendar myCalendar = new MyCalendar();
		 System.out.println(myCalendar.book(10, 20)); // returns true
		 System.out.println(myCalendar.book(15, 25)); // returns false
		 System.out.println(myCalendar.book(20, 30)); // returns true
		 System.out.println(myCalendar.book(5, 10));
		 System.out.println(myCalendar.book(2, 12));
		 System.out.println(myCalendar.book(29, 31));
		 System.out.println(myCalendar.book(3, 7));
		 System.out.println(myCalendar.book(30, 33));
		 System.out.println(myCalendar.book(25, 35));
		 System.out.println(myCalendar.book(34, 34));
		 System.out.println(myCalendar.book(34, 38));
//		System.out.println(myCalendar.book(47, 50));
//		System.out.println(myCalendar.book(33, 41));
//		System.out.println(myCalendar.book(39, 45));
//		System.out.println(myCalendar.book(33, 42));
//		System.out.println(myCalendar.book(25, 32));
//		System.out.println(myCalendar.book(26, 35));
//		System.out.println(myCalendar.book(19, 25));
//		System.out.println(myCalendar.book(3, 8));
//		System.out.println(myCalendar.book(8, 13));
//		System.out.println(myCalendar.book(18, 27));

	}

}
