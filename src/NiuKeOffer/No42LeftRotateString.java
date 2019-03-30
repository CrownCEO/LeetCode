package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-28-23:23
 * @since 1.0.0
 */
public class No42LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if(str==null || str.length()==0){
            return "";
        }
        String s1 = str.substring(0,n);
        String s2 = str.substring(n,str.length());
        String first = rotate(s1);
        String second = rotate(s2);

        return rotate(first + second);
    }

    public String rotate(String str){
        int i = 0;
        int j = str.length() - 1;
        char[] result = str.toCharArray();
        while(i<j){
            swap(result,i,j);
            i++;
            j--;
        }
        return new String(result);
    }

    public void swap(char[] str, int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new No42LeftRotateString().LeftRotateString("1123",2));
    }
}
