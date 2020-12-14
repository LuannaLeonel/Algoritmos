import java.util.Arrays;
import java.util.Scanner;

class Build_Heap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Integer[] array = new Integer[input.length];
        
        for(int i = 0; i < input.length; i++){

            array[i] = Integer.parseInt(input[i]);
        }
        Heap heap = new Heap(array.length);
        heap.buildHeap(array);
        System.out.println(heap.getHeap());

        sc.close();
    }

}
class Heap{
    
    Integer[] array;
    int index = -1;

    private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 1) + 1;
    }
    private int parent(int i) {
        return (i-1)/2;
    }
    
    public Heap(int size){
        this.array = new Integer[size];
    }

    public void buildHeap(Integer[] arr) {
        this.array = arr;
        this.index = arr.length -1;

        for(int i = index/2; i >=0; i--){
            heapify(i);
        }
    }

    private void heapify(int pos){
       if (isLeaf(pos) || !isValidIndex(pos)) return;

       int max = getMax(pos, left(pos), right(pos));

       if (max != pos){
           swap(array, pos, max);
           heapify(max);
       }
    }
    private int getMax(int i, int left, int right) {
        if (this.array[i] > this.array[left]) {
            if (isValidIndex(right)) {
                if (this.array[i] < this.array[right])
                    return right;
            }
            return i;
        
        } else {
            if (isValidIndex(right)) {
                if (this.array[left] < this.array[right])
                    return right;
            } 
            
            return left;
        }
    }
    
    private void swap(Integer[] array, int i, int j) {
		Integer temp = array[i];
		array[i] = array[j];
		array[j] = temp;
    }
    
    public String getHeap(){
        return Arrays.toString(this.array);
    }
    private boolean isLeaf(int i) {
        return i > parent(index) && i <= index; 
    } 
    private boolean isValidIndex(int i) {
        return i >= 0 && i <= index;
    }
}
