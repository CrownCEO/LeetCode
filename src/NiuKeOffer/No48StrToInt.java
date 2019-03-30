package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-30-9:48
 * @since 1.0.0
 */
public class No48StrToInt {

    public int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        int index = 0;
        int flag = -1;
        if(str.charAt(0)=='+'){
            index = index + 1;
            flag = 1;
        }else if(str.charAt(0)=='-'){
            index = index + 1;
        }else{
            flag = 1;
        }
        long num = 0;
        for(int i = index;i<str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
                num = num *10 + flag *(str.charAt(i) - '0');
                if(num>Integer.MAX_VALUE || num <Integer.MIN_VALUE){
                    num = 0;
                    break;
                }
            }else{
                num = 0;
                break;
            }
        }
        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(new No48StrToInt().StrToInt("+100"));
    }

}
