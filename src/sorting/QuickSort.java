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

	private void sort(int[] arr, int lo, int hi) {
		if (hi <= lo)
			return;
		printArray(arr);
		int partition = pivot(arr, lo, hi);
		sort(arr, lo, partition - 1);
		sort(arr, partition + 1, hi);
	}

	private void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n ");
	}

	private int pivot(int[] arr, int i, int j) {
		int k = i;
		i = i + 1;

		while (true) {

			while (i < arr.length && arr[i] < arr[k])
				i++;

			while (j > k && arr[j] > arr[k])
				j--;

			if (i < j)
				swap(arr, i, j);
			else
				break;

		}

		swap(arr, k, j);
		k = j;

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
		int[] arr = new int[] { 20, 13, 11, 10, 21, 45, 32, 12 };
		QuickSort quickSort = new QuickSort();
		System.out.println("Original Array==");
		quickSort.printArray(arr);
		System.out.println("===\n ");
		quickSort.sort(arr);
		System.out.println(arr);
	}

}
