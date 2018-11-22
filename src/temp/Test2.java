package temp;

/**
 * @author Mr.Bao
 * @create 2018-09-25-19:23
 * @since 1.0.0
 */
public class Test2 {

    public static void main(String[] args) {
        int a[] = {1, 2, 2};
        int num[] = new int[a.length];
        num[0] = 1;
        for(int i = 1;i<a.length;i++){
            if(a[i]<a[i-1]){
                if(num[i-1]==1){
                    num[i-1]=2;
                    num[i] = num[i-1] - 1;
                }else{
                    num[i]=1;
                }
            }else if(a[i]>a[i-1]){
                num[i] = num[i-1] + 1;
            }else if(a[i]==a[i-1]){
                num[i]=1;
            }
        }
        int result = 0;
        for(int i = 0;i<num.length;i++){
            result = num[i] + result;
        }
        System.out.println(result);
    }
}
