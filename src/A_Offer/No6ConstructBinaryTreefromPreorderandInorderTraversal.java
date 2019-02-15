package A_Offer;


import common.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果都不含重复的数字。
 *
 * 解法：
 * 在二叉树的前序遍历中，第一个数字总是树的根结点的值。但在中序遍历序列中，根结点的值在序列的中间，左子树的结点的值
 * 位于根结点值的左边，而右子树的结点的值位于根结点的值的右边。
 * @author Mr.Bao
 * @create 2019-02-14-11:05
 * @since 1.0.0
 */
public class No6ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length == 0){
            return null;
        }
        int length = preorder.length;
        return constructTree(preorder, inorder,0,length - 1,0,length - 1);
    }

    public TreeNode constructTree(int[]preOrder, int[] inorder, int preStartIndex,int preEndIndex,int inStartIndex,int inEndIndex){
        int rootValue = preOrder[preStartIndex];
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = treeNode.right = null;
        //叶子结点 递归完毕返回
        if(preStartIndex==preEndIndex){
            if(inStartIndex == inEndIndex && preOrder[preStartIndex] == inorder[inStartIndex]){
                return treeNode;
            }
        }
        int tempIndex = inStartIndex;
        int inValue= inorder[tempIndex];
        while(inStartIndex <= inEndIndex && inValue!=rootValue){
            tempIndex++;
            inValue = inorder[tempIndex];
        }
        int leftLength = tempIndex - inStartIndex;
        int leftPreEnd = preStartIndex + leftLength;
        if(leftLength > 0 ){
            treeNode.left = constructTree(preOrder,inorder,preStartIndex + 1,leftPreEnd,inStartIndex, tempIndex - 1);
        }
        if(leftLength < preEndIndex - preStartIndex){
            treeNode.right = constructTree(preOrder, inorder, leftPreEnd + 1, preEndIndex, tempIndex + 1, inEndIndex);
        }
        return treeNode;

    }

    public static void main(String[] args) {
        int [] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,6,8};
        System.out.println(new No6ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preOrder,inOrder));

    }

}
