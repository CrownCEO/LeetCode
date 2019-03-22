package BiSi.TouTiao;


import java.util.Scanner;

/**
 * @author Mr.Bao
 * @create 2019-03-16-11:08
 * @since 1.0.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m  = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(getMedals(nums));


        }

    }


    public static int getMedals(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] forward = new int[n+1];
        int[] backward = new int[n+1];
        int mininum = 1000000;
        int midIndex = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] < mininum){
                mininum = nums[i];
                midIndex = i;
            }
        }
        int[] score = new int[nums.length + 1];
        System.arraycopy(nums,midIndex,score,0,nums.length - midIndex);
        System.arraycopy(nums,0,score,nums.length - midIndex,midIndex);
        score[score.length - 1] = nums[midIndex];

        int sum = 0;
        forward[0] = 1;
        for(int i =0;i<nums.length;i++){
            if(score[i+1] > score[i]){
                forward[i+1] = forward[i]+1;
            }else{
                forward[i+1] = 1;
            }
        }
        backward[nums.length] = 1;
        for(int i = nums.length;i>0;i--){
            if(score[i-1] > score[i]){
                backward[i-1] = backward[i-1] > (backward[i]+1) ? backward[i-1] : (backward[i] + 1);
            }else{
                backward[i-1] = 1;
            }
        }
        for(int i = 0;i<=nums.length;i++){
            sum = Math.max(forward[i],backward[i]) + sum;
        }
        sum -= 1;
        return sum;

    }
}
