package Math;

/**
 * Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned
 设定一个符号位，将符号记录下来，然后去除符号计算所有数字的和，然后把符号位加上和最大最小的
 Int值去比较，如果比INT_MAX大，或者比INT_MIN小，就将值设置为INT的极值。
 当然在求和的时候，sum 用long类型的
 * @author Mr.Bao
 * @create 2019-01-21-21:20
 * @since 1.0.0
 */
public class No8StringtoIntegeratoi {

    public int myAtoi(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        String string = str.trim();
        if(string==null|| string.length()==0){
            return 0;
        }
        char firstChar = string.charAt(0);
        int sign = 1, start = 0, len = string.length();
        long sum = 0;
        if(firstChar== '+'){
            sign = 1;
            start++;
        }else if(firstChar == '-'){
            sign = -1;
            start++;
        }
        for(int i = start;i < len; i++){
            if(!Character.isDigit(string.charAt(i))){
                return (int)sum * sign;
            }
            sum = sum * 10 + string.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && (-1) * sum < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)sum * sign;

    }

    public static void main(String[] args) {
        System.out.println(new No8StringtoIntegeratoi().myAtoi("-42"));
    }
}
