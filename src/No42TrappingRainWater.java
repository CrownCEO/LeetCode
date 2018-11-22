/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * @author Mr.Bao
 * @create 2018-10-26-10:32
 * @since 1.0.0
 */
public class No42TrappingRainWater {

    public int trap(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int sum = 0;
        int min = 0;
        while(i<j){
            while(i<j&&height[i]<=min){
                sum = sum + min - height[i];
                i++;
            }

            while(i<j&&height[j]<=min){
                sum = sum + min - height[j];
                j--;
            }
            min = Math.min(height[i],height[j]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        No42TrappingRainWater water = new No42TrappingRainWater();
        System.out.println(water.trap(nums));
    }
}
