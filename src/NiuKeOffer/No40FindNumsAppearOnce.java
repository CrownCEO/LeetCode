package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-28-22:18
 * @since 1.0.0
 */
public class No40FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length==0){
            num1[0] = 0;
            num2[0] = 0;
        }
        int result = array[0];
        for(int i = 1;i<array.length;i++){
            result = result^array[i];
        }
        int index = findFirstBitIs1(result);
        for(int i = 0;i<array.length;i++){
            if(isBit1(array[i],index)){
                num1[0] = num1[0]^array[i];
            }else{
                num2[0] = num2[0]^array[i];
            }
        }
    }

    public int findFirstBitIs1(int num){
        int index = 0;
        while((num & 1)==0 && index < 32){
            num = num >>1;
            index = index + 1;
        }
        return index;
    }

    public boolean isBit1(int num,int index){
        num = num >> index;
        return (num & 1) != 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,3,3,4,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new No40FindNumsAppearOnce().FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

}
