
import java.util.Arrays;
import java.util.Scanner;

class countingNegativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];

        for (int i = 0; i < input.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        int max = sc.nextInt();
        int min = sc.nextInt();
        sort(v,max,min,0,v.length-1);
        sc.close();
    }
    public static void sort(int[] array, int max, int min, int leftIndex, int rightIndex) {
		if (array.length > 0) {
			
			int range = (max - min) + 1;

			int[] counting = new int[range];
			populaArray(counting);
			int[] sorted = new int[array.length];
			populaArray(sorted);

			for(int i = leftIndex;i <= rightIndex; i++){
				counting[array[i] - min]++;
                System.out.println(Arrays.toString(counting));
            }
			for (int i = 1; i < counting.length; i++) {
				counting[i] += counting[i-1];
            }
            System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(counting));
			for (int i = rightIndex; i >= leftIndex; i--) {
				sorted[counting[array[i] - min] + leftIndex - 1] = array[i];
				counting[array[i] - min]--;
            }
            System.out.println(Arrays.toString(counting));
            System.out.println(Arrays.toString(sorted));


		
		}
    }
    public static void populaArray(int[] array) {
		Arrays.fill(array, 0);
    }

}
