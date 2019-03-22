package NiuKeOffer;

import common.TreeNode;
import java.util.ArrayList;


/**
 * @author Mr.Bao
 * @create 2019-03-21-22:45
 * @since 1.0.0
 */
public class No24FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findPath(result,list,root,target);
        return result;
    }

    public void findPath(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,TreeNode node,int target){
        if(node==null){
            return;
        }
        target = target - node.val;
        list.add(node.val);
        if(node.left==null&&node.right==null&&target==0){
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            result.add(copy);
        }else{
            findPath(result,list,node.left,target);
            findPath(result,list,node.right,target);
        }
        list.remove(list.size() - 1);
    }
}
