
public class QuickSort implements Sorter {

	@Override
	public void sort(double[] ar) {
		int i = 0;
		int j = ar.length - 1;
		MyQuickSort(ar, i, j);

	}
	
	// The recursive QuickSort
	private void MyQuickSort(double[] ar, int i, int j) {
		if (i + 2 < j) {
			int q = Partition(ar, i, j);
			MyQuickSort(ar, i, q - 1);
			MyQuickSort(ar, q + 1, j);

		} else {
			for (int k = i; k < j; k++) {
				int lowIndex = k;
				for (int t = k + 1; t <= j; t++) {
					if (ar[lowIndex] > ar[t]) {
						lowIndex = t;
					}
				}
				if (ar[k] != ar[lowIndex]) {
					double temp = ar[k];
					ar[k] = ar[lowIndex];
					ar[lowIndex] = temp;
				}
			}
		}
	}

	/**
	 * split the array to 2 partitions with a pivot in the middle of them
	 * @return - the pivot index.
	 */
	private int Partition(double[] ar, int i, int j) {
		double x = ar[i];
		int indexPivot = i;
		i++;
		while (i < j) {
			while (ar[j] > x) {
				j--;
			}

			while (ar[i] < x) {
				i++;
			}
			if (i < j) {
				double temp = ar[j];
				ar[j] = ar[i];
				ar[i] = temp;
			} else {
				double temp = ar[indexPivot];
				ar[indexPivot] = ar[j + 1];
				ar[j + 1] = temp;
			}
		}

		return j + 1;

	}

}
