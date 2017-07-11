/**
 * 
 */
package sorting;

/**
 * @author ssingh
 *
 */
public class QuickSort {

	public void sort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		sort(arr, 0, arr.length - 1);
	}

	public void threeWayQuickSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		threeWayQuickSort(arr, 0, arr.length - 1);
	}

	private void threeWayQuickSort(int[] arr, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		int val = arr[lo];
		while (i <= gt) {
			if (arr[i] < val) {
				swap(arr, i, lt);
				i++;
				lt++;
			} else if (arr[i] > val) {
				swap(arr, i, gt);
				gt--;
			} else {
				i++;
			}
		}
		threeWayQuickSort(arr, lo, lt - 1);
		threeWayQuickSort(arr, gt + 1, hi);

	}

	private void sort(int[] arr, int lo, int hi) {
		if (hi <= lo)
			return;
		// printArray(arr);
		int partition = pivot(arr, lo, hi);
		sort(arr, lo, partition - 1);
		sort(arr, partition + 1, hi);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n ");
	}

	private int pivot(int[] arr, int lo, int hi) {
		int k = lo;
		lo = lo + 1;

		while (true) {

			while (lo < hi && arr[lo] <= arr[k])
				lo++;

			while (hi > k && arr[hi] >= arr[k])
				hi--;

			if (lo >= hi)
				break;

			swap(arr, lo, hi);
		}

		swap(arr, k, hi);
		k = hi;

		return k;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45,
				32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12,
				20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13,
				11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10,
				21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12 };
		QuickSort quickSort = new QuickSort();
		System.out.println("Original Array==");
		// quickSort.printArray(arr);
		System.out.println("===\n ");
		long s = System.currentTimeMillis();
		quickSort.sort(arr);
		long e = System.currentTimeMillis();
		System.out.println("Time taken by normal Quicksort: " + (e - s));
		printArray(arr);

		s = System.currentTimeMillis();
		arr = new int[] { 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32,
				12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20,
				13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11,
				10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21,
				45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12, 20, 13, 11, 10, 21, 45, 32, 12 };
		quickSort.threeWayQuickSort(arr);
		e = System.currentTimeMillis();
		System.out.println("Time taken by 3way Quicksort: " + (e - s));
		printArray(arr);
		
		int x = -10;
		System.out.println(x & 0x7fffffff);
	}

}
