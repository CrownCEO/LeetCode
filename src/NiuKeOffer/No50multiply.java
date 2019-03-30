package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-30-10:30
 * @since 1.0.0
 */
public class No50multiply {


    public int[] multiply(int[] A) {
        if(A==null || A.length==0){
            return  new int[]{};
        }
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = A[0];
        D[A.length - 1] = A[A.length - 1];
        for(int i = 1;i<A.length;i++){
            C[i] = C[i-1] * A[i];
        }
        for(int i = A.length - 2;i>=0;i--){
            D[i] = D[i+1] * A[i];
        }
        B[0] = D[1];
        B[A.length - 1] = C[A.length-2];
        for(int i = 1;i<A.length-1;i++){
            B[i] = C[i-1] * D[i+1];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        new No50multiply().multiply(A);
    }

}
