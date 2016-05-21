
public class RandSelect implements Selector {

	@Override
	public double select(double[] ar, int i) {

		// return the rank'ed number in the array using recreusive calls
		return RandSelectRec(ar, 0, ar.length - 1, i - 1);
	}

	private double RandSelectRec(double[] ar, int first, int last, int rank) {
		// if first and the last indexes are the same, return the number
		if (first == last) {
			return ar[last];
		}
		// if the indexes are 0 and 1, return either of them
		if (last - first <= 1) {
			return (first == rank) ? Math.min(ar[first], ar[last]) : Math.max(ar[first], ar[last]);
		}
		// create a pivot
		int pivot = RandPartition(ar, first, last);
		// if the rank equals the pivot value than return the pivot
		if (rank == pivot) {
			return ar[pivot];
		}
		// if the rank is smaller, recursive call the left
		if (rank < pivot) {
			return RandSelectRec(ar, first, pivot, rank);
		}
		// if the rank is bigger, recursive call to the right
		else {
			return RandSelectRec(ar, pivot + 1, last, rank);
		}

	}

	private int RandPartition(double[] ar, int first, int last) {
		// Partition (like Quicksort partition)
		int pivot = first;
		int left = first + 1;
		int right = last;
		while (left < right) {
			while (left <= last && ar[left] < ar[pivot]) {
				left++;
			}
			while (right >= first && ar[right] > ar[pivot]) {
				right--;
			}
			if (left < right && right >= first && left <= last) {
				double temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
			}
		}
		if (right < first) {
			return pivot;
		}
		if (left > last) {
			double temp = ar[pivot];
			ar[pivot] = ar[left - 1];
			ar[left - 1] = temp;
			return left - 1;
		}
		double temp = ar[pivot];
		ar[pivot] = ar[right];
		ar[right] = temp;
		return right;
	}

}
