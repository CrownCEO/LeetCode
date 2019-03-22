package NiuKeOffer;

import A_Offer.No6ConstructBinaryTreefromPreorderandInorderTraversal;
import common.TreeNode;

/**
 * @author Mr.Bao
 * @create 2019-03-12-22:56
 * @since 1.0.0
 */
public class No4ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || pre.length==0){
            return null;
        }
        if(in==null || pre.length==0){
            return null;
        }
        return buildTree(pre,in,0,pre.length - 1,0,in.length - 1);
    }

    public TreeNode buildTree(int[]pre,int[]in,int preS,int preE,int inS,int inE){

        int rootValue = pre[preS];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;
        if(preS==preE){
            if(inS==inE && pre[preS]==in[inS]){
                return root;
            }
        }
        int index = inS;
        int inValue = in[index];
        while(inS<=inE && inValue !=rootValue){
            index++;
            inValue = in[index];
        }
        int leftLength = index - inS;
        int leftPreEnd = preS + leftLength;
        if(leftLength >0){
            root.left = buildTree(pre,in,preS + 1,leftPreEnd,inS,index-1);
        }
        if(leftLength < preE - preS){
            root.right = buildTree(pre,in,leftPreEnd + 1,preE,index + 1,inE);
        }
        return root;
    }

    public static void main(String[] args) {
        int [] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,6,8};
        System.out.println(new No4ReConstructBinaryTree().reConstructBinaryTree(preOrder,inOrder));

    }
}
