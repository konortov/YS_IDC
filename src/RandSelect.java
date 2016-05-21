
public class RandSelect implements Selector {

	@Override
	public double select(double[] ar, int i) {
		// init the vars
		int first = 0;
		int last = ar.length - 1;
		int rank = i;

		// return the rank'ed number in the array using recreusive calls
		return RandSelectRec(ar, first, last, rank);
	}

	private double RandSelectRec(double[] ar, int first, int last, int rank) {
		// if first and the last indexs are the same, return the number
		if (first == last) {
			return ar[first];
		}
		// create a median
		int median = RandPartition(ar, first, last);
		// create a porpotional value
		int k = median - first + 1;
		// if the rank equals the porptional value than return the median
		if (rank == k) {
			return ar[median];
		}
		// if the rank is smaller, recursive call the left
		if (rank < k) {
			return RandSelectRec(ar, first, median - 1, rank);
		}
		// if the rank is bigger, recursive call to the right
		else {
			return RandSelectRec(ar, median + 1, last, rank - k);
		}

	}

	private int RandPartition(double[] ar, int first, int last) {

		double x = ar[first];
		int indexPivot = first;
		first++;
		while (first < last) {
			while (ar[last] > x) {
				last--;
			}

			while (ar[first] < x) {
				first++;
			}
			if (first < last) {
				double temp = ar[last];
				ar[last] = ar[first];
				ar[first] = temp;
			} else {
				double temp = ar[indexPivot];
				ar[indexPivot] = ar[last + 1];
				ar[last + 1] = temp;
			}
		}

		return last + 1;
	}

}
