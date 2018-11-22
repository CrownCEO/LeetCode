package Brainteaser;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * @author Mr.Bao
 * @create 2018-10-17-10:22
 * @since 1.0.0
 */
public class No319BulbSwitcher {

    public static void main(String[] args) {
        No319BulbSwitcher switcher = new No319BulbSwitcher();
        System.out.println(switcher.bulbSwitch(10000000));
        System.out.println(switcher.bulbSwitchEasy(10000000));
    }

    public int bulbSwitch(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int[] bulbs = new int[n];
        int sum = 0;
        for (int i = 0; i < bulbs.length; i++) {
            bulbs[i] = -1;
        }
        for (int i = 0; i < bulbs.length; i++) {
            bulbs[i] = -1 * bulbs[i];
        }
        for (int i = 0; i < bulbs.length; i++) {

            if((i+1)%2==0 && i!=0){
                bulbs[i]=-1;
            }
        }
        for (int i = 2; i < n-1; i++) {
            int temp = 0;
            for(int j = 1;temp<n;j++){
                temp = j*(i+1);
                if(temp>n){
                    break;
                }
                bulbs[temp-1] = bulbs[temp-1] * -1;
            }

        }
        bulbs[n-1] = bulbs[n-1] * -1;
        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i] == 1) {
                sum = sum + 1;
            }
        }
        return sum;


    }

    public int bulbSwitchEasy(int n) {
      return (int)(Math.sqrt(n));

    }

}
