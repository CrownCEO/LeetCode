package Array;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * @author Mr.Bao
 * @create 2018-11-20-8:23
 * @since 1.0.0
 */
public class No621TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;
        for(int i = 0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        for(int i = 0;i<26;i++){
            if(freq[i]>maxFreq){
                maxFreq = freq[i];
                maxFreqCount = 1;
            }else if (freq[i]==maxFreq){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxFreqCount);

    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        System.out.println(new No621TaskScheduler().leastInterval(tasks,2));
    }
}
