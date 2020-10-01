import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int [] v = new int[input.length];
        for (int i = 0; i < input.length; i++){
            v[i] = Integer.parseInt(input[i]);
        }
        sort(v, 0);
        sc.close();
    }
    
    public static void sort(int[] array, int ini){
        int n = array.length;
        int min = ini;

        for (int i = ini +1; i < n ; i++){
            if (array[i] < array[min]){
                min = i;
            }
        }
        
        swap(array,min,ini);
        System.out.println(Arrays.toString(array));
        if (n- (ini +1) >1){
            sort(array, ini + 1);
        }

    }
    static void swap(int[] arr,int i,int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}