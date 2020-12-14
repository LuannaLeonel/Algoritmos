import java.util.Arrays;
import java.util.Scanner;

class IsHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Integer[] array = new Integer[input.length];
        
        for(int i = 0; i < input.length; i++){

            array[i] = Integer.parseInt(input[i]);
        }

        System.out.println(verifyHeap(array));

        sc.close();
    }

    public static boolean verifyHeap(Integer[] expected) {
		boolean isHeap = true;


		Integer[] original = expected;

		for (int i = 0; i < original.length; i++) {
			if (2 * i + 1 < original.length && original[i].compareTo((Integer) original[2 * i + 1]) < 0)
				isHeap = false;
			if (2 * i + 2 < original.length && original[i].compareTo((Integer) original[2 * i + 2]) < 0)
				isHeap = false;
		}

		return isHeap;
	}
    
}
