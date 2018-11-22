package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * @author Mr.Bao
 * @create 2018-11-21-21:37
 * @since 1.0.0
 */
public class No76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int minStart = 0,minEnd = 0;
        int count = t.length();
        for(char c:t.toCharArray()){
            map.put(c,map.containsKey(c)?map.get(c) + 1:1);
        }
        int left = 0;
        for(int right = 0;right < s.length();right++){
            char val = s.charAt(right);
            if(map.containsKey(val)){
                map.put(val,map.get(val) - 1);
                if(map.get(val) >=0){
                    count--;
                }
            }
            while(count==0){
                if(right - left < min){
                    min = right - left;
                    minStart=left;
                    minEnd = right;
                }
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                    if(map.get(temp) > 0) count++;
                }
                left++;
            }
        }
        return min==Integer.MAX_VALUE? "":s.substring(minStart,minEnd +1);

    }

    public static void main(String[] args) {
        System.out.println(new No76MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }
}
