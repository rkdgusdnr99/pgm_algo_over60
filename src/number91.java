import java.util.Arrays;

public class number91 {
    public long[] crazySolution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = bigNum(numbers[i]);
        }
        return answer;
    }

    public long bigNum(long numbers) {
        String binary = Long.toBinaryString(numbers);
        int firZero = binary.lastIndexOf('0');

        if (firZero == -1) {
            return Long.parseLong("10" + binary.substring(1), 2);
        }
        else {
            if (firZero < binary.length()-1)
                return Long.parseLong(binary.substring(0, firZero) + "10" + binary.substring(firZero + 2), 2);
            else
                return Long.parseLong(binary.substring(0, firZero) + '1', 2);
        }
    }
    public static void main(String[] args) {
        number91 solution = new number91();
        System.out.println(Arrays.toString(solution.solution(new long[]{2, 7})));
    }
}
