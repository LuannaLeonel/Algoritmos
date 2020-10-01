import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr, int left, int right){
       if (left<right){
           int meio = (left + right) / 2;
           mergeSort(arr, left, meio);
           mergeSort(arr, meio+1, right);

           merge(arr, left, meio, right);
       }
       
        
    }
    private void merge(int[] arr, int ini, int meio, int fim){
        int[] aux = new int [arr.length];
        for (int i = ini; i <= fim; i++) {
            aux[i] = arr[i];    
        }
        
        int i = ini;
        int j = meio+1;
        int k = ini;
        
        while (i <= meio && j <= fim){
            if (aux[i] < aux[j]){
                arr[k] = aux[i];
                i++;
            } else{
                arr[k] = aux[j];
                j++;
            }
            k++;
        }
        while(j <= fim){
            arr[k++] = aux[j++];

        }
        while(i <= meio){
            arr[k++] = aux[i++];

        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
		int [] a = {7,8,9,5,6,4,2,1};
		System.out.println(Arrays.toString(a));
		ms.mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
    }

    
}
    


