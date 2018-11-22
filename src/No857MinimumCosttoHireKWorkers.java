import java.util.*;

/**
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].
 * <p>
 * Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:
 * <p>
 * Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
 * Every worker in the paid group must be paid at least their minimum wage expectation.
 * Return the least amount of money needed to form a paid group satisfying the above conditions.
 *
 * @author Mr.Bao
 * @create 2018-10-14-22:30
 * @since 1.0.0
 */
public class No857MinimumCosttoHireKWorkers {

    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double res = Double.MAX_VALUE;
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = wage[i] * 1.0 / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });
        PriorityQueue<Double> pq = new PriorityQueue<>();
        double curSum = 0;
        for (double[] worker : workers) {
            curSum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) {
                curSum += pq.poll();
            }
            if (pq.size() == K) {
                res = Math.min(res, curSum * worker[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] quality = new int[]{5, 4};
        int[] wage = new int[]{14, 8};
        int K = 2;
        System.out.println(mincostToHireWorkers(quality, wage, K));

    }
}
