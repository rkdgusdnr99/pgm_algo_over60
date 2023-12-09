import java.util.Stack;

public class number97 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int left = 0;
        while (k > 0 && left < number.length()-k) {
            char max = '0';
            int index = 0;
            for (int i = 0; i <= k; i++) {
                char temp = number.charAt(left + i);
                if (temp == '9') {
                    max = temp;
                    index = i;
                    break;
                }
                if (max < temp) {
                    max = temp;
                    index = i;
                }
            }
            k -= index;
            left += index + 1;
            answer.append(max);
        }
        if (k == 0)
            answer.append(number.substring(left));
        return answer.toString();
    }

    public String goodSolution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        number97 solution = new number97();
        System.out.println(solution.solution("999", 1));
    }
}
