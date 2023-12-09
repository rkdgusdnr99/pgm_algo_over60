import java.util.*;

public class number96 {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }
        int num = 0;
        for (int temp : order) {
            if (temp > num) {
                if (queue.isEmpty())
                    return answer;
                while (queue.peek() < temp) {
                    stack.add(queue.poll());
                }
                num = queue.poll();
                answer++;
            }
            else {
                if(stack.isEmpty())
                    return answer;
                if(stack.peek() == temp) {
                    num = stack.pop();
                    answer++;
                }
                else {
                    return answer;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        number96 solution = new number96();
        int[] numbers = {4, 3, 1, 2, 5};
        System.out.println(solution.solution(numbers));
    }
}
