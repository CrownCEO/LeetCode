package NiuKeOffer;

import java.util.Arrays;

/**
 * @author Mr.Bao
 * @create 2019-03-29-15:37
 * @since 1.0.0
 */
public class No44isContinuous {

    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length==0){
            return false;
        }
        int numZeroCount = 0;
        int intervalCount = 0;
        Arrays.sort(numbers);
        for(int i = 0;i<numbers.length - 1;i++){
            if(numbers[i]==0){
                numZeroCount++;
                continue;
            }
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            intervalCount = intervalCount + numbers[i+1] - numbers[i] - 1;
        }
        if(intervalCount > numZeroCount){
            return false;
        }
        return true;
    }
}
