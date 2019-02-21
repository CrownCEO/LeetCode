package A_Offer;

/**leetcode 264 求出第 n 大的丑数，即求第n 个丑数
 * 解法：
 * 核心思想是创建一个数组，里面存放的是排好序的丑数，每一个新的丑数都是通过乘以前面的丑数得到的
 * 将前面的丑数 乘以 2，3，5得到的新的丑数，取最小值来作为新的丑数。
 * 一定存在一个丑数，排在它之前的每一个丑数乘以2 得到的结果 会小于已有的最大的丑数，
 * 而在它之后的每一个丑数乘以2 都将大于最大的丑数，我们取其中最小的那个的索引。
 * @author Mr.Bao
 * @create 2019-02-20-18:17
 * @since 1.0.0
 */
public class No34UglyNumberII {

    public int nthUglyNumber(int n) {
        if(n<=0){
            return 0;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int nextUnlyIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(nextUnlyIndex < n){
            int min = min(nums[index2] * 2, nums[index3] * 3, nums[index5] * 5);
            nums[nextUnlyIndex] = min;
            while(nums[index2] * 2 <= nums[nextUnlyIndex]){
                index2++;
            }
            while(nums[index3] * 3 <= nums[nextUnlyIndex]){
                index3++;
            }
            while(nums[index5] * 5 <= nums[nextUnlyIndex]){
                index5++;
            }
            nextUnlyIndex++;
        }
        return nums[n - 1];

    }

    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        new No34UglyNumberII().nthUglyNumber(10);
    }

}
