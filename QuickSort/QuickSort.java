import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] a = {9,5,6,3,7,1,0,4};
        System.out.println(Arrays.toString(a));
        qs.quickSort(a, 0, (a.length-1));
        System.out.println(Arrays.toString(a));
    }
    
    public void quickSort(int[] arr, int left, int right){
       if (left < right){
           int p = hoare(arr,left,right);

           quickSort(arr,left, p);
           quickSort(arr, p+1, right);
       }
    }
    private int lomuto(int [] v,int low, int high){
        int pivot = v[high];
        int i = low-1;
        for (int j = low; j<= high-1; j++){
            if(v[j]<= pivot){
                i++;
                swap(v,i,j);
            }
        }
        swap(v, i+1, high);
        return i;
    }
    private int hoare(int [] v,int low, int high){
        int pivot = v[low];
        int i = low-1;
        int j = high +1;

        while (true){
            do {
                i++;
            } while (v[i]< pivot);

            do {
                j--;
            } while (v[j]> pivot);

            if (i>= j)
                return j;
            
            swap(v, i, j);
            
        }
        
    }
    private static void random(int[] arr, int lo, int hi){
        Random rand = new Random();
        int pivot = rand.nextInt(hi -lo)+lo;
        swap(arr, pivot, hi);
    }

    
    static void swap(int[] arr,int i,int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }



}