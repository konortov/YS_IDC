
public class RadixSort implements Sorter {

	@Override
	public void sort(double[] ar) {

		for (int i = AlgorithmComparison.NUMBER_OF_DIGITS; i > 0; i--) {
			// for every digit do counting sort
			CountingSortBy(ar, i);
		}

	}

	private void CountingSortBy(double[] ar, int digit) {
		// setup counter array
		int[] counterArr = new int[AlgorithmComparison.NUMBER_OF_DIGITS];
		// count by digit
		for (int i = 0; i < ar.length; i++) {
			int index = getDigit(ar[i], digit);
			counterArr[index]++;

		}
		// add to the count by previous digit
		for (int i = 1; i < counterArr.length; i++) {
			counterArr[i] += counterArr[i - 1];
		}
		// setup the output array
		double[] sortedArr = new double[ar.length];
		// insert the values accordingly
		for (int i = ar.length - 1; i >= 0; i--) {
			int index = getDigit(ar[i], digit);
			sortedArr[counterArr[index] - 1] = ar[i];
			counterArr[index]--;
		}
		// update the input array to contain the output array
		for (int i = 0; i < sortedArr.length; i++) {
			ar[i] = sortedArr[i];
		}

	}

	// function to get the digit to sort by
	private int getDigit(double num, int digit) {
		num = num * Math.pow(10, digit);
		num = num % 10;
		num = Math.floor(num);
		return (int) num;

	}

}
