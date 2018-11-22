package RejectSampling;

/**
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.  Do NOT use system's Math.random().
 *
 * @author Mr.Bao
 * @create 2018-10-11-20:56
 * @since 1.0.0
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
public class No470ImplementRand10UsingRand7 {

    public int rand10() {
     while(true){
         int temp = (7 * (rand7() - 1)) + rand7() - 1;
         if(temp < 40){
             return temp%10 + 1;
         }
     }

    }

    public int rand7(){
        return 0;
    }

}
