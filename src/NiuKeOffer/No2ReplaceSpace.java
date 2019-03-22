package NiuKeOffer;

/**
 * @author Mr.Bao
 * @create 2019-03-12-22:34
 * @since 1.0.0
 */
public class No2ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
       char[] array =  str.toString().toCharArray();
       int count = 0;
       for(int i = 0;i<array.length;i++){
           if(array[i]==' '){
               count++;
           }
       }
       char[] array2 = new char[array.length + count * 2];
        int j = 0;
        for(int i =0;i<array.length;i++){
            if(array[i]==' '){
                array2[j++] = '%';
                array2[j++] = '2';
                array2[j++] = '0';
            }else{
                array2[j++] = array[i];
            }
        }
        return new String(array2);
    }

    public static void main(String[] args) {
        System.out.println(new No2ReplaceSpace().replaceSpace(new StringBuffer("We Are Happy")));
    }
}
