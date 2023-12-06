import java.util.*;
public class number90 {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> copyQueue = new LinkedList<>();
        copyQueue.add(x);
        while (!copyQueue.isEmpty()) {
            while (!copyQueue.isEmpty()) {
                int num = copyQueue.poll();
                if (num > y)
                    continue;
                else if (num == y)
                    return answer;
                else {
                    set.add(num + n);
                    set.add(num * 2);
                    set.add(num * 3);
                }
            }
            answer++;
            copyQueue = new LinkedList<>(set);
            set.clear();
        }
        return -1;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시

        number90 solution = new number90();
        System.out.println(solution.solution(10, 40, 5));

    }
}
