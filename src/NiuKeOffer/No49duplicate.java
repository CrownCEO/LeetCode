package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-30-10:23
 * @since 1.0.0
 */
public class No49duplicate {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0){
            return false;
        }
        for(int i = 0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    swap(numbers,i,numbers[i]);
                }
            }
        }
        return false;
    }

    public void swap(int[] numbers, int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
