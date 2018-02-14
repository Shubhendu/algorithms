package com.shubh.javaworld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
	public int start;
	public int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MeetingRooms {

	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, (Comparator<Interval>) (a, b) -> a.start - b.start);
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>((Comparator<Interval>) (a, b) -> a.end - b.end);
		for (Interval i : intervals) {
			if (pq.isEmpty()) {
				pq.add(i);
			} else {
				Interval firstEndingMeeting = pq.poll();
				if (i.start > firstEndingMeeting.end) {
					Interval newInterval = new Interval(firstEndingMeeting.start, i.end);
					pq.add(newInterval);
				} else {
					pq.add(firstEndingMeeting);
					pq.add(i);
				}
			}
		}
		return pq.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRooms m = new MeetingRooms();
		Interval i1 = new Interval(5, 10);
		Interval i2 = new Interval(15, 20);
		Interval i3 = new Interval(0, 30);
		Interval[] intervals = new Interval[] { i1, i2, i3 };
		System.out.println(m.minMeetingRooms(intervals));
	}

}
