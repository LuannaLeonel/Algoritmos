import java.util.Arrays;

class InsertionSort{
    void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] <= arr[j-1]){
                int aux = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = aux;
                j -= 1;
                
            }
        }
    }
    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {9,5,6,7,3,1};
        int[] b = {456,789,123};

        InsertionSort is = new InsertionSort();
        is.sort(a);
        is.sort(b);
        is.printArray(a);
        is.printArray(b);
    }

}