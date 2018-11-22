package Brainteaser;

import java.util.Arrays;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * @author Mr.Bao
 * @create 2018-10-17-14:45
 * @since 1.0.0
 */
public class No777SwapAdjacentinLRString {

    public boolean canTransform(String start, String end) {

        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        int n = s.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (j < n && e[j] == 'X') j ++;
            while (i < n && s[i] == 'X') i ++;
            if (i == n || j == n) break;
            if (s[i] == 'R' && i > j) return false;
            if (s[i] == 'L' && i < j) return false;
            i ++;
            j ++;
        }
        return true;

    }

    public static void main(String[] args) {
        No777SwapAdjacentinLRString swapAdjacentinLRString = new No777SwapAdjacentinLRString();
        System.out.println(swapAdjacentinLRString.canTransform("RXXLRXRXR",
                "XRLXXRRLX"));
    }
}
