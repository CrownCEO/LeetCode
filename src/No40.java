import java.util.ArrayList;
import java.util.List;

/**字符串全排列
 * @author Mr.Bao
 * @create 2019-02-01-17:38
 * @since 1.0.0
 */
public class No40 {

    List<String> permutation(String str){
        List<String> a = new ArrayList<>();
        if(str==null || str.length()==0){
            return a;
        }
       char[] chars = str.toCharArray();
        Permutation(a,chars,0);
        return a;
    }

    public void Permutation(List<String> array, char[] str,int begin){
        if(begin==str.length-1){
            array.add(String.valueOf(str));
        }
        for(int i = begin;i<str.length;i++){
            if(i!=begin && str[i]==str[begin]){
                continue;
            }
            swap(str,i,begin);
            Permutation(array, str, begin + 1);
            swap(str, i, begin);
        }
    }

    private void swap(char[] str,int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(new No40().permutation("abc"));
    }
}
