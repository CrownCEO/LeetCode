package Array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author Mr.Bao
 * @create 2018-10-22-19:32
 * @since 1.0.0
 */
public class No11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while(i < j){
           max = Math.max(max,Math.min(height[i],height[j]) * (j - i));
           int result = height[i]<height[j]?i++:j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        No11ContainerWithMostWater containerWithMostWater = new No11ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(array));
    }

}
