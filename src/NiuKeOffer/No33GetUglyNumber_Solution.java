package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-28-10:57
 * @since 1.0.0
 */
public class No33GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {
        if(index==0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int nextUglyNumberIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(nextUglyNumberIndex < index){
            int min = min(result[index2] *2,result[index3]*3,result[index5] * 5);
            result[nextUglyNumberIndex] = min;
            while(result[index2] * 2 <= result[nextUglyNumberIndex]){
                index2++;
            }
            while(result[index3] * 3 <= result[nextUglyNumberIndex]){
                index3++;
            }
            while(result[index5] * 5 <= result[nextUglyNumberIndex]){
                index5++;
            }
            nextUglyNumberIndex++;
        }

        return result[index-1];
    }

    public int min(int num1,int num2, int num3){
        return Math.min(Math.min(num1,num2),num3);
    }
}
