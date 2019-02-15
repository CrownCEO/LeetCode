package A_Offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3，4，5，1，2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1
 * 解法：
 * 和二分查找一样，我们使用两个指针分别指向数组的第一个元素和数组的最后一个元素。按照题目中旋转的规则，第一个元素应该是大于
 * 或者等于最后一个元素的。接着我们可以找到数组中间的元素。如果该元素大于或者等于第一个指针指向的元素。此时数组中的元素应该位于该中间元素的后面，
 *。我们可以把第一个指针指向该中间的元素。如果中间元素小于或者等于第二个指针指向的元素。此时数组中的最小的元素应该位于该中间元素的前面。我们可以把第二个
 * 指针指向该中间元素。
 * 循环条件：第一个指针指向的元素大于等于第二个指针指向的元素
 * 停止条件：两个指针相邻一个元素。第一个指针指向前半个数组的最后一个元素，第二个指针指向后半个数组的第一个元素。返回第二个指针指向的元素
 * @author Mr.Bao
 * @create 2019-02-14-14:48
 * @since 1.0.0
 */
public class No8FindMinimuminRotatedSortedArrayI {

    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int firstIndex = 0;
        int endIndex = nums.length - 1;
        int midIndex = firstIndex;
        while(nums[firstIndex] >= nums[endIndex]){
            if(endIndex - firstIndex == 1){
                midIndex = endIndex;
                break;
            }
            midIndex = (endIndex - firstIndex) / 2 + firstIndex;
            if(nums[midIndex] >= nums[firstIndex]){
                firstIndex = midIndex;
            }
            if(nums[midIndex] <= nums[endIndex]){
                endIndex = midIndex;
            }
        }
        return nums[midIndex];
    }

    public static void main(String[] args) {
        System.out.println(new No8FindMinimuminRotatedSortedArrayI().findMin(new int[]{3,4,5,1,2}));
    }
}
