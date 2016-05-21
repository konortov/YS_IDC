
public class MergeSort implements Sorter {

	@Override
	public void sort(double[] ar) {
		// calls the recursive function Mergesort
		Mergesort(ar, 0, ar.length - 1);

	}

	private void Mergesort(double[] ar, int first, int last) {

		// if the first is smaller than the last,
		if (first < last) {
			// create a median (of indexes)
			int median = (first + last) / 2;
			// recuresively call the function to left and right
			Mergesort(ar, first, median);
			Mergesort(ar, median + 1, last);
			// merge the sorted parts
			Merge(ar, first, median, last);
		}

	}

	private void Merge(double[] ar, int first, int median, int last) {
		// create auxiliry numbers for array sizes
		int number1 = median - first + 1;
		int number2 = last - median;
		// create and copy left side to an array
		double[] leftArray = new double[number1 + 1];
		System.arraycopy(ar, first, leftArray, 0, number1);
		// create and copy right side to an array
		double[] rightArray = new double[number2 + 1];
		System.arraycopy(ar, median + 1, rightArray, 0, number2);
		// sets the last as double max value so we know when to stop
		leftArray[number1] = Double.MAX_VALUE;
		rightArray[number2] = Double.MAX_VALUE;
		// setup indexes
		int i = 0;
		int j = 0;
		// run on both arrays and copy to the original according to right order
		for (int k = first; k < last +1; k++) {
			if (leftArray[i] <= rightArray[j]) {
				ar[k] = leftArray[i];
				i++;

			} else {
				ar[k] = rightArray[j];
				j++;
			}

		}

	}

}
