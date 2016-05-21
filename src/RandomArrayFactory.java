
public class RandomArrayFactory {
	
	
	
	
	public static double[] getRandomArray(int size){
		
		//first create the array
		double[] RandomArray = new double[size];
		//fill the array with random doubles using math.random
		for (int i = 0; i < RandomArray.length; i++) {
			//generate a random number, round it to have 10 digits.
			RandomArray[i] = (double) Math.round(Math.random() * 10000000000d) / 10000000000d ;
		}
		
		return RandomArray;
		
		
	}
}
