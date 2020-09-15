import java.util.Arrays;

class SelectionSort{
    
    void Sort(int[] v){
        for (int i = 0; i < v.length; i++) {
           
            int i_min = i;
          
            for (int j = i+1; j < v.length; j++) {
                
                if (v[j] < v[i_min]) {
                    i_min = j;
                }                
            }
            int aux = v[i];
            v[i] = v[i_min];
            v[i_min] = aux;
        }
    }
    void printArray(int[] arr){
        
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] a = {5,3,9,7,2,3,56,0,6,10,8};
        int[] b = {4,6,2,3,1,5};

        ss.Sort(a);
        ss.Sort(b);
        ss.printArray(a);
        ss.printArray(b);
    }
}
