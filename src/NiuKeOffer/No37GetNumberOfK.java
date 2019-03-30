package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-28-16:58
 * @since 1.0.0
 */
public class No37GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        if(array==null|| array.length==0){
            return 0;
        }
        int left = getFirst(array,k);
        int right = getEnd(array,k);
        return right - left + 1;
    }

    public int getFirst(int[] array,int k){
        int left = 0;
        int right = array.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(array[mid]==k){
                if(mid >0 && array[mid-1]!=k || mid==0){
                    return mid;
                }else{
                    right = mid-1;
                }
            }else if(array[mid]>k){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getEnd(int[] array, int k){
        int left = 0;
        int right = array.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(array[mid]==k){
                if(mid <array.length - 1 && array[mid + 1]!=k || mid==array.length-1){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else if(array[mid]<k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(new No37GetNumberOfK().getFirst(array,3));
        System.out.println(new No37GetNumberOfK().getEnd(array,3));
        System.out.println(new No37GetNumberOfK().GetNumberOfK(array,3));
    }
}
