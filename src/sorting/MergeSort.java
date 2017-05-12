package sorting;

public class MergeSort<T extends Comparable<T>> {
	public void sort(Comparable<T>[] arr) {
		Comparable<T>[] aux = (T[]) new Comparable[arr.length];
		sort(arr, aux, 0, arr.length - 1);
	}

	private void sort(Comparable<T>[] arr, Comparable<T>[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}

	private void merge(Comparable<T>[] arr, Comparable<T>[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (j > hi) {
				arr[k] = aux[i++];
			} else if (i > mid) {
				arr[k] = aux[j++];
			} else if (compare(aux[j], aux[i]) < 0) {
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}

	private int compare(Comparable x, Comparable y) {
		return x.compareTo(y);
	}

	private void printArr(Comparable<T>[] nums) {
		System.out.println("===\n");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static void main(String[] args) {
		MergeSort<String> m = new MergeSort<String>();
		String[] s = new String[] { "M","E","R","G","E","S","O","R","T" };
		m.sort(s);
		m.printArr(s);
	}
}
