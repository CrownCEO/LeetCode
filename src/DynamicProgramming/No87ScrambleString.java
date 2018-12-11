package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/jin_kwok/article/details/51136509
 * @author Mr.Bao
 * @create 2018-12-06-20:20
 * @since 1.0.0
 */
public class No87ScrambleString {

    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return helper(s1, s2);
    }

    boolean helper(String s1, String s2) {
    String key = s1 + ","+s2;

    if(map.containsKey(key)) return map.get(key);
    if(s1.equals(s2)) {
        map.put(key, true);
        return true;
    }

    for(int i = 1; i < s1.length(); i++) {
        if(helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i), s2.substring(i))
                || helper(s1.substring(0, i), s2.substring(s1.length() - i)) && helper(s1.substring(i), s2.substring(0, s1.length() - i))) {
            map.put(key, true);
            return true;
        }
    }

    map.put(key, false);
    return false;
}

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(new No87ScrambleString().isScramble(s1,s2));
        System.out.println(new No87ScrambleString().isScramble("abcde","caebd"));
    }
}
