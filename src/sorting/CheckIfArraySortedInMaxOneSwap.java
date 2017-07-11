package sorting;

public class CheckIfArraySortedInMaxOneSwap {
	
//	Given array of integers find out whether it can be sorted in at most one swap.

	public boolean solution(int[] A) {
		int arrayLength = A.length;
		int swapCount = 0;
        
        // Find the first occurrence where A[i] > A[i+1] and swap A[i] with the minimum number in A[i+1] to A[arrayLength - 1]
		for (int i = 0; i < arrayLength - 1; i++) {
			if (A[i] > A[i + 1]) {
				int minIndex = findIndexOfSmallestElement(A, i + 1);
				swap(A, i, minIndex);
				swapCount++;
				break;
			}
		}
        
        // Array is already sorted. Return true
		if (swapCount == 0) {
			return true;
		}
        
        // Check whether array is still sorted after swapping once earlier.
		for (int i = 0; i < arrayLength - 1; i++) {
			if (swapCount > 1) {
				break;
			}
			if (A[i] > A[i + 1]) {
				swapCount++;
			}
		}

		return swapCount <= 1 ? true : false;
	}

	private void swap(int[] A, int i, int j) {
		int swp = A[i];
		A[i] = A[j];
		A[j] = swp;
	}

	// Returns the index of smallest element between A[idx+1] ..A[N]
	private int findIndexOfSmallestElement(int[] A, int idx) {
		int minIndex = idx;
		int min = A[idx];
		for (int i = idx; i < A.length; i++) {
			if (min >= A[i]) {
				min = A[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 5, 3, 3, 7};
		CheckIfArraySortedInMaxOneSwap sol = new CheckIfArraySortedInMaxOneSwap();
		System.out.println(sol.solution(arr));
	}
}
