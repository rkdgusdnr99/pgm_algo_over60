import java.util.Arrays;
import java.util.Stack;

public class number88 {

    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= len; i++) {
            answer[len-i] = -1;
            int num = numbers[len-i];
            while (!stack.isEmpty()) {
                if(stack.peek() > num) {
                    answer[len-i] = stack.peek();
                    stack.push(num);
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty())
                stack.push(num);
        }
        return answer;
    }

    public int[] ArraySolution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        int max = 0;
        for (int n : numbers) {
            max = Math.max(max, n);
        }
        int[] temp = new int[max + 1];
        for (int i = 1; i <= len; i++) {
            answer[len-i] = -1;
            int num = numbers[len-i];
            if (temp[num] > num)
                answer[len-i] = temp[num];
            Arrays.fill(temp, 0, num, num);

        }
        return answer;
    }

    public int[] timeOutSolution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        int max = 0;

        for (int i = 1; i <= len; i++) {
            answer[len-i] = -1;
            int now = numbers[len-i];
            if (now >= max) {
                max = now;
                continue;
            }
            for (int j = len-i; j < len; j++) {
                if (numbers[j] > numbers[len-i]) {
                    answer[len-i] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 테스트용 입력값 예시

        number88 solution = new number88();
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 3, 3, 5})));

    }
}
