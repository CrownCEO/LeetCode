package A_Offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**leetcode 113
 * 同上一个题，这个题需要把和为固定值的路径保存下来.
 * 解法：
 * 我们需要定义一个 两层list作为结果返回，定义一个list array 作为中间路径保存的数据结构。
 * 递归需要传递的参数有 list,array,treeNode,sum
 * 当treeNode 为null时，直接return
 * 然后sum = sum - treeNode.val
 * array.add(treeNodde.val)
 * 当treeNode.left 与 treeNode.right 均不为空 而且sum==0时，需要将
 * array 复制一份 然后 list.add(arrayCopy)
 * 接着遍历左右子树。
 * 最后将array 中最后一个元素减去。
 * @author Mr.Bao
 * @create 2019-02-17-22:43
 * @since 1.0.0
 */
public class No25PathSumII {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> array = new ArrayList<>();
        findPath(list,array,root,sum);
        return list;
    }

    public void findPath(List<List<Integer>> list,List<Integer> array,TreeNode treeNode,int sum){
        if(treeNode==null){
            return ;
        }
        sum = sum - treeNode.val;
        array.add(treeNode.val);
        if(treeNode.left==null && treeNode.right==null && sum==0){
            List<Integer> copy = new ArrayList<>();
            copy.addAll(array);
            list.add(copy);
        }else{
            findPath(list,array,treeNode.left,sum);
            findPath(list,array,treeNode.right,sum);
        }

//        sum = sum + treeNode.val;
        array.remove(array.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        System.out.println(new No25PathSumII().pathSum(treeNode,22));
    }

}
