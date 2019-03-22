package NiuKeOffer;

import A_Offer.No23BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author Mr.Bao
 * @create 2019-03-21-22:19
 * @since 1.0.0
 */
public class No23VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0){
            return false;
        }
        int root = sequence[sequence.length - 1];
        int index = 0;
        boolean left = true,right = true;
        while(sequence[index]<root){
            index++;
        }
        for(int i = index;i<sequence.length - 1;i++){
            if(sequence[i]<root){
                return false;
            }
        }
        if(index>0){
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,index));
        }
        if(index<sequence.length - 1){
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,index,sequence.length - 1));
        }
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new No23VerifySquenceOfBST().VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10}));
    }



}
