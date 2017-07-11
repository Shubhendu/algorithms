/**
 * 
 */
package sorting;

/**
 * @author ssingh
 *
 */
public class BottomUpMergeSort {
	public void sort(int[] nums) {
		int[] aux = new int[nums.length];
		int N = nums.length;

		for (int sz = 1; sz < N; sz = 2 * sz) {
			for (int lo = 0; lo < N - sz; lo += 2 * sz) {
				int right = Math.min(lo + 2*sz - 1, N - 1);
				int mid = lo + (right - lo) / 2;
//				int mid = lo + sz - 1;
				merge(nums, aux, lo, mid, right);
			}
		}
	}

	private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
		if (hi <= lo) {
			return;
		}
		for (int k = lo; k <= hi; k++) {
			aux[k] = nums[k];
		}
		int i = lo;
		int k = lo;
		int j = mid + 1;
		while (k <= hi) {
			if (j > hi) {
				nums[k++] = aux[i++];
			} else if (i > mid) {
				nums[k++] = aux[j++];
			} else if (aux[j] < aux[i]) {
				nums[k++] = aux[j++];
			} else {
				nums[k++] = aux[i++];
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {13,11,9,2,4,7,10};
		BottomUpMergeSort bottomUpMergeSort = new BottomUpMergeSort();
		bottomUpMergeSort.sort(nums);
		for (int n : nums) {
			System.out.print(n+ " ");
		}
				
	}

}
