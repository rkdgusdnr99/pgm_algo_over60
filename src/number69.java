import java.util.LinkedList;
import java.util.Queue;

public class number69 {
    public int[] goodSolution(int brown, int red) {
        int a = (brown+4)/2;
        int b = red+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }

    public int[] mySolution(int brown, int yellow) {
        int[] answer = {yellow + 2, 3};
        Queue<Integer> measure = findDivisors(yellow);
        while (!measure.isEmpty()) {
            int num = measure.poll();
            if ((yellow / num + 2) * (num + 2) - yellow == brown) {
                answer[0] = yellow / num + 2;
                answer[1] = num + 2;
                break;
            }
        }
        return answer;
    }

    public static Queue<Integer> findDivisors(int number) {
        Queue<Integer> divisorQueue = new LinkedList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorQueue.offer(i);
            }
        }
        return divisorQueue;
    }
}
