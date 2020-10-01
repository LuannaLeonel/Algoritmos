import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int [] v = new int[input.length];
        for (int i = 0; i < input.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        sort(v);
        System.out.println(Arrays.toString(v));
        sc.close();
    }
    static void sort(int[] arr){
        int j = arr.length-1;
        while (j > 0 && arr[j] <= arr[j-1]){
            int aux = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = aux;
            j -= 1;
        }
    }
}