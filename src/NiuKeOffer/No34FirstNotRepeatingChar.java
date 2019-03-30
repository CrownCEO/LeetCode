package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-28-11:22
 * @since 1.0.0
 */
public class No34FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        int[] result = new int[100];
        for(int i = 0;i<str.length();i++){
            result[str.charAt(i) - 'A']++;
        }
        for(int i = 0;i<str.length();i++){
            if(result[str.charAt(i)-'A']==1){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new No34FirstNotRepeatingChar().FirstNotRepeatingChar("aacb"));
    }

}
