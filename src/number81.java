import java.util.*;

public class number81 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> date = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int d = 0;
            d += (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                d++;
            date.add(d);
        }

        Queue<Integer> answerQueue = new LinkedList<>();
        int now = date.poll();
        int day = 1;
        int temp = 0;
        int sum = progresses.length;

        while (!date.isEmpty()) {
            if (now <= day) {
                temp++;
                now = date.poll();
                if (date.isEmpty() && now > day) {
                    answerQueue.add(temp);
                    sum -= temp;
                }
            }
            else {
                if (temp != 0) {
                    answerQueue.add(temp);
                    sum -= temp;
                    temp = 0;
                }
                day++;
            }
        }

        answerQueue.add(sum);
        int[] answer = new int[answerQueue.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerQueue.poll();
        }
        return answer;
    }

    public int[] wrongSolution(int[] progresses, int[] speeds) {
        Queue<Integer> date = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int d = 0;
            d += (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                d++;
            date.add(d);
        }

        Queue<Integer> answerQueue = new LinkedList<>();
        int now = date.poll();
        int day = 0;
        int temp = 1;
        int sum = progresses.length;
        while (!date.isEmpty()) {
            int next = date.poll();
            if (now + day >= next)
                temp++;
            else {
                answerQueue.add(temp);
                sum -= temp;
                temp = 1;
                now = next;
                day++;
            }
        }
        answerQueue.add(sum);
        int[] answer = new int[answerQueue.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerQueue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시
        int[] progresses = {93, 30, 55};
        int[] speed = {1, 30, 5};
        int[] pro = {95, 90, 99, 99, 80, 99};
        int[] s = {1, 1, 1, 1, 1, 1};

        number81 solution = new number81();
        int[] result = solution.solution(progresses, speed);
        System.out.println(Arrays.toString(result));
        int[] result2 = solution.solution(pro, s);
        System.out.println(Arrays.toString(result2));
    }
}
