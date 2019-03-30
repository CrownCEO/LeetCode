package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-29-11:10
 * @since 1.0.0
 */
public class No43ReverseSentence {

    public String ReverseSentence(String str) {
        if(str.equals("") || str.length()==0){
            return str;
        }
        String[] strings = str.split(" ");
        if(strings.length==0){
            return str;
        }
        int i = 0;
        int j = strings.length - 1;
        while(i <j){
            swap(strings,i,j);
            i++;
            j--;
        }
        return convert(strings);
    }

    public String convert(String[] strings){
        String result = "";
        for(int i = 0;i<strings.length - 1;i++){
            result = result + strings[i] + " ";
        }
        result = result + strings[strings.length-1];
        return result;
    }

    public void swap(String[] strings,int i, int j){
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new No43ReverseSentence().ReverseSentence(""));
    }
}
