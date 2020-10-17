package b;
import java.util.Arrays;


public class CountingSort{

    
    public static int[] sort(int[] A, int k){
        k = maior(A);

        int[] C = new int[k];
        frequencia(C, A);
        cumulativa(C);
        int[] B = new int[A.length];
        for(int i = A.length -1; i >=0; i--){
            B[C[A[i] -1] -1] = A[i];
            C[A[i]-1] -= 1;
        }
        
        return B;
    }
    public static int maior(int[] array){
        int maior = 0;
        for (int e: array){
            if(e > maior){
                maior = e;
            }
        }
        return maior;
    }
    public static void frequencia(int[] C, int[] A){
        for(int i = 0; i < A.length; i++){
            C[A[i]-1] += 1;
        }
    }
    public static void cumulativa(int[] C) {
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
        
    }
     public static void main(String[] args) {
         int[] A = { 0,0,0,0,0,0};
         System.out.println(Arrays.toString(A));
         System.out.println(Arrays.toString(sort(A, 0)));
     }
}