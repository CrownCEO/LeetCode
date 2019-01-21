package DynamicProgramming;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * @author Mr.Bao
 * @create 2019-01-05-15:54
 * @since 1.0.0
 */
public class No140WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(new No140WordBreakII().wordBreak(s, list));
    }
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<String>();
        int n = s.length();
        //对每一个i都形成一个可以跳跃的点
        List<Integer>[] pointer = new List[n];
        for(int i=0;i<n;i++) pointer[i]=new ArrayList<Integer>();
        //动态规划形成跳跃点
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                //递归的保证j-1可以形成单词，大大地剪枝
                String temp = s.substring(j, i + 1);
                if(wordDict.contains(temp)&&(j==0||pointer[j-1].size()>0))
                    pointer[i].add(j);
            }
        }
        //从后往前的递归
        helper(pointer, s, n-1, "");
        return result;
    }
    //DFS
    public void helper(List<Integer>[] pointer, String s, int i, String pattern){
        if(i<0){
            result.add(pattern);
            return;
        }
        for(Integer item:pointer[i]){
            String nextPattern = pattern.length()==0?s.substring(item,i+1):s.substring(item,i+1)+" "+pattern;
            helper(pointer, s, item-1, nextPattern);
        }
    }

}
