package NiuKeOffer;


/**
 * @author Mr.Bao
 * @create 2019-03-13-22:25
 * @since 1.0.0
 */
public class No6MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while(array[left]>=array[right]){

            if((right - left) == 1){
                mid = right;
                break;
            }
             mid = (right - left) / 2 + left;
            if(array[mid] >=array[left]){
                left = mid;
            }
            if(array[mid] <= array[right]){
                right = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        System.out.println(new No6MinNumberInRotateArray().minNumberInRotateArray(new int[]{3,4,5,1,2}));

    }

}
