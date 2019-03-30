package NiuKeOffer;

import common.TreeLinkNode;

/**
 * @author Mr.Bao
 * @create 2019-03-30-16:05
 * @since 1.0.0
 */
public class No56GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            pNode =  pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

}
