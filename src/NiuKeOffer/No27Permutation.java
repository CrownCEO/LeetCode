package NiuKeOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Mr.Bao
 * @create 2019-03-22-21:23
 * @since 1.0.0
 */
public class No27Permutation {

    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()==0){
            return  new ArrayList<>();
        }
        TreeSet<String> tempRes = new TreeSet<String>();
        char[] chars = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        permutation(tempRes,chars,0);
        result.addAll(tempRes);
        return result;
    }

    public void permutation(TreeSet<String> tempRes,char[] chars,int k){
        if(k==chars.length-1){
            tempRes.add(new String(chars));
        }else{
            for(int i = k;i<chars.length;i++){
                swap(chars,k,i);
                permutation(tempRes,chars,k+1);
                swap(chars,k,i);
            }
        }
    }

    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new No27Permutation().Permutation("abc"));
    }

}
