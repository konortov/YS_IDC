
public class RandomArrayFactory {

	/**
	 * A function to generate a random array of doubles
	 * 
	 * @param size
	 *            - the size of the array to generate
	 * @return - a random in size 'size' with random doubles rounded up to
	 *         10digits
	 */
	public static double[] getRandomArray(int size) {

		// first create the array
		double[] RandomArray = new double[size];
		// fill the array with random doubles using math.random
		for (int i = 0; i < RandomArray.length; i++) {
			// generate a random number, round it to have 10 digits.
			RandomArray[i] = round(Math.random(), 10);
		}

		return RandomArray;

	}

	private static double round(double value, int digits) {

	    long factor = (long) Math.pow(10, digits);
	    value = value * factor;
	    long temp = Math.round(value);
	    return (double) temp / factor;

	}
}
