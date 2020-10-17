
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int[] v = new int[input.length];

        for (int i = 0; i < input.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        int k = sc.nextInt();
        sort(v,k,0,v.length-1);
        sc.close();
    }
    public static void sort(int[] array, int max, int leftIndex, int rightIndex) {

			int[] counting = new int[max+1];
			populaArray(counting);

			// frequência
			for (int i = leftIndex; i <= rightIndex; i++) {
                counting[array[i]] ++;
                System.out.println(toStringArray(counting));
			}


			// cumulativa
			for (int i = 1; i < counting.length; i++) {
				counting[i] += counting[i - 1];
            }
            System.out.println("Cumulativa do vetor de contagem - " + toStringArray(counting));

			int[] sortedArray = new int[array.length];
			populaArray(sortedArray);

			for (int i = rightIndex; i >= leftIndex; i--) {
				sortedArray[counting[array[i]] + leftIndex - 1] = array[i];
				counting[array[i]] -= 1;
			}
            System.out.println(toStringArray(counting));
            System.out.println(toStringArray(sortedArray));
			
        }

	
    public static String toStringArray(int[] array){
        String res = "";
        for(int i = 0; i < array.length; i++){
            if(res.length()==0){
                res += array[i];
            } else {
                res += " " + array[i];
            }
        }
        return res;
    }
    public static void populaArray(int[] array) {
		Arrays.fill(array, 0);
    }

}
