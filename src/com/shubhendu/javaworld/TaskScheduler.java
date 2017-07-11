/**
 * 
 */
package com.shubhendu.javaworld;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ssingh
 *
 */
public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		if (tasks == null) {
			return 0;
		}
		if (n == 0) {
			return tasks.length;
		}
		Map<Character, Integer> taskCount = new HashMap<Character, Integer>();
		for (char c : tasks) {
			taskCount.put(c, taskCount.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Character> waitingQueue = new PriorityQueue<Character>(
				(c1, c2) -> taskCount.get(c2) - taskCount.get(c1));
		for (Character c : taskCount.keySet())
			waitingQueue.add(c);

		Map<Integer, Character> coolDownMap = new HashMap<Integer, Character>();
		int count = 0;
		while (!waitingQueue.isEmpty() || !coolDownMap.isEmpty()) {

			int releaseTime = count - n - 1;
			if (coolDownMap.containsKey(releaseTime)) {
				waitingQueue.add(coolDownMap.remove(releaseTime));
			}
			if (!waitingQueue.isEmpty()) {
				char task = waitingQueue.poll();
				int remaining = taskCount.get(task) - 1;
				taskCount.put(task, remaining);
				if (remaining != 0) {
					coolDownMap.put(count, task);
				}
			}
			count++;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] tasks = new char[] {'A','A','A','B','B','B'};
		int k = 2;
		TaskScheduler t = new TaskScheduler();
		int c = t.leastInterval(tasks, k);
		System.out.println(c);
		
	}

}
