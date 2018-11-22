package Array;

import javax.xml.ws.soap.MTOM;
import java.util.Stack;

import static java.lang.Math.max;

/**
 *如果高度一致都是递增的就一直压入栈，一旦遇到一个高度减小的，就计算栈里面能够组成的最大四边形面积（一个个出栈分别计算四边形面积）
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * @author Mr.Bao
 * @create 2018-10-29-19:54
 * @since 1.0.0
 */
public class No84LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int n=heights.length;
        int maxarea=0;
        int i=0;
        int temp=0;
        int tempTop=0;
        while(i<=n)
        {
            temp=(i==n?0:heights[i]);
            if(stack.isEmpty()||heights[stack.peek()]<=temp)
            {
                stack.push(i);
                i++;
            }
            else {
                tempTop=heights[stack.pop()];
                maxarea=Math.max(maxarea,tempTop*(stack.isEmpty()?i:i-1-stack.peek()) );
            }
        }


        return maxarea;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        No84LargestRectangleinHistogram histogram = new No84LargestRectangleinHistogram();
        System.out.println(histogram.largestRectangleArea(nums));
    }
}
