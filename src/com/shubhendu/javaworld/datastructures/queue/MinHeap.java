/**
 * 
 */
package com.shubhendu.javaworld.datastructures.queue;

/**
 * @author ssingh
 *
 */
public class MinHeap<T extends Comparable<T>> {

	Object[] arr;
	int currentPos;

	public MinHeap(int capacity) {
		arr = new Object[capacity];
	}

	public void push(T value) {
		arr[currentPos] = value;
		heapUp(value, currentPos);
		currentPos++;
	}

	@SuppressWarnings("unchecked")
	private void heapUp(T value, int currentPos) {
		if (currentPos == 0)
			return;

		while (currentPos > 0) {
			int parentIndex = currentPos % 2 == 0 ? (currentPos - 2) / 2 : (currentPos - 1) / 2;
			T parent = (T) this.arr[parentIndex];
			if (parent.compareTo(value) < 0 || parent.compareTo(value) == 0) {
				break;
			} else {
				T v = (T) this.arr[currentPos];
				this.arr[currentPos] = parent;
				this.arr[parentIndex] = v;
				currentPos = parentIndex;
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	public T extractMin() {
		T minElement = (T) this.arr[0];
		this.arr[0] = (T) this.arr[currentPos];
		this.arr[currentPos--] = null;
		
		return minElement;

	}
	
	private void heapDown(){
		
	}
	
	public static void main(String[] args) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>(5);
		minHeap.push(10);
		minHeap.push(5);
		minHeap.push(50);
		minHeap.push(60);
		minHeap.push(2);
	}

}
