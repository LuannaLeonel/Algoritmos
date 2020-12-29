
import java.util.Arrays;

public class Extended {
    public static int[] sort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();
        int range = max - min + 1;
        int[] C = new int[range];
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            C[A[i] - min]++;
        }
        CountingSort.cumulativa(C);

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i] - min] - 1] = A[i];
            C[A[i] - min]--;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = { -3, -1, 4, -8, 10, 1, 0, 8, 14};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(sort(A)));
    }
}
