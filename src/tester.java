
public class tester {

	public static void main(String[] args) {
		
		
		 double[] randfact = RandomArrayFactory.getRandomArray(6);
		
		for (int i = 0; i < 6; i++) {
			System.out.println(randfact[i]);
			
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		QuickSort intsort = new QuickSort();
		
		
		intsort.sort(randfact);
		
		
		for (int i = 0; i < 6; i++) {
			System.out.println(randfact[i]);
			
		}
		

	}

}
