package Tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Bao
 * @create 2019-03-30-10:09
 * @since 1.0.0
 */
public class No257binaryTreePaths {

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        String temp = "";
        findPath(root,temp);
        return result;
    }

    public void findPath(TreeNode root,String temp){
        if("".equals(temp)){
            temp =  root.val + "";
        }else{
            temp = temp + "->" + root.val;

        }

        if(root.left==null && root.right==null){
            result.add(temp);
        }
        if(root.left!=null)
            findPath(root.left,temp);
        if(root.right!=null)
            findPath(root.right,temp);
    }
}
