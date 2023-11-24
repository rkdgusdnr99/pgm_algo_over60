import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class number74 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> charQueue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            charQueue.add(c);
        }

        if (isValid(charQueue))
            answer++;

        for (int i = 1; i < charQueue.size(); i++) {
            char temp = charQueue.poll();
            charQueue.add(temp);
            if (isValid(charQueue))
                answer++;
        }
        
        return answer;
    }

    public static boolean isValid(Queue<Character> queue) {
        Queue<Character> copyQueue = new LinkedList<>(queue);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < queue.size(); i++) {
            char c = copyQueue.poll();
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.empty())
                    return false;
                else if (c == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                else if (c == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
                else if (c == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
