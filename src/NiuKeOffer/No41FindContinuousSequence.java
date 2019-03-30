package NiuKeOffer;

import java.util.ArrayList;

/**
 * @author Mr.Bao
 * @create 2019-03-28-22:41
 * @since 1.0.0
 */
public class No41FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum==0){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 1;
        int j = 2;
        int mid = (1 + sum) / 2;
        int curSum = i + j;
        while(i<mid){
            if(curSum==sum){
                result.add(getList(i,j));
            }
            while (curSum > sum && i <mid){
                curSum = curSum - i;
                i++;
                if(curSum==sum){
                    result.add(getList(i,j));
                }
            }
            j++;
            curSum = curSum + j;
        }
        return result;

    }

    ArrayList<Integer> getList(int start,int end){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = start;i<=end;i++){
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new No41FindContinuousSequence().FindContinuousSequence(100));
    }

}
