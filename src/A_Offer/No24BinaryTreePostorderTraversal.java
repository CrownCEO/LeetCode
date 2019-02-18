package A_Offer;

import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 返回一个二叉树的后续遍历（非递归形式）
 * 解法：
 * 使用一个栈来存储根结点，当栈不为空的时候，从栈中取出结点，判断左右结点，不为空的话，加入到栈中。然后将结点存储到结果集合中，
 * 最后将结果集合逆序。因为存储到结果集合中的数据是 根 右 左的顺序，倒序以后是 根左右。
 * @author Mr.Bao
 * @create 2019-02-17-18:25
 * @since 1.0.0
 */
public class No24BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        while(!stack.empty()){
          TreeNode node =  stack.pop();
          if(node.left!=null){
              stack.push(node.left);
          }
          if(node.right!=null){
              stack.push(node.right);
          }
          result.add(node.val);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
        System.out.println(new No24BinaryTreePostorderTraversal().postorderTraversal(root));
    }
}
