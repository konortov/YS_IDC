
public class InsertionSort implements Sorter {

	/**
	 * sort an array using insertion sort
	 */
	@Override
	public void sort(double[] ar) {
		// init the vars needed
		double temp;
		
		for (int i = 1; i < ar.length; i++) {
			for (int j = i; j > 0; j--) {
		
				// pair wise comparison
				if (ar[j] < ar[j - 1]) {
					//switch accordingly
					temp = ar[j];
					ar[j] = ar[j - 1];
					ar[j - 1] = temp;

				}
			}

		}

	}

}
