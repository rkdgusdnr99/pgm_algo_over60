import java.util.*;

public class number82 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int now = queue.poll();
        while (true) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == now) {
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                    now = queue.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[] priorities = {2,1,3,2};
        int[] priorities2 = {1,1,9,1,1,1};


        number82 solution = new number82();
        int result = solution.solution(priorities, 2);
        System.out.println(result);
        int result2 = solution.solution(priorities2, 0);
        System.out.println(result2);
    }
}
