
public class QuickSort implements Sorter {

	@Override
	public void sort(double[] ar) {
		MyQuickSort(ar, 0, ar.length - 1);

	}

	// The recursive QuickSort
	private void MyQuickSort(double[] ar, int firstI, int lastI) {
		if (lastI - firstI <= 0) {
			return;
		}
		if (lastI - firstI == 1) {
			if (ar[lastI] < ar[firstI]) {
				double temp = ar[firstI];
				ar[firstI] = ar[lastI];
				ar[lastI] = temp;
			}
			return;
		}
		int pivotI = Partition(ar, firstI, lastI);
		MyQuickSort(ar, firstI, pivotI - 1);
		MyQuickSort(ar, pivotI + 1, lastI);
	}

	/**
	 * split the array to 2 partitions with a pivot in the middle of them
	 * 
	 * @return - the pivot index.
	 */
	private int Partition(double[] ar, int firstI, int lastI) {
		int indexPivot = firstI;
		int l = firstI + 1;
		int r = lastI;
		while (l < r) {

			while ((l <= lastI) && (ar[l] < ar[indexPivot])) {
				l++;
			}

			while ((r >= firstI) && (ar[r] > ar[indexPivot])) {
				r--;
			}

			if ((l <= lastI) && (r >= firstI) && (l < r)) {
				double temp = ar[l];
				ar[l] = ar[r];
				ar[r] = temp;
			}
		}

		if (r < firstI) {
			return indexPivot;
		}

		if (l > lastI) {
			double temp = ar[indexPivot];
			ar[indexPivot] = ar[l - 1];
			ar[l - 1] = temp;
			return l - 1;

		}
		double temp = ar[indexPivot];
		ar[indexPivot] = ar[r];
		ar[r] = temp;
		return r;

	}

}
