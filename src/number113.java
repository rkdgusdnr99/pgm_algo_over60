import java.util.LinkedList;
import java.util.Queue;

public class number113 {
    private int index = 0;
    public int[][] goodSolution(int n) {
        int[][] answer = new int[(int) (Math.pow(2,n)-1)][2];

        move(n, 1, 3, 2, answer);
        return answer;
    }

    public void move(int n, int start, int end, int between, int[][] answer) { // 탑이 양 옆으로 이동하며 쌓인다는 것을 이용, 이를 규칙화함.
        if (n == 1) {
            answer[index++] = new int[]{start, end};
            return;
        }
        move(n - 1, start, between, end, answer);
        answer[index++] = new int[]{start, end};
        move(n - 1, between, end, start, answer);
    }
    public int[][] mySolution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            if (i % 2 == 1) {
                Queue<Integer> copyQueue = new LinkedList<>(queue);
                queue.add(13);
                for (Integer num : copyQueue) {
                    num += 11;
                    if (num / 10 > 3)
                        num -= 30;
                    if (num % 10 > 3)
                        num -= 3;
                    queue.add(num);
                }
            }
            else {
                Queue<Integer> copyQueue = new LinkedList<>(queue);
                queue.add(12);
                for (Integer num : copyQueue) {
                    num += 22;
                    if (num / 10 > 3)
                        num -= 30;
                    if (num % 10 > 3)
                        num -= 3;
                    queue.add(num);
                }
            }
        }
        int count = queue.size();
        int[][] answer = new int[count][2];
        for (int i = 0; i < count; i++) {
            int num = queue.poll();
            int fir = num / 10;
            int sec = num % 10;
            answer[i][0] = fir;
            answer[i][1] = sec;
        }
        return answer;
    }
}
