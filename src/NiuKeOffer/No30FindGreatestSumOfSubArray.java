package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-22-22:50
 * @since 1.0.0
 */
public class No30FindGreatestSumOfSubArray {


    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<array.length;i++){
            if(sum<0){
                sum = array[i];
            }else{
                sum = sum + array[i];
            }
            if(sum >maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(new No30FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }

}
