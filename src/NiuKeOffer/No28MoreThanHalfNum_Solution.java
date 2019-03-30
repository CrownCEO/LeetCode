package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-22-21:51
 * @since 1.0.0
 */
public class No28MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        int count = 0;
        int current = 0;
        for(int i = 0;i<array.length;i++){
            if(count==0){
               current = array[i];
               count++;
            }else{
                if(array[i]==current){
                    count = count +1;
                }else{
                    count = count - 1;
                }
            }
        }
        int sum = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == current){
                sum = sum + 1;
            }
        }
        if(sum > array.length / 2){
            return current;
        }else{
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,5,4,2};
        System.out.println(new No28MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(array));
    }
}
