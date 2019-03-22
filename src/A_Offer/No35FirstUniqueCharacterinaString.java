package A_Offer;

/**leetcode 387
 * 在字符串中找出第一个只出现一次的字符
 * 解法：
 * 定义一个数组 用来存储 字符串中每个字母的个数，最后遍历数组 取出个数为1的 第一个 索引
 * @author Mr.Bao
 * @create 2019-02-22-9:23
 * @since 1.0.0
 */
public class No35FirstUniqueCharacterinaString {


    public int firstUniqChar(String s) {
        int[] character = new int[26];
        for(int i = 0;i<s.length();i++){
            character[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(character[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(   new No35FirstUniqueCharacterinaString().firstUniqChar("leetcode"));
    }

}
