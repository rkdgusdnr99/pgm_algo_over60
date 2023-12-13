import java.util.*;

public class number100 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> realQueue1 = new LinkedList<>();
        Queue<Integer> realQueue2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            realQueue1.add(queue1[i]);
            sum2 += queue2[i];
            realQueue2.add(queue2[i]);
        }
        if ((sum1 + sum2) % 2 != 0)
            return -1;

        int count = 0;
        int len = queue1.length + queue2.length;
        while (sum1 != sum2) {
            if (count > len)
                return -1;
            while (sum1 > sum2) {
                int temp1 = realQueue1.poll();
                sum1 -= temp1;
                sum2 += temp1;
                realQueue2.add(temp1);
                count++;
            }
            while (sum1 < sum2) {
                int temp2 = realQueue2.poll();
                sum2 -= temp2;
                sum1 += temp2;
                realQueue1.add(temp2);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        number100 solution = new number100();
        int[] numbers1 = {3, 2, 7, 2};
        int[] numbers2 = {4, 6, 5, 1};
        System.out.println(solution.solution(numbers1, numbers2));
    }
}
