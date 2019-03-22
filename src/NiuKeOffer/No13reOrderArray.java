package NiuKeOffer;

/**
 * 题目如果不要求保证相对顺序，直接快排那个从两边往中间走就行了。
 * 如果要求保证相对顺序，需要找到第一个偶数的位置，然后把奇数之前到第一个偶数位置的数 往后移动
 * 一个位置，然后把奇数插入进去
 * @author Mr.Bao
 * @create 2019-03-17-11:19
 * @since 1.0.0
 */
public class No13reOrderArray {

    public void reOrderArray(int [] array) {
        int i = 0;
        int j = array.length;
        int index = -1;
        while(i < j){
            if(array[i] % 2==1){
                if(index >=0){
                    int s = array[i];
                    for(int k = i;k>index;k--){
                        array[k] = array[k - 1];
                    }
                    array[index] = s;
                    index++;
                }
              i++;
            }else{
                if(i==0){
                    index = 0;
                }
                if(index <0){
                    index = i;
                }
                i++;
            }
        }
    }


    public void reOrderArray2(int [] array) {
        if(array==null || array.length==0){
            return ;
        }

        int i = 0;
        int j = array.length - 1;
        while(i < j){
            while(i<j && array[i] %2==1){
                i++;
            }
            while(i<j && array[j] %2==0){
                j--;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
